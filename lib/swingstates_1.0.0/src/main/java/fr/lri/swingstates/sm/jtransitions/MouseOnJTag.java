package fr.lri.swingstates.sm.jtransitions;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.EventObject;

import fr.lri.swingstates.events.Utils;
import fr.lri.swingstates.sm.BasicInputStateMachine;
import fr.lri.swingstates.sm.JTag;

/**
 * A transition triggered by a mouse event on a tagged component.
 * The transition is specified by a button and modifiers.
 * The position of the mouse when the transition fired can be retrieved.
 * @author Caroline Appert
 */
public class MouseOnJTag extends EventOnJTag {

	/**
	 * The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3.
	 */
	int button;

	/**
	 * The modifier: CONTROL, SHIFT, ALT, CONTROL_SHIFT, ALT_SHIFT, ALT_CONTROL, ALT_CONTROL_SHIFT or NOMODIFIER.
	 */
	int modifier = BasicInputStateMachine.ANYMODIFIER;

	/**
	 * Builds a mouse transition on tagged component.
	 * @param tag The tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnJTag(JTag tag, int button, int modifier, String outState) {
		super(tag, (String)null, outState);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition on tagged component that loops on the current state.
	 * @param tag The tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnJTag(JTag tag, int button, int modifier) {
		super(tag, (String)null);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition with no modifier on tagged component.
	 * @param tag The tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 */
	public MouseOnJTag(JTag tag, int button, String outState) {
		super(tag, (String)null, outState);
		this.button = button;
	}

	/**
	 * Builds a mouse transition with no modifier on tagged component that loops on the current state.
	 * @param tag The tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 */
	public MouseOnJTag(JTag tag, int button) {
		super(tag, (String)null);
		this.button = button;
	}

	/**
	 * Builds a mouse transition on tagged component.
	 * @param tagName The name of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnJTag(String tagName, int button, int modifier, String outState) {
		super(tagName, (String)null, outState);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition on tagged component that loops on the current state.
	 * @param tagName The name of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnJTag(String tagName, int button, int modifier) {
		super(tagName, (String)null);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition with no modifier on tagged component.
	 * @param tagName The name of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 */
	public MouseOnJTag(String tagName, int button, String outState) {
		super(tagName, (String)null, outState);
		this.button = button;
	}

	/**
	 * Builds a mouse transition with no modifier on tagged component that loops on the current state.
	 * @param tagName The name of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 */
	public MouseOnJTag(String tagName, int button) {
		super(tagName, (String)null);
		this.button = button;
	}

	/**
	 * Builds a mouse transition on tagged component.
	 * @param tagClass The class of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnJTag(Class tagClass, int button, int modifier, String outState) {
		super(tagClass, (String)null, outState);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition on tagged component that loops on the current state.
	 * @param tagClass The class of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param modifier The modifier: NOMODIFIER, CONTROL, ALT, SHIFT, ALT_CONTROL, CONTROL_SHIFT, ALT_SHIFT or ALT_CONTROL_SHIFT
	 */
	public MouseOnJTag(Class tagClass, int button, int modifier) {
		super(tagClass, (String)null);
		this.modifier = modifier;
		this.button = button;
	}

	/**
	 * Builds a mouse transition with no modifier on tagged component.
	 * @param tagClass The class of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 * @param outState The name of the output state
	 */
	public MouseOnJTag(Class tagClass, int button, String outState) {
		super(tagClass, (String)null, outState);
		this.button = button;
	}

	/**
	 * Builds a mouse transition with no modifier on tagged component that loops on the current state.
	 * @param tagClass The class of the tag
	 * @param button The button of the mouse event: NOBUTTON, BUTTON1, BUTTON2 or BUTTON3
	 */
	public MouseOnJTag(Class tagClass, int button) {
		super(tagClass, (String)null);
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
		String evt = classEvent != null ? classEvent.getSimpleName()+".class" : event;
		if(isDesignedByClass) {
			return getClass().getSuperclass().getSimpleName()+"("+tagClass.getSimpleName()+".class, "+Utils.getButtonAsText(button)+","+Utils.getModifiersAsText(modifier)+","+evt+")";
		} else {
			if(isNamed) return getClass().getSuperclass().getSimpleName()+"(\""+tagName+"\", "+Utils.getButtonAsText(button)+","+Utils.getModifiersAsText(modifier)+","+evt+")";
			else return getClass().getSuperclass().getSimpleName()+"("+tagObject+", "+Utils.getButtonAsText(button)+","+Utils.getModifiersAsText(modifier)+","+evt+")";
		}
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
		return ((MouseEvent)triggeringEvent).getComponent();
	}

	protected boolean matchesIgnoreButtons(EventObject eventObject, int typeEvent) {
		if(!(eventObject instanceof MouseEvent)) return false;
		MouseEvent me = (MouseEvent)eventObject;
		if(me.getComponent() == null) return false;
		return (me.getID() == typeEvent)
		&& (modifier == Utils.modifiers(me) || modifier == BasicInputStateMachine.ANYMODIFIER)
		&& matchesTag(me);
	}

	protected boolean matches(EventObject eventObject, int typeEvent) {
		if(!(eventObject instanceof MouseEvent)) return false;
		MouseEvent me = (MouseEvent)eventObject;
		if(me.getComponent() == null) return false;
		return (me.getID() == typeEvent)
		&& (modifier == Utils.modifiers(me) || modifier == BasicInputStateMachine.ANYMODIFIER)
		&& (button == BasicInputStateMachine.ANYBUTTON || button == Utils.button(me))
		&& matchesTag(me);
	}
}
