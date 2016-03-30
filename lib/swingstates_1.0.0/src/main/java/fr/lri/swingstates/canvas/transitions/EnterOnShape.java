package fr.lri.swingstates.canvas.transitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import fr.lri.swingstates.events.PickerCEvent;
import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered when mouse cursor enters on a CShape.
 * 
 * @author Caroline Appert
 */
public class EnterOnShape extends MouseOnShape {

	/**
	 * Builds a transition triggered when the cursor enters with any
	 * modifier into a CShape.
	 */
	public EnterOnShape() {
		super(BasicInputStateMachine.NOBUTTON);
	}

	/**
	 * Builds a transition triggered when the cursor enters into a CShape
	 * that loops on the current state.
	 * 
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public EnterOnShape(int modifier) {
		super(BasicInputStateMachine.NOBUTTON, modifier);
	}

	/**
	 * Builds a transition triggered when the cursor enters with any
	 * modifier into a CShape.
	 * 
	 * @param outState
	 *            The name of the output state
	 */
	public EnterOnShape(String outState) {
		super(BasicInputStateMachine.NOBUTTON, BasicInputStateMachine.ANYMODIFIER, outState);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		if (!(eventObject instanceof PickerCEvent))
			return false;
		return matchesIgnoreButtons(eventObject, MouseEvent.MOUSE_ENTERED);
	}
}
