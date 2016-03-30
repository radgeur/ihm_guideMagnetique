/*  
 *   Authors: Caroline Appert (caroline.appert@lri.fr)
 *   Copyright (c) Universite Paris-Sud XI, 2007. All Rights Reserved
 *   Licensed under the GNU LGPL. For full terms see the file COPYING.
 */
package fr.lri.swingstates.sm;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;
import java.util.EventObject;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.RootPaneContainer;
import javax.swing.SwingUtilities;

import fr.lri.swingstates.events.Picker;
import fr.lri.swingstates.events.PickerCMouseEvent;
import fr.lri.swingstates.events.PickerCMouseWheelEvent;
import fr.lri.swingstates.events.PickerEvent;

/**
 * A state machine to monitor events with one or more Component.
 * 
 * <p> The complete list of event types, i.e. classes of transitions, of a JStateMachine is:
 * <ul>
 * <li> <code>Press, PressOnComponent, PressOnTag</code>: pressing a mouse button (anywhere / on a Component / on a Component with a given tag);
 * <li> <code>Release, ReleaseOnComponent, ReleaseOnTag</code>: releasing a mouse button (anywhere / on a Component / on a Component with a given tag);
 * <li> <code>Click, ClickOnComponent, ClickOnTag</code>: clicking (pressing and releasing in quick succession) a mouse button (anywhere / on a Component / on a Component with a given tag);
 * <li> <code>Move, MoveOnComponent, MoveOnTag</code>: moving the mouse with no button pressed (anywhere / on a Component / on a Component with a given tag);
 * <li> <code>Drag, DragOnComponent, DragOnTag</code>: moving the mouse with a button pressed (anywhere / on a Component / on a Component with a given tag);
 * <li> <code>EnterOnComponent, EnterOnTag</code>: cursor enters a Component / a Component with a given tag;
 * <li> <code>LeaveOnComponent, LeaveOnTag</code>: cursor leaves a Component / a Component with a given tag;
 * <li> <code>KeyPress, KeyRelease, KeyType</code>: typing a key (pressing, releasing, press then release in quick succession);
 * <li> <code>TimeOut</code>: delay specified by armTimer expired.
 * </ul>
 * </p>
 *  
 * @see fr.lri.swingstates.sm.BasicInputStateMachine
 * @author Caroline Appert
 *
 */
public class JStateMachine extends BasicInputStateMachine implements MouseListener, MouseMotionListener, KeyListener {

	/**
	 * The picker for this state machine.
	 */
	private class JPicker implements Picker {

		private Component  lastPicked = null;
		private Component  picked     = null;

		/**
		 * Builds a <code>JPicker</code>.
		 */
		public JPicker() { }

		public Component pick(JStateMachine machine, Component component, int x, int y) {
			lastPicked = picked;
//			With a JStateMachine, the components that are under the glasspane stays reachable 
//			by input mouse events. That's why we consider the content pane and not the rootpane for picking
			Container parent = null;
			if(component instanceof Container) {
				parent = (Container)component;
				while(parent != null) {
					if(parent instanceof JComponent) {
						parent = ((JComponent)parent).getTopLevelAncestor();
						if(parent instanceof RootPaneContainer) {
							parent = ((RootPaneContainer)parent).getContentPane();
						}
						break;
					} else {
						if(parent.getParent() != null) parent = parent.getParent();
						else break;
					}
				}

			}
			Point point = SwingUtilities.convertPoint(
					component,
					new Point(x, y),
					parent);
			picked = parent.findComponentAt(point);
			return picked;
		}

		/**
		 * @return The previously picked component.
		 */
		public Component getLastPicked() {
			return lastPicked;
		}

		/**
		 * @return The current picked component.
		 */
		public Component getPicked() {
			return picked;
		}

		public Point2D getLocation() { 
			return null; 
		}

		public void move(Point2D location) { }

	}

	private LinkedList<Component> components;

	private JPicker picker = new JPicker();

	/**
	 * Builds a JStateMachine.
	 */
	public JStateMachine() {
		super();
	}

	/**
	 * Attaches a component to this state machine. 
	 * Events coming on this component and its children are caught by this state machine.
	 * If this component has a glasspane, events will still reach the underlying widgets in a <code>JStateMachine</code>
	 * (the glasspane must be set before calling this <code>attachTo</code> method).
	 * @param c The component to attach.
	 * @return This state machine.
	 */
	public StateMachine attachTo(Component c) {
		if(c == null) return this;
		if(components == null)
			components = new LinkedList<Component>();
		if(components.contains(c)) return this;
		if(c instanceof RootPaneContainer) {
			RootPaneContainer rootPane = (RootPaneContainer)c;
			if(rootPane.getContentPane() != null) register(rootPane.getContentPane());
			if(rootPane.getGlassPane() == null) return this;
			rootPane.getGlassPane().addMouseListener(this);
			rootPane.getGlassPane().addMouseWheelListener(this);
			rootPane.getGlassPane().addMouseMotionListener(this);
			rootPane.getGlassPane().addKeyListener(this);
		} else {
			register(c);
		}
		return this;
	}

	/**
	 * Removes a component from the control of this state machine.
	 * @param c The component to detach.
	 * @return This state machine.
	 */
	public StateMachine detachFrom(Component c) {
		if(c instanceof RootPaneContainer) {
			RootPaneContainer rootPane = (RootPaneContainer)c;
			unregister(rootPane.getContentPane());
			if(rootPane.getGlassPane() == null) return this;
			rootPane.getGlassPane().removeMouseListener(this);
			rootPane.getGlassPane().removeMouseWheelListener(this);
			rootPane.getGlassPane().removeMouseMotionListener(this);
			rootPane.getGlassPane().removeKeyListener(this);
		} else {
			unregister(c);
		}
		return this;
	}


	/**
	 * @return The <code>Component</code>s monitored by this state machine as a linked list.
	 */
	public LinkedList getControlledObjects() {
		return components;
	}

	/**
	 * Adds this state machine as a listener of <code>c</code>
	 * and all its children.
	 * @param c The component to register
	 */
	private void register(Component c) {
		if(! components.contains(c)) {
			components.add(c);
			c.addMouseListener(this);
			c.addMouseMotionListener(this);
			c.addMouseWheelListener(this);
			c.addKeyListener(this);
		}
		if(c instanceof Container) {
			int children = ((Container)c).getComponentCount();
			for(int i = 0; i < children; i++)
				register(((Container)c).getComponent(i));
		}
	}

	/**
	 * Removes this state machine as a listener of <code>c</code>
	 * and all its children.
	 * @param c The component to unregister
	 */
	private void unregister(Component c) {
		c.removeMouseListener(this);
		c.removeMouseMotionListener(this);
		c.removeMouseWheelListener(this);
		c.removeKeyListener(this);
		if(components != null) components.remove(c);
		if(c instanceof Container) {
			int children = ((Container)c).getComponentCount();
			for(int i = 0; i < children; i++)
				unregister(((Container)c).getComponent(i));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseClicked(MouseEvent e) {
		if(!(e instanceof EventFromGlasspane)) doProcessEvent(e);
	}

	/**
	 * {@inheritDoc}
	 */
	public void mousePressed(MouseEvent e) {
		if(!(e instanceof EventFromGlasspane)) doProcessEvent(e);
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseReleased(MouseEvent e) {
		if(!(e instanceof EventFromGlasspane)) doProcessEvent(e);
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseEntered(MouseEvent e) {
		if(!(e instanceof EventFromGlasspane)) processEvent(e);
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseExited(MouseEvent e) {
		if(!(e instanceof EventFromGlasspane)) processEvent(e);
	}

	public static Component getGlassPane(Component component) {
		Container parent = null;
		if(component instanceof Container) {
			parent = (Container)component;
			while(parent != null) {
				if(parent instanceof JComponent) {
					parent = ((JComponent)parent).getTopLevelAncestor();
					if(parent instanceof RootPaneContainer) {
						return ((RootPaneContainer)parent).getGlassPane();
					}
					break;
				} else {
					if(parent.getParent() != null) parent = parent.getParent();
					else break;
				}
			}
		}
		return null;
	}

	/**
	 * A mouse event occuring on the glasspane.
	 * 
	 * @author Caroline Appert
	 *
	 */
	private class EventFromGlasspane extends MouseWheelEvent {
		EventFromGlasspane(Component source, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger, int scrollType, int scrollAmount, int wheelRotation) {
			super(source, id, when, modifiers, x, y, clickCount, popupTrigger, scrollType,
					scrollAmount, wheelRotation);
		}
		EventFromGlasspane(Component source, int id, long when, 
				int modifiers, int x, int y, 
				int clickCount, boolean popupTrigger) {
			super(source, id, when, modifiers, x, y, clickCount, popupTrigger, -1, -1, -1);
		}
		EventFromGlasspane(MouseEvent e) {
			this((Component) e.getSource(), e.getID(), e.getWhen(), 
					e.getModifiers(), e.getX(), e.getY(),
					e.getClickCount(), e.isPopupTrigger());
		}
	}

	private void doProcessEvent(MouseEvent e) {
		Component picked = picker.pick(this, e.getComponent(), e.getX(), e.getY());
		// In awt, the source of a drag is the component where the first mouse pressed occurs
		// In a JStateMachine, if it is a drag event, the source is always the component that is under the cursor
		if(picked != null) {
			Point eventLocation = getPointRelativeToTopLevel(e);
			if(e.getID() == MouseEvent.MOUSE_WHEEL) {
				processEvent(new PickerCMouseWheelEvent(picked, picker,
						e.getID(), e.getWhen(), e.getModifiers(),
						(int)eventLocation.getX(), (int)eventLocation.getY(),
						e.getClickCount(), e.isPopupTrigger(),
						((MouseWheelEvent)e).getScrollType(),
						((MouseWheelEvent)e).getScrollAmount(),
						((MouseWheelEvent)e).getWheelRotation()));
			} else {
				processEvent(new PickerCMouseEvent(picked, picker,
						e.getID(), e.getWhen(), e.getModifiers(),
						(int)eventLocation.getX(), (int)eventLocation.getY(),
						e.getClickCount(), e.isPopupTrigger(), e.getButton()));
			}
			
		}
		// Redispatch and perform picking for mouse events incoming from glasspane
		// so the widgets covered by the glasspane still receive events.
		// (In Swing, a glasspane intercepts all the events)
		// Class of redispatched events is EventFromGlasspane
		// so we filter this type of event in JStateMachine mouse listeners.
		if(picked != null && picked != e.getComponent() && getGlassPane(e.getComponent()) == e.getComponent()) {
			// process enter/leave
			if (picker.lastPicked != picked) {
				if (picker.lastPicked != null) {
					Point pt = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), picker.lastPicked);
					picker.lastPicked.dispatchEvent(new PickerCMouseEvent(picker.lastPicked, picker, MouseEvent.MOUSE_EXITED, 
							System.currentTimeMillis(), 0, 
							pt.x, pt.y, 
							0, false));
				}
				if (picked != null) {
					Point pt = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), picked);
					picked.dispatchEvent(new PickerCMouseEvent(picked, picker, MouseEvent.MOUSE_ENTERED, 
							System.currentTimeMillis(), 0, 
							pt.x, pt.y, 
							0, false));	
				}
			}
			// redispatch to deepest component
			Point pt = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), picker.lastPicked);
			picked.dispatchEvent(
					e.getID() == MouseEvent.MOUSE_WHEEL 
					? new EventFromGlasspane(picked,
							e.getID(), e.getWhen(), e.getModifiers(),
							(int)pt.getX(), (int)pt.getY(),
							e.getClickCount(), e.isPopupTrigger(),
							((MouseWheelEvent)e).getScrollType(),
							((MouseWheelEvent)e).getScrollAmount(),
							((MouseWheelEvent)e).getWheelRotation())
					: new EventFromGlasspane(picked,
							e.getID(), e.getWhen(), e.getModifiers(),
							(int)pt.getX(), (int)pt.getY(),
							e.getClickCount(), e.isPopupTrigger()));
		}
	}
	
	public void processEvent(EventObject event) {
		if((event instanceof ComponentEvent) &&
		!getControlledObjects().contains(((ComponentEvent)event).getComponent()))
			return;
		super.processEvent(event);
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseDragged(MouseEvent e) {
		if(!(e instanceof EventFromGlasspane)) {
			doProcessEvent(e);		
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseMoved(MouseEvent e) {
		if(!(e instanceof EventFromGlasspane))  doProcessEvent(e);
	}

	/**
	 * {@inheritDoc}
	 */
	public void keyTyped(KeyEvent e) {
		processEvent(e);
	}

	/**
	 * {@inheritDoc}
	 */
	public void keyPressed(KeyEvent e) {
		processEvent(e);
	}

	/**
	 * {@inheritDoc}
	 */
	public void keyReleased(KeyEvent e) {
		processEvent(e);
	}

	Point getPointRelativeToTopLevel(MouseEvent e) {
		Container parent = getContentPane(e.getComponent());
		return SwingUtilities.convertPoint(
				e.getComponent(),
				e.getPoint(),
				parent);
	}
	
	public static Container getContentPane(Component c) {
		Container parent = null;
		if(c instanceof Container) {
			parent = (Container)c;
			while(parent != null) {
				if(parent instanceof RootPaneContainer) {
					parent = ((RootPaneContainer)parent).getContentPane();
					break;
				}
				if(parent.getParent() != null) parent = parent.getParent();
				else break;
			}
		}
		return parent;
	}

}
