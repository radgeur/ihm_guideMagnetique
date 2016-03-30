package fr.lri.swingstates.canvas.transitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.canvas.CTag;
import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered when the cursor leaves a CShape with a given tag.
 * 
 * @author Caroline Appert
 */
public class LeaveOnTag extends MouseOnTag {

	/**
	 * Builds a transition triggered when the cursor leaves with any
	 * modifier a tagged shape. This transition loops on the current state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 */
	public LeaveOnTag(String tagName) {
		super(tagName, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered when the cursor leaves with any
	 * modifier a tagged shape. This transition loops on the current state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 */
	public LeaveOnTag(Class tagClass) {
		super(tagClass, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered when the cursor leaves with any
	 * modifier a tagged shape. This transition loops on the current state.
	 * 
	 * @param tag
	 *            The tag
	 */
	public LeaveOnTag(CTag tag) {
		super(tag, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered when the cursor leaves a tagged shape.
	 * This transition loops on the current state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public LeaveOnTag(String tagName, int modifier) {
		super(tagName, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered when the cursor leaves a tagged shape.
	 * This transition loops on the current state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public LeaveOnTag(Class tagClass, int modifier) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered when the cursor leaves a tagged shape.
	 * This transition loops on the current state.
	 * 
	 * @param tag
	 *            The tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public LeaveOnTag(CTag tag, int modifier) {
		super(tag, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered when the cursor leaves with any
	 * modifier a tagged shape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param outState
	 *            The name of the output state
	 */
	public LeaveOnTag(String tagName, String outState) {
		super(tagName, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered when the cursor leaves with any
	 * modifier a tagged shape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param outState
	 *            The name of the output state
	 */
	public LeaveOnTag(Class tagClass, String outState) {
		super(tagClass, BasicInputStateMachine.ANYBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered when the cursor leaves with any
	 * modifier a tagged shape.
	 * 
	 * @param tag
	 *            The tag
	 * @param outState
	 *            The name of the output state
	 */
	public LeaveOnTag(CTag tag, String outState) {
		super(tag, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered when the cursor leaves a tagged shape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public LeaveOnTag(String tagName, int modifier, String outState) {
		super(tagName, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds a transition triggered when the cursor leaves a tagged shape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public LeaveOnTag(Class tagClass, int modifier, String outState) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds a transition triggered when the cursor leaves a tagged shape.
	 * 
	 * @param tag
	 *            The tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public LeaveOnTag(CTag tag, int modifier, String outState) {
		super(tag, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matchesIgnoreButtons(eventObject, MouseEvent.MOUSE_EXITED);
	}
}
