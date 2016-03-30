package fr.lri.swingstates.sm.jtransitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.sm.BasicInputStateMachine;
import fr.lri.swingstates.sm.JTag;

/**
 * A transition triggered when the cursor enters in a component with a given tag.
 * @author Caroline Appert
 */
public class EnterOnJTag extends MouseOnJTag {

	/**
	 * Builds a transition triggered when the cursor enters with any modifier in a tagged component. This transition loops on the current state.
	 * @param tagName The name of the tag 
	 */
	public EnterOnJTag(String tagName) {
		super(tagName,  BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered when the cursor enters with any modifier in a tagged component. This transition loops on the current state.
	 * @param tagClass The class of the tag 
	 */
	public EnterOnJTag(Class tagClass) {
		super(tagClass, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered when the cursor enters with any modifier in a tagged component. This transition loops on the current state.
	 * @param tag The tag 
	 */
	public EnterOnJTag(JTag tag) {
		super(tag, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered when the cursor enters in a tagged component. This transition loops on the current state.
	 * @param tagName The name of the tag 
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public EnterOnJTag(String tagName, int modifier) {
		super(tagName, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered when the cursor enters with any modifier in a tagged component. This transition loops on the current state.
	 * @param tagClass The class of the tag 
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public EnterOnJTag(Class tagClass, int modifier) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered when the cursor enters in a tagged component. This transition loops on the current state.
	 * @param tag The tag 
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public EnterOnJTag(JTag tag, int modifier) {
		super(tag, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered when the cursor enters with any modifier in a tagged component.
	 * @param tagName The name of the tag 
	 * @param outState The name of the output state
	 */
	public EnterOnJTag(String tagName, String outState) {
		super(tagName, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered when the cursor enters with any modifier in a tagged component.
	 * @param tagClass The class of the tag 
	 * @param outState The name of the output state
	 */
	public EnterOnJTag(Class tagClass, String outState) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}


	/**
	 * Builds a transition triggered when the cursor enters with any modifier in a tagged component.
	 * @param tag The tag 
	 * @param outState The name of the output state
	 */
	public EnterOnJTag(JTag tag, String outState) {
		super(tag, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered when the cursor enters in a tagged component.
	 * @param tagName The name of the tag 
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public EnterOnJTag(String tagName, int modifier, String outState) {
		super(tagName, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds a transition triggered when the cursor enters in a tagged component.
	 * @param tagClass The class of the tag 
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public EnterOnJTag(Class tagClass, int modifier, String outState) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds a transition triggered when the cursor enters in a tagged component.
	 * @param tag The tag 
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public EnterOnJTag(JTag tag, int modifier, String outState) {
		super(tag, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matchesIgnoreButtons(eventObject, MouseEvent.MOUSE_ENTERED);
	}

}