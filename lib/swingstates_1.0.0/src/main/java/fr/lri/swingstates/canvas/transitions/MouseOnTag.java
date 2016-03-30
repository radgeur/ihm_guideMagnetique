package fr.lri.swingstates.canvas.transitions;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.EventObject;

import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.CStateMachine;
import fr.lri.swingstates.canvas.CTag;
import fr.lri.swingstates.canvas.Canvas;
import fr.lri.swingstates.events.PickerCEvent;
import fr.lri.swingstates.events.Utils;
import fr.lri.swingstates.sm.BasicInputStateMachine;

/**
 * A transition triggered by a mouse event on a tagged shape in the canvas.
 * The transition is specialized by a button and modifiers. Constants used
 * for button and modifier are static fields in <code>BasicInputStateMachine</code>.
 * 
 * @author Caroline Appert
 * 
 * @see BasicInputStateMachine#BUTTON1
 * @see BasicInputStateMachine#BUTTON2
 * @see BasicInputStateMachine#BUTTON3
 * @see BasicInputStateMachine#NOBUTTON
 * @see BasicInputStateMachine#ANYBUTTON
 * 
 * @see BasicInputStateMachine#CONTROL
 * @see BasicInputStateMachine#ALT
 * @see BasicInputStateMachine#SHIFT
 * @see BasicInputStateMachine#CONTROL_SHIFT
 * @see BasicInputStateMachine#ALT_CONTROL
 * @see BasicInputStateMachine#ALT_SHIFT
 * @see BasicInputStateMachine#ALT_CONTROL_SHIFT
 * @see BasicInputStateMachine#NOMODIFIER
 * @see BasicInputStateMachine#ANYMODIFIER
 */
public class MouseOnTag extends EventOnTag {

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
	 * Builds a mouse transition with any modifier and any button on a
	 * tagged shape.
	 * 
	 * @param tag
	 *            The tag
	 * @param outState
	 *            The name of the output state
	 */
	public MouseOnTag(CTag tag, String outState) {
		this(tag, BasicInputStateMachine.ANYBUTTON, outState);
	}

	/**
	 * Builds a mouse transition with any modifier and any button on a
	 * tagged shape that loops on the current state.
	 * 
	 * @param tag
	 *            The tag
	 */
	public MouseOnTag(CTag tag) {
		this(tag, BasicInputStateMachine.ANYBUTTON);
	}

	/**
	 * Builds a mouse transition with any modifier and any button on a
	 * tagged shape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param outState
	 *            The name of the output state
	 */
	public MouseOnTag(Class tagClass, String outState) {
		this(tagClass, BasicInputStateMachine.ANYBUTTON, outState);
	}

	/**
	 * Builds a mouse transition with any modifier and any button on a
	 * tagged shape that loops on the current state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 */
	public MouseOnTag(Class tagClass) {
		this(tagClass, BasicInputStateMachine.ANYBUTTON);
	}

	/**
	 * Builds a mouse transition on tagged shape.
	 * 
	 * @param tag
	 *            The tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param outState
	 *            The name of the output state
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnTag(CTag tag, int button, int modifier, String outState) {
		super(tag, (String) null, outState);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition on tagged shape that loops on the current
	 * state.
	 * 
	 * @param tag
	 *            The tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnTag(CTag tag, int button, int modifier) {
		super(tag, (String) null);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition with no modifier on tagged shape.
	 * 
	 * @param tag
	 *            The tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param outState
	 *            The name of the output state
	 */
	public MouseOnTag(CTag tag, int button, String outState) {
		super(tag, (String) null, outState);
		this.button = button;
	}

	/**
	 * Builds a mouse transition with no modifier on tagged shape that loops
	 * on the current state.
	 * 
	 * @param tag
	 *            The tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 */
	public MouseOnTag(CTag tag, int button) {
		super(tag, (String) null);
		this.button = button;
	}

	/**
	 * Builds a mouse transition on tagged shape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param outState
	 *            The name of the output state
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnTag(String tagName, int button, int modifier, String outState) {
		super(tagName, (String) null, outState);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition on tagged shape that loops on the current
	 * state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnTag(String tagName, int button, int modifier) {
		super(tagName, (String) null);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition with no modifier on tagged shape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param outState
	 *            The name of the output state
	 */
	public MouseOnTag(String tagName, int button, String outState) {
		super(tagName, (String) null, outState);
		this.button = button;
	}

	/**
	 * Builds a mouse transition with no modifier on a tagged shape that loops
	 * on the current state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 */
	public MouseOnTag(String tagName, int button) {
		super(tagName, (String) null);
		this.button = button;
	}

	/**
	 * Builds a mouse transition on tagged shape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param outState
	 *            The name of the output state
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnTag(Class tagClass, int button, int modifier, String outState) {
		super(tagClass, (String) null, outState);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition on tagged shape that loops on the current
	 * state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param modifier
	 *            The modifier: NOMODIFIER, CONTROL, ALT, SHIFT,
	 *            ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnTag(Class tagClass, int button, int modifier) {
		super(tagClass, (String) null);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition with no modifier on tagged shape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 * @param outState
	 *            The name of the output state
	 */
	public MouseOnTag(Class tagClass, int button, String outState) {
		super(tagClass, (String) null, outState);
		this.button = button;
	}

	/**
	 * Builds a mouse transition with no modifier on tagged shape that loops
	 * on the current state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param button
	 *            The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2
	 *            or BUTTON3
	 */
	public MouseOnTag(Class tagClass, int button) {
		super(tagClass, (String) null);
		this.button = button;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		String evt = classEvent != null ? classEvent.getSimpleName() + ".class" : event;
		if (isDesignedByClass) {
			return getClass().getSuperclass().getSimpleName() + "(" + tagClass.getSimpleName() + ".class, " + Utils.getButtonAsText(button) + "," + Utils.getModifiersAsText(modifier) + "," + evt
			+ ")";
		} else {
			if (isNamed)
				return getClass().getSuperclass().getSimpleName() + "(\"" + tagName + "\", " + Utils.getButtonAsText(button) + "," + Utils.getModifiersAsText(modifier) + "," + evt + ")";
			else
				return getClass().getSuperclass().getSimpleName() + "(" + tagObject + ", " + Utils.getButtonAsText(button) + "," + Utils.getModifiersAsText(modifier) + "," + evt + ")";
		}
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
	 * @return the awt input event that fires this transition.
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
		return ((PickerCEvent)triggeringEvent).getPoint();
	}

	/**
	 * {@inheritDoc}
	 */
	public CShape getShape() {
		return ((PickerCEvent)triggeringEvent).getPicked();
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
			boolean isShapeControlled = 
				(getInputState().getMachine() instanceof CStateMachine)
				&& ((CStateMachine)getInputState().getMachine()).controls(picked);
			boolean matches = isShapeControlled;
			if(matches) matches = matches(me.getPicked());
			return matches;
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
					&& ((CStateMachine)getInputState().getMachine()).controls(picked)
					&& matches(me.getPicked()));
		}
		return false;
	}

}
