package fr.lri.swingstates.sm.jtransitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered by a mouse move event on a component with a mouse button down.
 * @author Caroline Appert
 */
public class DragOnComponent extends MouseOnComponent {

	/**
	 * Builds a transition triggered by a mouse dragged event with any modifier on a component that loops on the current state.
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 */
	public DragOnComponent(int button) {
		super(button);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event on a component that loops on the current state.
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public DragOnComponent(int button, int modifier) {
		super(button, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event with any modifier on a component.
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 */
	public DragOnComponent(int button, String outState) {
		super(button, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse dragged event on a component.
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public DragOnComponent(int button, int modifier, String outState) {
		super(button, modifier, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matches(eventObject, MouseEvent.MOUSE_DRAGGED);
	}
}
