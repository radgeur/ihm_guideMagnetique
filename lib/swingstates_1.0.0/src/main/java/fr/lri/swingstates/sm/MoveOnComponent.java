package fr.lri.swingstates.sm;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.sm.jtransitions.MouseOnComponent;

/**
 * A transition triggered by a mouse move event on a component with no mouse button down.
 * @author Caroline Appert
 */
public class MoveOnComponent extends MouseOnComponent {

	/**
	 * Builds a transition triggered by a mouse moved event with mo modifier down on a component that loops on the current state.
	 */
	public MoveOnComponent() {
		super(BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered by a mouse motion event on a component that loops on the current state.
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MoveOnComponent(int modifier) {
		super(BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered by a mouse motion event with any modifier on a component.
	 * @param outState The name of the output state
	 */
	public MoveOnComponent(String outState) {
		super(BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds a transition triggered by a mouse motion event on a component.
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public MoveOnComponent(int modifier, String outState) {
		super(BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matches(eventObject, MouseEvent.MOUSE_MOVED);
	}

}
