package fr.lri.swingstates.canvas.transitions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.EventObject;

import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered by a mouse wheel event on a CShape with no mouse
 * button down.
 * 
 * @author Caroline Appert
 */
public class WheelOnShape extends MouseOnShape {

	/**
	 * Builds a transition triggered by a mouse wheel event with mo modifier
	 * down on a CShape that loops on the current state.
	 */
	public WheelOnShape() {
		super(BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a CShape that
	 * loops on the current state.
	 * 
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public WheelOnShape(int modifier) {
		super(BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event with any
	 * modifier on a CShape.
	 * 
	 * @param outState
	 *            The name of the output state
	 */
	public WheelOnShape(String outState) {
		super(BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a CShape.
	 * 
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public WheelOnShape(int modifier, String outState) {
		super(BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * @return the number of units that should be scrolled in response to
	 *         this event.
	 * @see java.awt.event.MouseWheelEvent#getScrollAmount()
	 */
	public int getScrollAmount() {
		return ((MouseWheelEvent) triggeringEvent).getScrollAmount();
	}

	/**
	 * @return the type of scrolling that should take place in response to
	 *         this event.
	 * @see java.awt.event.MouseWheelEvent#getScrollType()
	 */
	public int getScrollType() {
		return ((MouseWheelEvent) triggeringEvent).getScrollType();
	}

	/**
	 * @return This is a convenience method to aid in the implementation of
	 *         the common-case MouseWheelListener - to scroll a ScrollPane
	 *         or JScrollPane by an amount which conforms to the platform
	 *         settings.
	 * @see java.awt.event.MouseWheelEvent#getUnitsToScroll()
	 */
	public int getUnitsToScroll() {
		return ((MouseWheelEvent) triggeringEvent).getUnitsToScroll();
	}

	/**
	 * @return the number of "clicks" the mouse wheel was rotated.
	 * @see java.awt.event.MouseWheelEvent#getWheelRotation()
	 */
	public int getWheelRotation() {
		return ((MouseWheelEvent) triggeringEvent).getWheelRotation();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matches(eventObject, MouseEvent.MOUSE_WHEEL);
	}
}
