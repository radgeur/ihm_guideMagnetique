package fr.lri.swingstates.sm;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.EventObject;

import javax.swing.SwingUtilities;

import fr.lri.swingstates.sm.transitions.EventOnPosition;

/**
 * A transition triggered on a JComponent. 
 * OnComponent transitions allow developpers to retrieve the component where this transition has been fired:
 *  <pre>
 * 	Transition tcomponent = new EventOnComponent("anEvent") {
 * 		public void action() {
 * 			// colors in red the component on which the transition has been fired
 * 			getComponent().setBackground(Color.RED);
 * 		}
 * 	}
 * </pre>
 * 	
 * @author Caroline Appert
 */
public abstract class EventOnComponent extends EventOnPosition {

	/**
	 * Builds a transition on a JComponent with no modifier that loops on the current state.
	 * @param keyEvent The string describing the events for which this transition must be triggered
	 */
	public EventOnComponent(String keyEvent) {
		super(keyEvent);
	}

	/**
	 * Builds a transition on a component with no modifier.
	 * @param keyEvent The string describing the events for which this transition must be triggered
	 * @param outState The name of the output state
	 */
	public EventOnComponent(String keyEvent, String outState) {
		super(keyEvent, outState);
	}

	/**
	 * Builds a transition on a JComponent with no modifier that loops on the current state.
	 * This transition can be triggered by any virtual events
	 * whose type is a subclass of <code>eventClass</code>.
	 * @param eventClass The class of events
	 */
	public EventOnComponent(Class eventClass) {
		super(eventClass);
	}

	/**
	 * Builds a transition on a component with no modifier.
	 * This transition can be triggered by any virtual events
	 * whose type is a subclass of <code>eventClass</code>.
	 * @param eventClass The class of events
	 * @param outState The name of the output state
	 */
	public EventOnComponent(Class eventClass, String outState) {
		super(eventClass, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		if(classEvent != null) return "EventOnComponent("+classEvent.getSimpleName()+".class)";
		else return "EventOnComponent("+event+")";
	}

	/**
	 * Returns the component on which the mouse event firing this transition has occured.
	 * @return the JComponent on which the mouse event firing this transition has occured.
	 */
	public Component getComponent() {
		return ((MouseEvent)triggeringEvent).getComponent();
	}

	/**
	 * Returns the location at which this transition 
	 * has occured in the coordinate system of a given component.
	 * @param c the component defining the coordinate system.
	 * @return the location at which the mouse event firing this transition has occured.
	 */
	public Point2D getPointInComponent(Component c) {
		Point point = SwingUtilities.convertPoint(
				JStateMachine.getContentPane(getComponent()),
				new Point((int)getPoint().getX(), (int)getPoint().getY()),
				c);
		return point;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return (eventObject instanceof ComponentEvent) && ((ComponentEvent)eventObject).getComponent() != null;
	}


}