package fr.lri.swingstates.sm.jtransitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered with no modifier on a component.
 * @author Caroline Appert
 */
public class LeaveOnComponent extends MouseOnComponent {

	/**
	 * Builds a transition triggered when the cursor leaves with any modifier a component.
	 */
	public LeaveOnComponent() {
		super(BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered when the cursor leaves a component that loops on the current state.
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public LeaveOnComponent(int modifier) {
		super(BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered when the cursor leaves with any modifier a component. 
	 * @param outState The name of the output state
	 */
	public LeaveOnComponent(String outState) {
		super(BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return matches(eventObject, MouseEvent.MOUSE_EXITED);
	}

}