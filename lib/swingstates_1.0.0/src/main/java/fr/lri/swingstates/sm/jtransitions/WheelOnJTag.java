package fr.lri.swingstates.sm.jtransitions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.EventObject;

import fr.lri.swingstates.sm.BasicInputStateMachine;
import fr.lri.swingstates.sm.JTag;

/**
 * A transition triggered by a mouse wheel event with no button pressed on a component with a given tag.
 * @author Caroline Appert
 */
public class WheelOnJTag extends MouseOnJTag {

	/**
	 * Builds a transition triggered by a mouse motion event with any modifier on a tagged component that loops on the current state.
	 * @param tagName The name of the tag
	 */
	public WheelOnJTag(String tagName) {
		super(tagName, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event with any modifier on a tagged component that loops on the current state.
	 * @param tagClass The class of the tag
	 */
	public WheelOnJTag(Class tagClass) {
		super(tagClass, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event with any modifier on a tagged component that loops on the current state.
	 * @param tag The tag
	 */
	public WheelOnJTag(JTag tag) {
		super(tag, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a tagged component that loops on the current state.
	 * @param tagName The name of the tag
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public WheelOnJTag(String tagName, int modifier) {
		super(tagName, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a tagged component that loops on the current state.
	 * @param tagClass The class of the tag
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public WheelOnJTag(Class tagClass, int modifier) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a tagged component that loops on the current state.
	 * @param tag The tag
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public WheelOnJTag(JTag tag, int modifier) {
		super(tag, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event with any modifier on a tagged component.
	 * @param tagName The name of the tag
	 * @param outState The name of the output state
	 */
	public WheelOnJTag(String tagName, String outState) {
		super(tagName, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event with any modifier on a tagged component.
	 * @param tagClass The class of the tag
	 * @param outState The name of the output state
	 */
	public WheelOnJTag(Class tagClass, String outState) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event with any modifier on a tagged component.
	 * @param tag The tag
	 * @param outState The name of the output state
	 */
	public WheelOnJTag(JTag tag, String outState) {
		super(tag, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a tagged component.
	 * @param tagName The name of the tag
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public WheelOnJTag(String tagName, int modifier, String outState) {
		super(tagName, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a tagged component.
	 * @param tagClass The class of the tag
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public WheelOnJTag(Class tagClass, int modifier, String outState) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds a transition triggered by a mouse wheel event on a tagged component.
	 * @param tag The tag
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public WheelOnJTag(JTag tag, int modifier, String outState) {
		super(tag, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * @return the number of units that should be scrolled in response to this event.
	 * @see java.awt.event.MouseWheelEvent#getScrollAmount()
	 */
	public int getScrollAmount() {
		return ((MouseWheelEvent)triggeringEvent).getScrollAmount();
	}

	/**
	 * @return the type of scrolling that should take place in response to this event.
	 * @see java.awt.event.MouseWheelEvent#getScrollType()
	 */
	public int getScrollType() {
		return ((MouseWheelEvent)triggeringEvent).getScrollType();
	}

	/**
	 * @return This is a convenience method to aid in the implementation of the common-case MouseWheelListener 
	 * - to scroll a ScrollPane or JScrollPane by an amount which conforms to the platform settings.
	 * @see java.awt.event.MouseWheelEvent#getUnitsToScroll()
	 */
	public int getUnitsToScroll() {
		return ((MouseWheelEvent)triggeringEvent).getUnitsToScroll();
	}

	/**
	 * @return the number of "clicks" the mouse wheel was rotated.
	 * @see java.awt.event.MouseWheelEvent#getWheelRotation()
	 */
	public int getWheelRotation() {
		return ((MouseWheelEvent)triggeringEvent).getWheelRotation();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matches(eventObject, MouseEvent.MOUSE_WHEEL);
	}
}
