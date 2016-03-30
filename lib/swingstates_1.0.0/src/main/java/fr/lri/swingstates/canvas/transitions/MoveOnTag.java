package fr.lri.swingstates.canvas.transitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.canvas.CTag;
import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered by a mouse moved event with no button pressed on a
 * CShape with a given tag.
 * 
 * @author Caroline Appert
 */
public class MoveOnTag extends MouseOnTag {

	/**
	 * Builds a transition triggered by a mouse moved event with any
	 * modifier on a tagged CShape that loops on the current state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 */
	public MoveOnTag(String tagName) {
		super(tagName, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered by a mouse moved event with any
	 * modifier on a tagged CShape that loops on the current state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 */
	public MoveOnTag(Class tagClass) {
		super(tagClass, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered by a mouse moved event with any
	 * modifier on a tagged CShape that loops on the current state.
	 * 
	 * @param tag
	 *            The tag
	 */
	public MoveOnTag(CTag tag) {
		super(tag, BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered by a mouse moved event on a tagged
	 * CShape that loops on the current state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MoveOnTag(String tagName, int modifier) {
		super(tagName, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse moved event on a tagged
	 * CShape that loops on the current state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MoveOnTag(Class tagClass, int modifier) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse moved event on a tagged
	 * CShape that loops on the current state.
	 * 
	 * @param tag
	 *            The tag
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MoveOnTag(CTag tag, int modifier) {
		super(tag, BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse moved event with any
	 * modifier on a tagged CShape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param outState
	 *            The name of the output state
	 */
	public MoveOnTag(String tagName, String outState) {
		super(tagName, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse moved event with any
	 * modifier on a tagged CShape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param outState
	 *            The name of the output state
	 */
	public MoveOnTag(Class tagClass, String outState) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse moved event with any
	 * modifier on a tagged CShape.
	 * 
	 * @param tag
	 *            The tag
	 * @param outState
	 *            The name of the output state
	 */
	public MoveOnTag(CTag tag, String outState) {
		super(tag, BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse moved event on a tagged
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
	public MoveOnTag(String tagName, int modifier, String outState) {
		super(tagName, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds a transition triggered by a mouse moved event on a tagged
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
	public MoveOnTag(Class tagClass, int modifier, String outState) {
		super(tagClass, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds a transition triggered by a mouse moved event on a tagged
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
	public MoveOnTag(CTag tag, int modifier, String outState) {
		super(tag, BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matches(eventObject, MouseEvent.MOUSE_MOVED);
	}
}
