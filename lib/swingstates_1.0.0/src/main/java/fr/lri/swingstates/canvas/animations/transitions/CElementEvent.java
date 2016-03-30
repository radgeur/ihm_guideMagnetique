package fr.lri.swingstates.canvas.animations.transitions;

import java.util.EventObject;

import fr.lri.swingstates.canvas.CElement;
import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.CTag;
import fr.lri.swingstates.canvas.Canvas;
import fr.lri.swingstates.events.VirtualCElementEvent;
import fr.lri.swingstates.sm.transitions.Event;

/**
 * <p>
 * A transition triggered by a <code>CElement</code> each time this
 * <code>CElement</code> is modified. For example, one can want to track
 * the potential collisions of a given shape <code>ball</code> with the
 * left edge of the canvas.
 * 
 * <pre>
 * 	Transition tshape = CElementEvent(ball) {
 * 		public boolean guard() {
 * 			return ((CShape)getCElement()).getMinX() &lt; 0;
 * 		}
 * 		public void action() {
 * 			... // do something
 * 		}
 * 	}
 * 	
 * </pre>
 * 
 * </p>
 * 
 * @author Caroline Appert
 */
public class CElementEvent extends Event {

	CElement element;

	/**
	 * Builds a transition that loops on the current state triggered by any
	 * changes on a <code>CElement</code>.
	 * 
	 * @param cElement
	 *            The <code>CElement</code> to track.
	 */
	public CElementEvent(CElement cElement) {
		super("");
		element = cElement;
	}

	/**
	 * Builds a transition triggered by any changes on a
	 * <code>CElement</code>.
	 * 
	 * @param cElement
	 *            The <code>CElement</code> to track.
	 * @param outState
	 *            The name of the output state.
	 */
	public CElementEvent(CElement cElement, String outState) {
		super("", outState);
		element = cElement;
	}

	/**
	 * @return the <code>CElement</code> that has just triggered this
	 *         animation.
	 */
	public CElement getCElement() {
		return element;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		if (!(eventObject instanceof VirtualCElementEvent)) {
			return false;
		}
		VirtualCElementEvent vce = (VirtualCElementEvent) eventObject;
		CElement elementThatTriggered = vce.getCElement();
		if (element instanceof CShape) {
			return element == elementThatTriggered;
		}
		if (element instanceof CTag) {
			return elementThatTriggered.hasTag((CTag) element);
		}
		if (element instanceof Canvas) {
			return elementThatTriggered.getCanvas() == element;
		}
		return false;
	}

	/**
	 * @return the event that has just triggered this transition.
	 */
	public VirtualCElementEvent getCElementEvent() {
		return (VirtualCElementEvent) triggeringEvent;
	}
}
