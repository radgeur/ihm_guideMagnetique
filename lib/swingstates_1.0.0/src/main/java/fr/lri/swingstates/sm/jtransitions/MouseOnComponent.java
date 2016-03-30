package fr.lri.swingstates.sm.jtransitions;

import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.EventObject;

import fr.lri.swingstates.events.Utils;
import fr.lri.swingstates.sm.BasicInputStateMachine;
import fr.lri.swingstates.sm.EventOnComponent;

/**
 * A transition triggered by a mouse event on a component.
 * The transition is specified by a button and modifiers.
 * The position of the mouse when the transition fired can be retrieved.
 * @author Caroline Appert
 */
public class MouseOnComponent extends EventOnComponent {

	/**
	 * The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3.
	 */
	int button;

	/**
	 * The modifier: CONTROL, SHIFT, ALT, CONTROL_SHIFT, ALT_SHIFT, ALT_CONTROL, ALT_CONTROL_SHIFT or NOMODIFIER.
	 */
	int modifier = BasicInputStateMachine.ANYMODIFIER;

	/**
	 * Builds a mouse transition.
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnComponent(int button, int modifier, String outState) {
		super((String)null, outState);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition that loops on the current state.
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnComponent(int button, int modifier) {
		super((String)null);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition with any modifier.
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 */
	public MouseOnComponent(int button, String outState) {
		super((String)null, outState);
		this.button = button;
	}

	/**
	 * Builds a mouse transition with any modifier that loops on the current state.
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 */
	public MouseOnComponent(int button) {
		super((String)null);
		this.button = button;
	}

	/**
	 * Returns the button of the mouse event that fires this transition.
	 * @return the button of the mouse event that fires this transition (NOBUTTON, BUTTON1, BUTTON2 or BUTTON3).
	 */
	public int getButton(){
		return button;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return getClass().getSuperclass().getSimpleName()+"("+Utils.getButtonAsText(button)+","+Utils.getModifiersAsText(modifier)+")";
	}

	/**
	 * @return the input event that fires this transition.
	 */
	public InputEvent getInputEvent() {
		return (InputEvent)triggeringEvent;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Point2D getPoint() {
		return ((MouseEvent)triggeringEvent).getPoint();
	}

	/**
	 * {@inheritDoc}
	 */
	public Component getComponent() {
		return ((ComponentEvent)triggeringEvent).getComponent();
	}
	
	protected boolean matchesIgnoreButtons(EventObject eventObject, int typeEvent) {
		if(!(eventObject instanceof MouseEvent)) return false;
		MouseEvent me = (MouseEvent)eventObject;
		if(me.getComponent() == null) return false;
		return (me.getID() == typeEvent)
		&& (modifier == Utils.modifiers(me) || modifier == BasicInputStateMachine.ANYMODIFIER);
	}

	protected boolean matches(EventObject eventObject, int typeEvent) {
		if(!(eventObject instanceof MouseEvent)) return false;
		MouseEvent me = (MouseEvent)eventObject;
		if(me.getComponent() == null) return false;
		return (me.getID() == typeEvent)
		&& (modifier == Utils.modifiers(me) || modifier == BasicInputStateMachine.ANYMODIFIER)
		&& (button == BasicInputStateMachine.ANYBUTTON || button == Utils.button(me));
	}
}
