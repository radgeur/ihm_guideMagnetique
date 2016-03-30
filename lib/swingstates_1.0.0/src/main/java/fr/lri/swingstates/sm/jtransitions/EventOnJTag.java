package fr.lri.swingstates.sm.jtransitions;

import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.Iterator;

import fr.lri.swingstates.sm.EventOnComponent;
import fr.lri.swingstates.sm.JNamedTag;
import fr.lri.swingstates.sm.JTag;

/**
 * A transition triggered on a tagged component.
 * OnTag transitions allow developpers to retrieve the component and the tag where this transition has been fired:
 *  <pre>
 *  Class ColorTag extends JNamedTag {
 *  		Color color;
 *  		public ColorTag(String tagName, Color c) {
 *  			super(n);
 *  		}
 *  }
 *  ...
 *  JButton button1 = new JButton("button1");
 *  JButton button2 = new JButton("button2");
 *  JCheckbox cb = new JCheckbox("checkbox");
 *  ColorTag red = new ColorTag("red", Color.RED);
 *  red.addTo(button1).addTo(cb);
 *  ColorTag green = new ColorTag("green", Color.GREEN);
 *  green.addTo(button2);
 *  </pre>
 *  
 *  <ul>
 *  <li> Transitions can be marked by a tag:
 *  <pre>
 *  // The transition is triggered when an event occurs on button1 or on cb.
 * 	Transition t = new EventOnTag (red, BUTTON1) {
 * 		public void action() {
 * 			...
 * 			// set the background color of button1 and cb.
 * 			getTag().setBackground(Color.RED);
 * 			// print the text of the tooltip of the component on which this transition has been triggered (button1 OR cb)
 * 			System.out.println(getComponent().getToolTipText());
 * 		}
 * 	}
 * </pre>
 *  <li> Transitions can be marked by a class of tag:
 *  <pre>
 *  // The transition is triggered when an event occurs on button1, button2 or on cb (any component tagged by an instance of ColorTag).
 * 	Transition t = new EventOnTag (ColorTag.class, BUTTON1) {
 * 		public void action() {
 * 			...
 * 			getComponent().setBackground(((ColorTag)getTag()).color));
 * 			...
 * 		}
 * 	}
 * </pre>
 *  <li> Transitions can be marked by the name of the tag (if the tag is an instance of a subclass of a JNamedTag):
 *  <pre>
 *  // The transition is triggered when an event occurs on ellipse2 (the only component tagged by the instance of ColorTag having the name "green").
 * 	Transition t = new EventOnTag ("green", BUTTON1) {
 * 		public void action() {
 * 			...
 * 			System.out.println("This component is tagged by the color "+((ColoredTag)getTag()).color);
 * 			...
 * 		}
 * 	}
 * </pre>
 * </ul>
 * 
 * <p> Note that each component is tagged by the name of the class of the component. For instance,
 * one can retrieve any press on any JButton:
 * <pre>
 *   Transition pressOnButton = new PressOnTag(BUTTON1, "javax.swing.JButton") { ... };
 * </pre>
 * </p>
 * 
 * @author Caroline Appert
 */
public abstract class EventOnJTag extends EventOnComponent {

	/**
	 * The tag object.
	 */
	JTag tagObject = null;

	/**
	 * The name of the tag.
	 */
	String tagName = null;

	/**
	 * The class of the tag.
	 */
	Class tagClass = null;

	/**
	 * If the tag is mentioned by its name or not. 
	 */
	boolean isNamed = false;

	boolean isDesignedByClass = false;

	/**
	 * Builds a transition with any modifier on a tagged component that loops on the current state.
	 * @param tag The tag
	 * @param keyEvent The string describing the events for which this transition must be triggered
	 */
	public EventOnJTag(JTag tag, String keyEvent){
		super(keyEvent);
		tagObject = tag;
	}

	/**
	 * Builds a transition with any modifier on a tagged component that loops on the current state.
	 * @param tagClass The class of the tag
	 * @param keyEvent The string describing the events for which this transition must be triggered
	 */
	public EventOnJTag(Class tagClass, String keyEvent){
		super(keyEvent);
		this.tagClass = tagClass;
		isDesignedByClass = true;
	}

	/**
	 * Builds a transition with any modifier on a tagged component that loops on the current state.
	 * @param tagName The name of the tag
	 * @param keyEvent The string describing the events for which this transition must be triggered
	 */
	public EventOnJTag(String tagName, String keyEvent) {
		super(keyEvent);
		this.tagName = tagName;
		isNamed = true;
	}

	/**
	 * Builds a transition with any modifier on a tagged component.
	 * @param tagName The name of the tag
	 * @param keyEvent The string describing the events for which this transition must be triggered
	 * @param outState The name of the output state
	 */
	public EventOnJTag(String tagName, String keyEvent, String outState) {
		super(keyEvent, outState);
		this.tagName = tagName;
		isNamed = true;
	}

	/**
	 * Builds a transition with any modifier on a tagged component.
	 * @param tagClass The class of the tag
	 * @param keyEvent The string describing the events for which this transition must be triggered
	 * @param outState The name of the output state
	 */
	public EventOnJTag(Class tagClass, String keyEvent, String outState) {
		super(keyEvent, outState);
		this.tagClass = tagClass;
		isDesignedByClass = true;
	}

	/**
	 * Builds a transition with any modifier on a tagged component.
	 * @param tag The tag
	 * @param keyEvent The string describing the events for which this transition must be triggered
	 * @param outState The name of the output state
	 */
	public EventOnJTag(JTag tag, String keyEvent, String outState){
		super(keyEvent, outState);
		tagObject = tag;
	}

	/**
	 * Returns the name of the tag attached to the component on which the mouse event firing this transition has occured.
	 * @return name of the tag.
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * Returns the tag instance attached to the JComponent on which the mouse event firing this transition has occured.
	 * @return the tag instance.
	 */
	public JTag getTag() {
		return tagObject;
	}

	void setTagObject(JTag tag) {
		tagObject = tag;
	}

	void setTagClass(Class tagClass) {
		this.tagClass = tagClass;
	}

	void setTagName(String tagName) {
		this.tagName = tagName;
	}

	protected boolean matchesTag(MouseEvent eventObject) {
		JTag tg = getTag();
		boolean hasTested = false;
		boolean hasTag = false;
		if(isDesignedByClass && JTag.getAllJTags() != null) {
			for(Iterator it = JTag.getAllJTags().iterator(); it.hasNext(); ) {
				JTag o = (JTag)it.next();
				if(tagClass.equals(o.getClass())) {
					o.reset();
					while(o.hasNext()) {
						if(o.nextComponent() == eventObject.getComponent()) {
							hasTag = true;
							break;
						}
					}
					if(hasTag) {
						hasTested = true;
						setTagObject(o);
						if(o instanceof JNamedTag)
							setTagName(((JNamedTag)o).getName());
						break;
					}
				}
			}
		} else {
			if(isNamed) {
				if(tg == null) {
					tg = JNamedTag.getTag(tagName);
					if(tg == null)
						tg = new JNamedTag(tagName);
				}

				Class cls;
				try {
					cls = Class.forName(tagName);
					if(cls != null && cls.isAssignableFrom(eventObject.getComponent().getClass())) {
						((JNamedTag)tg).addTo(eventObject.getComponent());
						hasTested = true;
						hasTag = true;
					}
				} catch (ClassNotFoundException e) {
					;
				}

				setTagObject(tg);
				setTagClass(tg.getClass());
			}
		}
		if(!hasTested && tg!=null) {
			tg.reset();
			while(tg.hasNext()) {
				if(tg.nextComponent() == eventObject.getComponent()) {
					hasTag = true;
					break;
				}
			}
		}
		if(hasTag) {	
			return true; 
		}
		return false;	
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		String evt = classEvent != null ? classEvent.getSimpleName()+".class" : event;
		if(isDesignedByClass) {
			return "EventOnTag("+tagClass.getSimpleName()+".class, "+evt+")";
		} else {
			if(isNamed) return "EventOnTag(\""+tagName+"\", "+evt+")";
			else return "EventOnTag("+tagObject+", "+evt+")";
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		return super.matches(eventObject) && matchesTag((MouseEvent)eventObject);
	}

}	