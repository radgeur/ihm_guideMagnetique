package fr.lri.swingstates.canvas.transitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.canvas.CTag;
import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered by a mouse clicked event on a CShape with a given
 * tag. A click is defined as a quick succession of mouse press and mouse
 * release, without significant motion in between. Note that the mouse press
 * and mouse release events are always sent, even when a mouse click event
 * is sent.
 * 
 * @author Caroline Appert
 */
public class ClickOnTag extends MouseOnTag {

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier and any button on a tagged CShape that loops on the current
	 * state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 */
	public ClickOnTag(Class tagClass) {
		super(tagClass);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier and any button on a tagged CShape that loops on the current
	 * state.
	 * 
	 * @param tag
	 *            The tag
	 */
	public ClickOnTag(CTag tag) {
		super(tag);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier and any button on a tagged CShape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param outState
	 *            The name of the output state
	 */
	public ClickOnTag(Class tagClass, String outState) {
		super(tagClass, outState);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier and any button on a tagged CShape.
	 * 
	 * @param tag
	 *            The tag
	 * @param outState
	 *            The name of the output state
	 */
	public ClickOnTag(CTag tag, String outState) {
		super(tag, outState);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier on a tagged CShape that loops on the current state.
	 * 
	 * @param tag
	 *            The tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 */
	public ClickOnTag(CTag tag, int button) {
		super(tag, button);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier on a tagged CShape that loops on the current state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 */
	public ClickOnTag(String tagName, int button) {
		super(tagName, button);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier on a tagged CShape that loops on the current state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 */
	public ClickOnTag(Class tagClass, int button) {
		super(tagClass, button);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event on a tagged
	 * CShape that loops on the current state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public ClickOnTag(String tagName, int button, int modifier) {
		super(tagName, button, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event on a tagged
	 * CShape that loops on the current state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public ClickOnTag(Class tagClass, int button, int modifier) {
		super(tagClass, button, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event on a tagged
	 * CShape that loops on the current state.
	 * 
	 * @param tag
	 *            The tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public ClickOnTag(CTag tag, int button, int modifier) {
		super(tag, button, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier on a tagged CShape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param outState
	 *            The name of the output state
	 */
	public ClickOnTag(String tagName, int button, String outState) {
		super(tagName, button, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier on a tagged CShape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param outState
	 *            The name of the output state
	 */
	public ClickOnTag(Class tagClass, int button, String outState) {
		super(tagClass, button, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier on a tagged CShape.
	 * 
	 * @param tag
	 *            The tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param outState
	 *            The name of the output state
	 */
	public ClickOnTag(CTag tag, int button, String outState) {
		super(tag, button, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event on a tagged
	 * CShape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public ClickOnTag(String tagName, int button, int modifier, String outState) {
		super(tagName, button, modifier, outState);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event on a tagged
	 * CShape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public ClickOnTag(Class tagClass, int button, int modifier, String outState) {
		super(tagClass, button, modifier, outState);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event on a tagged
	 * CShape.
	 * 
	 * @param tag
	 *            The tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public ClickOnTag(CTag tag, int button, int modifier, String outState) {
		super(tag, button, modifier, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matches(eventObject, MouseEvent.MOUSE_CLICKED);
	}
}

