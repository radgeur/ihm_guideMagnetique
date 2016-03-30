package fr.lri.swingstates.canvas.transitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered by a mouse moved event on a CShape with no mouse
 * button down.
 * 
 * @author Caroline Appert
 */
public class MoveOnShape extends MouseOnShape {

	/**
	 * Builds a transition triggered by a mouse moved event with mo modifier
	 * down on a CShape that loops on the current state.
	 */
	public MoveOnShape() {
		super(BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered by a mouse moved event on a CShape that
	 * loops on the current state.
	 * 
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MoveOnShape(int modifier) {
		super(BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse moved event with any
	 * modifier on a CShape.
	 * 
	 * @param outState
	 *            The name of the output state
	 */
	public MoveOnShape(String outState) {
		super(BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse moved event on a CShape.
	 * 
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public MoveOnShape(int modifier, String outState) {
		super(BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matches(eventObject, MouseEvent.MOUSE_MOVED);
	}
}
