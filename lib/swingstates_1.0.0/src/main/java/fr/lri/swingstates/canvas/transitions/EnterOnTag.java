package fr.lri.swingstates.canvas.transitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.canvas.CTag;
import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered when the cursor enters in a CShape 
 * that holds a given
 * tag.
 * 
 * @author Caroline Appert
 */
public class EnterOnTag extends MouseOnTag {

	/**
	 * Builds a transition triggered when the cursor enters with any
	 * modifier in a tagged shape. This transition loops on the current
	 * state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 */
	public EnterOnTag(String tagName) {
		super(tagName, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered when the cursor enters with any
	 * modifier in a tagged shape. This transition loops on the current
	 * state.
	 * 
	 * @param tagClass
	 *            The clas of the tag
	 */
	public EnterOnTag(Class tagClass) {
		super(tagClass, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered when the cursor enters with any
	 * modifier in a tagged shape. This transition loops on the current
	 * state.
	 * 
	 * @param tag
	 *            The tag
	 */
	public EnterOnTag(CTag tag) {
		super(tag, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered when the cursor enters in a tagged
	 * shape. This transition loops on the current state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public EnterOnTag(String tagName, int modifier) {
		super(tagName, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered when the cursor enters with any
	 * modifier in a tagged shape. This transition loops on the current
	 * state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public EnterOnTag(Class tagClass, int modifier) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered when the cursor enters in a tagged
	 * shape. This transition loops on the current state.
	 * 
	 * @param tag
	 *            The tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public EnterOnTag(CTag tag, int modifier) {
		super(tag, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered when the cursor enters with any
	 * modifier in a tagged shape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param outState
	 *            The name of the output state
	 */
	public EnterOnTag(String tagName, String outState) {
		super(tagName, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered when the cursor enters with any
	 * modifier in a tagged shape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param outState
	 *            The name of the output state
	 */
	public EnterOnTag(Class tagClass, String outState) {
		super(tagClass, BasicInputStateMachine.ANYBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered when the cursor enters with any
	 * modifier in a tagged shape.
	 * 
	 * @param tag
	 *            The tag
	 * @param outState
	 *            The name of the output state
	 */
	public EnterOnTag(CTag tag, String outState) {
		super(tag, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered when the cursor enters in a tagged
	 * shape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public EnterOnTag(String tagName, int modifier, String outState) {
		super(tagName, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds a transition triggered when the cursor enters in a tagged
	 * shape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public EnterOnTag(Class tagClass, int modifier, String outState) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds a transition triggered when the cursor enters in a tagged
	 * shape.
	 * 
	 * @param tag
	 *            The tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public EnterOnTag(CTag tag, int modifier, String outState) {
		super(tag, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matchesIgnoreButtons(eventObject, MouseEvent.MOUSE_ENTERED);
	}
}
