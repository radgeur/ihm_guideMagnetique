package fr.lri.swingstates.canvas.transitions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.EventObject;

import fr.lri.swingstates.canvas.CTag;
import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered by a mouse wheel event with no button pressed on a
 * CShape with a given tag.
 * 
 * @author Caroline Appert
 */
public class WheelOnTag extends MouseOnTag {

	/**
	 * Builds a transition triggered by a mouse wheel event with any
	 * modifier on a tagged CShape that loops on the current state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 */
	public WheelOnTag(String tagName) {
		super(tagName, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event with any
	 * modifier on a tagged CShape that loops on the current state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 */
	public WheelOnTag(Class tagClass) {
		super(tagClass, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event with any
	 * modifier on a tagged CShape that loops on the current state.
	 * 
	 * @param tag
	 *            The tag
	 */
	public WheelOnTag(CTag tag) {
		super(tag, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a tagged
	 * CShape that loops on the current state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public WheelOnTag(String tagName, int modifier) {
		super(tagName, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a tagged
	 * CShape that loops on the current state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public WheelOnTag(Class tagClass, int modifier) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a tagged
	 * CShape that loops on the current state.
	 * 
	 * @param tag
	 *            The tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public WheelOnTag(CTag tag, int modifier) {
		super(tag, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event with any
	 * modifier on a tagged CShape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param outState
	 *            The name of the output state
	 */
	public WheelOnTag(String tagName, String outState) {
		super(tagName, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event with any
	 * modifier on a tagged CShape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param outState
	 *            The name of the output state
	 */
	public WheelOnTag(Class tagClass, String outState) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event with any
	 * modifier on a tagged CShape.
	 * 
	 * @param tag
	 *            The tag
	 * @param outState
	 *            The name of the output state
	 */
	public WheelOnTag(CTag tag, String outState) {
		super(tag, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a tagged
	 * CShape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public WheelOnTag(String tagName, int modifier, String outState) {
		super(tagName, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a tagged
	 * CShape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public WheelOnTag(Class tagClass, int modifier, String outState) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a tagged
	 * CShape.
	 * 
	 * @param tag
	 *            The tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public WheelOnTag(CTag tag, int modifier, String outState) {
		super(tag, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * @return the number of units that should be scrolled in response to
	 *         this event.
	 * @see java.awt.event.MouseWheelEvent#getScrollAmount()
	 */
	public int getScrollAmount() {
		return ((MouseWheelEvent) triggeringEvent).getWheelRotation();
	}

	/**
	 * @return the type of scrolling that should take place in response to
	 *         this event.
	 * @see java.awt.event.MouseWheelEvent#getScrollType()
	 */
	public int getScrollType() {
		return ((MouseWheelEvent) triggeringEvent).getWheelRotation();
	}

	/**
	 * @return This is a convenience method to aid in the implementation of
	 *         the common-case MouseWheelListener - to scroll a ScrollPane
	 *         or JScrollPane by an amount which conforms to the platform
	 *         settings.
	 * @see java.awt.event.MouseWheelEvent#getUnitsToScroll()
	 */
	public int getUnitsToScroll() {
		return ((MouseWheelEvent) triggeringEvent).getWheelRotation();
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
