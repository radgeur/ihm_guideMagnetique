package fr.lri.swingstates.sm.jtransitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.sm.BasicInputStateMachine;
import fr.lri.swingstates.sm.JTag;

/**
 * A transition triggered by a mouse moved event with a button pressed on a component with a given tag.
 * @author Caroline Appert
 */
public class DragOnJTag extends MouseOnJTag {

	/**
	 * Builds a transition triggered by a mouse dragged event with any modifier on a component that loops on the current state.
	 * @param tagName The name of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 */
	public DragOnJTag(String tagName, int button) {
		super(tagName,  button);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event with any modifier on a component that loops on the current state.
	 * @param tagClass The class of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 */
	public DragOnJTag(Class tagClass, int button) {
		super(tagClass,  button);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event with any modifier on a component that loops on the current state.
	 * @param tag The tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 */
	public DragOnJTag(JTag tag, int button) {
		super(tag,  button);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event on a component that loops on the current state.
	 * @param tagName The name of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public DragOnJTag(String tagName, int button, int modifier) {
		super(tagName,  button, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event on a component that loops on the current state.
	 * @param tagClass The class of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public DragOnJTag(Class tagClass, int button, int modifier) {
		super(tagClass,  button, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event on a component that loops on the current state.
	 * @param tag The tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public DragOnJTag(JTag tag, int button, int modifier) {
		super(tag,  button, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event with any modifier on a component.
	 * @param tagName The name of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 */
	public DragOnJTag(String tagName, int button, String outState) {
		super(tagName,  button, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event with any modifier on a component.
	 * @param tagClass The class of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 */
	public DragOnJTag(Class tagClass, int button, String outState) {
		super(tagClass,  button, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event with any modifier on a component.
	 * @param tag The tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 */
	public DragOnJTag(JTag tag, int button, String outState) {
		super(tag,  button, BasicInputStateMachine.ANYMODIFIER, outState);
	}


	/**
	 * Builds a transition triggered by a mouse dragged event on a component.
	 * @param tagName The name of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public DragOnJTag(String tagName, int button, int modifier, String outState) {
		super(tagName,  button, modifier, outState);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event on a component.
	 * @param tagClass The class of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public DragOnJTag(Class tagClass, int button, int modifier, String outState) {
		super(tagClass,  button, modifier, outState);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event on a component.
	 * @param tag The tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public DragOnJTag(JTag tag, int button, int modifier, String outState) {
		super(tag,  button, modifier, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matches(eventObject, MouseEvent.MOUSE_DRAGGED);
	}
}
