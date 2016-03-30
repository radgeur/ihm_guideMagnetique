/*  
 *   Authors: Caroline Appert (caroline.appert@lri.fr)
 *   Copyright (c) Universite Paris-Sud XI, 2007. All Rights Reserved
 *   Licensed under the GNU LGPL. For full terms see the file COPYING.
 */
package fr.lri.swingstates.canvas;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import fr.lri.swingstates.sm.BasicInputStateMachine;
import fr.lri.swingstates.sm.Transition;

/**
 * <p>
 * A state machine to handle events with one or more <code>CElement</code> (<code>Canvas</code>,
 * <code>CTag</code> or <code>CShape</code>).
 * </p>
 * 
 * <p>
 * A <code>CStateMachine</code> handles events handled by a
 * <code>BasicInputStateMachine</code> plus the following list:
 * <ul>
 * <li> <code>PressOnShape</code>, <code>PressOnTag</code>: pressing a
 * mouse button on a shape / on a shape with a given tag;
 * <li> <code>ReleaseOnShape</code>, <code>ReleaseOnTag</code>: releasing
 * a mouse button on a shape / on a shape with a given tag;
 * <li> <code>ClickOnShape</code>, <code>ClickOnTag</code>: clicking
 * (pressing and releasing in quick succession) a mouse button on a shape / on a
 * shape with a given tag;
 * <li> <code>MoveOnShape</code>, <code>MoveOnTag</code>: moving the mouse
 * with no button pressed on a shape / on a shape with a given tag;
 * <li> <code>DragOnShape</code>, <code>DragOnTag</code>: moving the mouse
 * with a button pressed on a shape / on a shape with a given tag;
 * <li> <code>WheelOnShape</code>, <code>WheelOnTag</code>: rotating the
 * mouse wheel on a shape / on a shape with a given tag;
 * <li> <code>EnterOnShape</code>, <code>EnterOnTag</code>: cursor enters
 * a shape / a shape with a given tag;
 * <li> <code>LeaveOnShape</code>, <code>LeaveOnTag</code>: cursor leaves
 * a shape / a shape with a given tag;
 * <li> <code>AnimationStarted</code>, <code>AnimationStopped</code>,
 * <code>AnimationSuspended</code> and <code>AnimationResumed</code>: a
 * given animation has started, stopped, been suspended or been resumed.
 * <li> <code>CElementEvent</code>: a given graphical element has changed.
 * </ul>
 * </p>
 * 
 * @see fr.lri.swingstates.sm.BasicInputStateMachine
 * @author Caroline Appert
 * 
 */
public abstract class CStateMachine extends BasicInputStateMachine {

	LinkedList<CElement> controlledObjects = new LinkedList<CElement>();

	/**
	 * The key string of events that triggered <code>AnimationStopped</code> transitions.
	 */
	public static String ANIMATION_STOPPED   = "AnimationStopped";
	/**
	 * The key string of events that triggered <code>AnimationStarted</code> transitions.
	 */
	public static String ANIMATION_STARTED   = "AnimationStarted";
	/**
	 * The key string of events that triggered <code>AnimationSuspended</code> transitions.
	 */
	public static String ANIMATION_SUSPENDED = "AnimationSuspended";
	/**
	 * The key string of events that triggered <code>AnimationResumed</code> transitions.
	 */
	public static String ANIMATION_RESUMED   = "AnimationResumed";

	/**
	 * Builds a CStateMachine.
	 */
	public CStateMachine() {
		super();
	}

	/**
	 * Builds a CStateMachine.
	 * 
	 * @param ce
	 *            The canvas element whose events must be handled by this state
	 *            machine.
	 */
	public CStateMachine(CElement ce) {
		super();
		attachTo(ce, true);
	}

	/**
	 * Attaches a state machine to a given <code>CElement</code>. Attaching a CStateMachine to 
	 * a CElement (a shape, a tag or a canvas) causes the transitions *OnShape and *OnTag
	 * (e.g. PressOnShape, PressOnTag, ReleaseOnShape...)
	 * to be fired only on shapes that are parts of the attached element. Note that 
	 * all other transitions that can occur anywhere (e.g. Press, Release...) remains <i>firable</i>.
	 * 
	 * <p>
	 * For example, the transition <code>t1</code> will be fired only if a mouse press occurs on
	 * a shape that holds the tag <code>movable</code> while the transition <code>t2</code> will still be
	 * fired by any mouse press event on the canvas:
	 * </p>
	 * <pre>
	 * CStateMachine machine = new CStateMachine() {
	 *    State start = new State() {
	 *       Transition t1 = new PressOnShape(BUTTON1, ">> moveShape") {
	 *       	...
	 *       };
	 *       Transition t2 = new Press(BUTTON1, ">> panView") {
	 *       	...
	 *       };
	 *    };
	 *    State moveShape = new State() {
	 *       ...
	 *    };
	 *    State panView = new State() {
	 *       ...
	 *    };
	 *    ...
	 * };
	 * ...
	 * CTag movable = ...;
	 * ...
	 * machine.attachTo(movable);
	 * </pre>
	 * 
	 * @param ce
	 *            The <code>CElement</code> to which this state machine
	 *            must be attached.
	 * @param reset
	 *            Whether or not the state machine must be reset.
	 *            
	 */
	public void attachTo(CElement ce, boolean reset) {
		if (controlledObjects == null)
			controlledObjects = new LinkedList<CElement>();
		if (!controlledObjects.contains(ce)) {
			ce.getCanvas().attachListeners();
			controlledObjects.add(ce);
			ce.getCanvas().registerMachine(this);
		}
		if (reset)
			reset();
	}

	/**
	 * Attaches a state machine to a given <code>CElement</code> and
	 * resets it.
	 * 
	 * @param ce
	 *            The <code>CElement</code> to which this state machine
	 *            must be attached.
	 * 
	 * @see CStateMachine#attachTo(CElement, boolean)
	 */
	public void attachTo(CElement ce) {
		attachTo(ce, true);
	}

	/**
	 * Tests if this state machine is attached to a given <code>CElement</code>
	 * object.
	 * 
	 * @param ce
	 *            The <code>CElement</code> object to test
	 * @return true if this state machine is attached to <code>ce</code>.
	 */
	public boolean isAttachedTo(CElement ce) {
		return controlledObjects.contains(ce);
	}

	/**
	 * Returns the linked list of <code>CElement</code> objects to which this
	 * state machine is attached, or null is the machine is not attached.
	 * 
	 * @return the linked list of <code>CElement</code> objects to which this
	 *         state machine is attached.
	 */
	public LinkedList<CElement> getControlledObjects() {
		if (controlledObjects == null)
			return null;
		if (controlledObjects.size() == 0)
			return null;
		return controlledObjects;
	}

	/**
	 * Tests whether or not one this state machine has a transition of a given
	 * class <code>cl</code>.
	 * 
	 * @param cl
	 *            The class of transitions
	 * @return true if the current state of this state machine contains a
	 *         transition of class <code>cl</code>.
	 */
	protected boolean hasTransitionOfClass(Class<?> cl) {
		for (Iterator<Transition> i = currentState.getTransitions().iterator(); i.hasNext();) {
			Transition nextTrans = i.next();
			if (cl.isAssignableFrom(nextTrans.getClass()))
				return true;
		}
		return false;
	}

	/**
	 * Detaches a state machine from a <code>CElement</code> object. Does
	 * nothing if it was not attached.
	 * 
	 * @param ce
	 *            The <code>CElement</code> object from which this state
	 *            machine must be detached
	 */
	public void detach(CElement ce) {
		controlledObjects.remove(ce);
		if (controlledObjects.size() == 0) {
			ce.getCanvas().detachListeners();
		}
	}

	public boolean controls(CShape source) {
		if (!isActive())
			return false;
		boolean isSourceControlled = false;
		if (source != null) {
			for (ListIterator<CElement> i = controlledObjects.listIterator(); i.hasNext();) {
				CElement next = i.next();
				if (((next instanceof Canvas) && (source.getCanvas() == next)) || ((next instanceof CShape) && (source == next)) || ((next instanceof CTag) && (source.hasTag((CTag) next)))) {
					isSourceControlled = true;
					break;
				}
			}
		}
		return isSourceControlled;
	}

	/**
	 * Makes this state machine having a lower priority than another state
	 * machine. Assume two machines m1 and m2 have priorities p1 and p2. 
	 * If p1 < p2, m1 receives the event after m2 has received it. 
	 * This state machine is placed just before smGreater 
	 * (priority of smGreater is unchanged).
	 * 
	 * @param smGreater
	 *            The state machine that must have a greater priority than
	 *            smLower.
	 * @param canvas
	 *            The canvas.
	 */
	public void lowerPriorityThan(CStateMachine smGreater, Canvas canvas) {
		synchronized(canvas.stateMachines) {
			if (canvas.stateMachines.remove(this)) {
				int i = canvas.stateMachines.indexOf(smGreater);
				if (i != -1) {
					if ((i + 1) < canvas.stateMachines.size()) {
						canvas.stateMachines.add(i + 1, this);
					} else {
						canvas.stateMachines.add(this);
					}
				}
			}
		}
	}
	
	/**
	 * Makes this state machine have the lowest priority. This state machines
	 * will receive events after every state machine has received it.
	 * 
	 * @param canvas
	 *            The canvas.
	 * @return this state machine.
	 */
	public CStateMachine lowestPriority(Canvas canvas) {
		synchronized(canvas.stateMachines) {
			if (canvas.stateMachines.remove(this))
				canvas.stateMachines.add(this);
		}
		return this;
	}

	/**
	 * Makes this state machine have a greater priority than another state
	 * machine. Assume two machines m1 and m2 have priorities p1 and p2. 
	 * If p1 < p2, m1 receives the event after m2 has received it. 
	 * This state machine is placed just after smLower 
	 * (priority of smLower is unchanged).
	 * 
	 * @param smLower
	 *            The state machine that must have a lower priority than
	 *            smGreater.
	 * @param canvas
	 *            The canvas.
	 * @return this state machine.
	 */
	public CStateMachine greaterPriorityThan(CStateMachine smLower, Canvas canvas) {
		synchronized(canvas.stateMachines) {
			if (canvas.stateMachines.remove(this)) {
				int i = canvas.stateMachines.indexOf(smLower);
				if (i != -1) {
					canvas.stateMachines.add(i, this);
				}
			}
		}
		return this;
	}

	/**
	 * Makes this state machine have the greatest priority. This state machines
	 * will receive events before every state machine has received it.
	 * 
	 * @param canvas
	 *            The canvas.
	 * @return this state machine.
	 */
	public CStateMachine greatestPriority(Canvas canvas) {
		synchronized(canvas.stateMachines) {
			if (canvas.stateMachines.remove(this))
				canvas.stateMachines.add(0, this);
		}
		return this;
	}

}
