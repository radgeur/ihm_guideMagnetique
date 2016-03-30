package fr.lri.swingstates.canvas.transitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.events.PickerCEvent;
import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered when mouse cursor leaves a CShape.
 * 
 * @author Caroline Appert
 */
public class LeaveOnShape extends MouseOnShape {

	/**
	 * Builds a transition triggered when the cursor leaves with any
	 * modifier a CShape.
	 */
	public LeaveOnShape() {
		super(BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered when the cursor leaves a CShape that
	 * loops on the current state.
	 * 
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public LeaveOnShape(int modifier) {
		super(BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered when the cursor leaves with any
	 * modifier a CShape.
	 * 
	 * @param outState
	 *            The name of the output state
	 */
	public LeaveOnShape(String outState) {
		super(BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		if (!(eventObject instanceof PickerCEvent))
			return false;
		return matchesIgnoreButtons(eventObject, MouseEvent.MOUSE_EXITED);
	}

}