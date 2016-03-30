package fr.lri.swingstates.sm.jtransitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.sm.BasicInputStateMachine;
import fr.lri.swingstates.sm.JTag;

/**
 * A transition triggered by a mouse pressed event on a component with a given tag.
 * @author Caroline Appert
 */
public class PressOnJTag extends MouseOnJTag {

	/**
	 * Builds a transition triggered by a mouse pressed event with any modifier on a tagged component that loops on the current state.
	 * @param tagName The name of the tag 
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 */
	public PressOnJTag(String tagName, int button) {
		super(tagName,  button);
	}

	/**
	 * Builds a transition triggered by a mouse pressed event with any modifier on a tagged component that loops on the current state.
	 * @param tagClass The class of the tag 
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 */
	public PressOnJTag(Class tagClass, int button) {
		super(tagClass,  button);
	}

	/**
	 * Builds a transition triggered by a mouse pressed event with any modifier on a tagged component that loops on the current state.
	 * @param tag The tag 
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 */
	public PressOnJTag(JTag tag, int button) {
		super(tag,  button);
	}

	/**
	 * Builds a transition triggered by a mouse pressed event on a tagged component that loops on the current state.
	 * @param tagName The name of the tag 
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public PressOnJTag(String tagName, int button, int modifier) {
		super(tagName,  button, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse pressed event on a tagged component that loops on the current state.
	 * @param tagClass The class of the tag 
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public PressOnJTag(Class tagClass, int button, int modifier) {
		super(tagClass,  button, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse pressed event on a tagged component that loops on the current state.
	 * @param tag The tag 
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public PressOnJTag(JTag tag, int button, int modifier) {
		super(tag,  button, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse pressed event with any modifier on a tagged component.
	 * @param tagName The name of the tag 
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 */
	public PressOnJTag(String tagName, int button, String outState) {
		super(tagName,  button, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse pressed event with any modifier on a tagged component.
	 * @param tagClass The class of the tag 
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 */
	public PressOnJTag(Class tagClass, int button, String outState) {
		super(tagClass,  button, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse pressed event with any modifier on a tagged component.
	 * @param tag The tag 
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 */
	public PressOnJTag(JTag tag, int button, String outState) {
		super(tag,  button, BasicInputStateMachine.ANYMODIFIER, outState);
	}


	/**
	 * Builds a transition triggered by a mouse pressed event on a tagged component.
	 * @param tagName The name of the tag 
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public PressOnJTag(String tagName, int button, int modifier, String outState) {
		super(tagName, button, modifier, outState);
	}

	/**
	 * Builds a transition triggered by a mouse pressed event on a tagged component.
	 * @param tagClass The class of the tag 
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public PressOnJTag(Class tagClass, int button, int modifier, String outState) {
		super(tagClass, button, modifier, outState);
	}

	/**
	 * Builds a transition triggered by a mouse pressed event on a tagged component.
	 * @param tag The tag 
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public PressOnJTag(JTag tag, int button, int modifier, String outState) {
		super(tag,  button, modifier, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matches(eventObject, MouseEvent.MOUSE_PRESSED);
	}
}
