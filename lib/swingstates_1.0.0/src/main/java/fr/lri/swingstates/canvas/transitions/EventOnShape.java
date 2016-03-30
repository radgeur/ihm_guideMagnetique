package fr.lri.swingstates.canvas.transitions;

import java.awt.geom.Point2D;
import java.util.EventObject;

import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.events.VirtualCanvasEvent;
import fr.lri.swingstates.sm.transitions.EventOnPosition;

/**
 * <p>
 * A transition triggered on a CShape in the canvas. OnShape transitions
 * allow developpers to retrieve the shape in the canvas where this
 * transition has been fired:
 * 
 * <pre>
 * 	Transition tshape = new EventOnShape (&quot;anEvent&quot;) {
 * 		public void action() {
 * 			// colors in red the shape on which the transition has been fired
 * 			getShape().setFillPaint(Color.RED);
 * 		}
 * 	}
 * 	
 * </pre>
 * 
 * </p>
 * 
 * @author Caroline Appert
 */
public abstract class EventOnShape extends EventOnPosition {

	/**
	 * Builds a transition on a CShape with no modifier that loops on the
	 * current state.
	 * 
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered
	 */
	public EventOnShape(String keyEvent) {
		super(keyEvent);
	}

	/**
	 * Builds a transition on a CShape with no modifier.
	 * 
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered
	 * @param outState
	 *            The name of the output state
	 */
	public EventOnShape(String keyEvent, String outState) {
		super(keyEvent, outState);
	}

	/**
	 * Builds a transition on a CShape with no modifier that can be
	 * triggered by any virtual events whose type is a subclass of
	 * <code>eventClass</code>.
	 * 
	 * @param eventClass
	 *            The class of events
	 * @param outState
	 *            The name of the output state
	 */
	public EventOnShape(Class eventClass, String outState) {
		super(eventClass, outState);
	}

	/**
	 * Builds a transition on a CShape with no modifier that can be
	 * triggered by any virtual events whose type is a subclass of
	 * <code>eventClass</code>.
	 * 
	 * @param eventClass
	 *            The class of events
	 */
	public EventOnShape(Class eventClass) {
		super(eventClass);
	}

	/**
	 * Returns the CShape on which the event firing this transition has
	 * occured.
	 * 
	 * @return the CShape on which the event firing this transition has
	 *         occured.
	 */
	public CShape getShape() {
		return ((VirtualCanvasEvent)triggeringEvent).getShape();
	}


	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		if (classEvent != null)
			return "EventOnShape(" + classEvent.getSimpleName() + ".class)";
		else
			return "EventOnShape(" + event + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	public Point2D getPoint() {
		return ((VirtualCanvasEvent)triggeringEvent).getPoint();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		if (super.matches(eventObject)) {
			VirtualCanvasEvent vse = (VirtualCanvasEvent)eventObject;
			return vse.getShape() != null;
		}
		return false;
	}
	
	public boolean pickingRequired() {
		return true;
	}
}

