package fr.lri.swingstates.canvas.transitions;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.EventObject;

import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.CStateMachine;
import fr.lri.swingstates.canvas.Canvas;
import fr.lri.swingstates.events.PickerCEvent;
import fr.lri.swingstates.events.PickerEvent;
import fr.lri.swingstates.events.Utils;
import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered by a mouse event on a CShape in the canvas.
 * <code>MouseOnShape</code> is the super class of
 * <ul>
 * <li><code>PressOnShape</code>: mouse button pressed on a shape in the
 * canvas
 * <li><code>ReleaseOnShape</code>: mouse button released on a shape in
 * the canvas
 * <li><code>MoveOnShape</code>: mouse moved on a shape in the canvas
 * <li><code>DragOnShape</code>: mouse dragged on a shape in the canvas
 * (move with a button pressed)
 * <li><code>EnterOnShape</code>: mouse cursor entered on a shape in the
 * canvas
 * <li><code>LeaveOnShape</code>: mouse cursor left a shape in the
 * canvas
 * </ul>
 * <p>
 * For instance, the following code allows to specify a transition that
 * fires only on the background of the canvas, where no shape is displayed.
 * First specify an empty transition that fires on any shape, then a
 * transition that fires anywhere on the canvas. For example:
 * 
 * <pre>
 * 	public State s = new State () {
 * 		Transition tshape = new PressOnShape (BUTTON1) { ... };	// captures button presses on shapes
 * 		Transition tbackground = new Press (BUTTON1) { ... };	// captures button presses on background
 * 	}
 * </pre>
 * 
 * </p>
 * 
 * @author Caroline Appert
 */
public class MouseOnShape extends EventOnShape {

	/**
	 * The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3.
	 */
	int button;

	/**
	 * The modifier: CONTROL, SHIFT, ALT, CONTROL_SHIFT, ALT_SHIFT,
	 * ALT_CONTROL, ALT_CONTROL_SHIFT or NOMODIFIER.
	 */
	int modifier = BasicInputStateMachine.ANYMODIFIER;

	/**
	 * Builds a mouse transition with any modifier.
	 * 
	 * @param outState
	 *            The name of the output state
	 */
	public MouseOnShape(String outState) {
		this(BasicInputStateMachine.ANYBUTTON, outState);
	}

	/**
	 * Builds a mouse transition with any modifier that loops on the current
	 * state.
	 */
	public MouseOnShape() {
		this(BasicInputStateMachine.ANYBUTTON);
	}

	/**
	 * Builds a mouse transition.
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
	public MouseOnShape(int button, int modifier, String outState) {
		super((String) null, outState);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition that loops on the current state.
	 * 
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnShape(int button, int modifier) {
		super((String) null);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition with any modifier.
	 * 
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param outState
	 *            The name of the output state
	 */
	public MouseOnShape(int button, String outState) {
		super((String) null);
		setOutputStateName(outState);
		this.button = button;
	}

	/**
	 * Builds a mouse transition with any modifier that loops on the current
	 * state.
	 * 
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 */
	public MouseOnShape(int button) {
		super((String) null);
		this.button = button;
	}

	/**
	 * Returns the button of the mouse event that fires this transition.
	 * 
	 * @return the button of the mouse event that fires this transition
	 *         (NOBUTTON, BUTTON1, BUTTON2 or BUTTON3).
	 */
	public int getButton() {
		return button;
	}

	/**
	 * Returns the modifier of the event that fires this transition.
	 * 
	 * @return the modifier of the event that fires this transition
	 *         (NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT,
	 *         ALT_SHIFT or ALT_CONTROL_SHIFT).
	 */
	public int getModifier() {
		return modifier;
	}

	/**
	 * @return the input event that has just fired this transition.
	 */
	public InputEvent getInputEvent() {
		return (InputEvent) triggeringEvent;
	}
	
	/**
	 * @return the awt mouse event that fires this transition.
	 */
	public MouseEvent getMouseEvent() {
		return (MouseEvent) triggeringEvent;
	}

	/**
	 * {@inheritDoc}
	 */
	public Point2D getPoint() {
		if(triggeringEvent instanceof PickerEvent)
			return ((PickerEvent)triggeringEvent).getPoint();
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public CShape getShape() {
		if(triggeringEvent instanceof PickerCEvent)
			return ((PickerCEvent)triggeringEvent).getPicked();
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return getClass().getSuperclass().getSimpleName() + "(" + Utils.getButtonAsText(button) + "," + Utils.getModifiersAsText(modifier) + ")";
	}

	protected boolean matchesIgnoreButtons(EventObject eventObject, int typeEvent) {
		if (!(eventObject instanceof PickerCEvent))
			return false;
		PickerCEvent me = (PickerCEvent) eventObject;
		if(!(me.getID() == typeEvent))
			return false;
		if(!(modifier == BasicInputStateMachine.ANYMODIFIER || modifier == Utils.modifiers((MouseEvent)me)))
			return false;
		if (me.getSource() instanceof Canvas) {
			CShape picked = me.getPicked();
			return (getInputState().getMachine() instanceof CStateMachine
					&& ((CStateMachine)getInputState().getMachine()).controls(picked));
		}
		return false;
	}

	protected boolean matches(EventObject eventObject, int typeEvent) {
		if (!(eventObject instanceof PickerCEvent))
			return false;
		
		PickerCEvent me = (PickerCEvent) eventObject;
		if (me.getSource() instanceof Canvas) {
			if(!((me.getID() == typeEvent) 
					&& (modifier == BasicInputStateMachine.ANYMODIFIER || modifier == Utils.modifiers((MouseEvent)me))
					&& (button == BasicInputStateMachine.ANYBUTTON || button == Utils.button((MouseEvent)me)))) 
				return false;
			CShape picked = me.getPicked();
			return (getInputState().getMachine() instanceof CStateMachine
					&& ((CStateMachine)getInputState().getMachine()).controls(picked));
		}
		return false;
	}
}

