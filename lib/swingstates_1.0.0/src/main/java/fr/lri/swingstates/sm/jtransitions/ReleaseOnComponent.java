package fr.lri.swingstates.sm.jtransitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered by a mouse button released on a component.
 * @author Caroline Appert
 */
public class ReleaseOnComponent extends MouseOnComponent {

	/**
	 * Builds a transition triggered by a mouse released event with any modifier on a component that loops on the current state.
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 */
	public ReleaseOnComponent(int button) {
		super(button);
	}

	/**
	 * Builds a transition triggered by a mouse released event on a component that loops on the current state.
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public ReleaseOnComponent(int button, int modifier) {
		super(button, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse released event with any modifier on a component.
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 */
	public ReleaseOnComponent(int button, String outState) {
		super(button, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse released event on a component.
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public ReleaseOnComponent(int button, int modifier, String outState) {
		super(button, modifier, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matches(eventObject, MouseEvent.MOUSE_RELEASED);
	}

}
