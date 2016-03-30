package fr.lri.swingstates.canvas.transitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered by a mouse button clicked on a CShape. A click is
 * defined as a quick succession of mouse press and mouse release, without
 * significant motion in between. Note that the mouse press and mouse
 * release events are always sent, even when a mouse click event is sent.
 * 
 * @author Caroline Appert
 */
public class ClickOnShape extends MouseOnShape {

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier and any button on a CShape that loops on the current state.
	 */
	public ClickOnShape() {
		super();
	}

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier on a CShape.
	 * 
	 * @param outState
	 *            The name of the output state
	 */
	public ClickOnShape(String outState) {
		super(outState);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier on a CShape that loops on the current state.
	 * 
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 */
	public ClickOnShape(int button) {
		super(button);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event on a CShape
	 * that loops on the current state.
	 * 
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public ClickOnShape(int button, int modifier) {
		super(button, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event with any
	 * modifier on a CShape.
	 * 
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param outState
	 *            The name of the output state
	 */
	public ClickOnShape(int button, String outState) {
		super(button, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse clicked event on a CShape.
	 * 
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState
	 *            The name of the output state
	 */
	public ClickOnShape(int button, int modifier, String outState) {
		super(button, modifier, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matches(eventObject, MouseEvent.MOUSE_CLICKED);
	}
}
