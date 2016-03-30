package fr.lri.swingstates.sm.jtransitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * 
 * A Transition triggered when the mouse enters in a JComponent.
 * 
 * @author Caroline Appert
 *
 */
public class EnterOnComponent extends MouseOnComponent {

	/**
	 * Builds an Enter transition.
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 * @param outState The name of the output state
	 */
	public EnterOnComponent(int modifier, String outState) {
		super(BasicInputStateMachine.NOBUTTON, modifier, outState);
	}

	/**
	 * Builds an Enter transition that loops on the current state.
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public EnterOnComponent(int modifier) {
		super(BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds an Enter transition with no modifier.
	 * @param outState The name of the output state
	 */
	public EnterOnComponent(String outState) {
		super(BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * Builds an Enter transition with no modifier that loops on the current state.
	 */
	public EnterOnComponent() {
		super(BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		boolean b = matchesIgnoreButtons(eventObject, MouseEvent.MOUSE_ENTERED);
		return b;
	}

}

