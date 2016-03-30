package fr.lri.swingstates.canvas.transitions;

import java.util.EventObject;
import java.util.Iterator;
import java.util.ListIterator;

import fr.lri.swingstates.canvas.CNamedTag;
import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.CStateMachine;
import fr.lri.swingstates.canvas.CTag;
import fr.lri.swingstates.events.VirtualCanvasEvent;
import fr.lri.swingstates.sm.transitions.Event;

/**
 * A transition triggered on a tagged shape. OnTag transitions allow
 * developpers to retrieve the shape and the tag where this transition has
 * been fired:
 * 
 * <pre>
 *  class ColorTag extends CNamedTag {
 *  		Color color;
 *  		public ColorTag(String tagName, Color c) {
 *  			super(n);
 *  		}
 *  }
 *  ...
 *  CShape ellipse1 = canvas.newEllipse(100, 100, 20, 30);
 *  CShape ellipse2 = canvas.newEllipse(200, 200, 20, 30);
 *  CShape rectangle = canvas.newRectangle(300, 300, 20, 30);
 *  ColorTag red = new ColorTag(&quot;red&quot;, Color.RED);
 *  red.addTo(ellipse1).addTo(rectangle);
 *  ColorTag green = new ColorTag(&quot;green&quot;, Color.GREEN);
 *  green.addTo(ellipse2);
 * </pre>
 * 
 * <ul>
 * <li> Transitions can be marked by a tag:
 * 
 * <pre>
 *  // The transition is triggered when an event occurs on ellipse1 or on rectangle.
 * 	Transition t = new EventOnTag (red, BUTTON1) {
 * 		public void action() {
 * 			...
 * 			// scale ellipse1 and rectangle
 * 			getTag().scaleBy(1.5);
 * 			// set the transparencyFill of the shape on which this transition has been triggered (ellipse1 OR rectangle)
 * 			getShape().setTransparency(0.5f);
 * 		}
 * 	}
 * </pre>
 * 
 * <li> Transitions can be marked by a class of tag:
 * 
 * <pre>
 *  // The transition is triggered when an event occurs on ellipse1, ellipse2 or on rectangle (any shape tagged by an instance of ColorTag).
 * 	Transition t = new EventOnTag (ColorTag.class, BUTTON1) {
 * 		public void action() {
 * 			...
 * 			getShape().setFillPaint(((ColorTag)getTag()).color));
 * 			...
 * 		}
 * 	}
 * </pre>
 * 
 * <li> Transitions can be marked by the name of the tag (if the tag is an
 * instance of a subclass of a CNamedTag):
 * 
 * <pre>
 *  // The transition is triggered when an event occurs on ellipse2 (the only shape tagged by the instance of ColorTag having the name &quot;green&quot;).
 * 	Transition t = new EventOnTag (&quot;green&quot;, BUTTON1) {
 * 		public void action() {
 * 			...
 * 			System.out.println(&quot;This shape is tagged by the color &quot;+((ColorTag)getTag()).color);
 * 			...
 * 		}
 * 	}
 * </pre>
 * 
 * </ul>
 * 
 * @author Caroline Appert
 */
public abstract class EventOnTag extends EventOnShape {

	/**
	 * The tag object.
	 */
	protected CTag tagObject = null;

	/**
	 * The name of the tag.
	 */
	protected String tagName = null;

	/**
	 * The class of the tag.
	 */
	protected Class<? extends CTag> tagClass = null;

	/**
	 * If the tag is mentioned by its name or not.
	 */
	protected boolean isNamed = false;

	protected boolean isDesignedByClass = false;

	/**
	 * Builds a transition with any modifier on a tagged shape that loops on
	 * the current state.
	 * 
	 * @param tag
	 *            The tag
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered
	 */
	public EventOnTag(CTag tag, String keyEvent) {
		super(keyEvent);
		tagObject = tag;
	}

	/**
	 * Builds a transition with any modifier on a tagged shape that loops on
	 * the current state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered
	 */
	public EventOnTag(Class<? extends CTag> tagClass, String keyEvent) {
		super(keyEvent);
		this.tagClass = tagClass;
		isDesignedByClass = true;
	}

	/**
	 * Builds a transition with any modifier on a tagged shape that loops on
	 * the current state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered
	 */
	public EventOnTag(String tagName, String keyEvent) {
		super(keyEvent);
		this.tagName = tagName;
		isNamed = true;
	}

	/**
	 * Builds a transition with any modifier on a tagged shape that loops on
	 * the current state.
	 * 
	 * @param tag
	 *            The tag
	 * @param eventClass
	 *            The class of events
	 */
	public EventOnTag(CTag tag, Class eventClass) {
		super("");
		tagObject = tag;
		classEvent = eventClass;
	}

	/**
	 * Builds a transition with any modifier on a tagged shape that loops on
	 * the current state.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param eventClass
	 *            The class of events
	 */
	public EventOnTag(Class<? extends CTag> tagClass, Class eventClass) {
		super("");
		this.tagClass = tagClass;
		isDesignedByClass = true;
		classEvent = eventClass;
	}

	/**
	 * Builds a transition with any modifier on a tagged shape that loops on
	 * the current state.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param eventClass
	 *            The class of events
	 */
	public EventOnTag(String tagName, Class eventClass) {
		super("");
		this.tagName = tagName;
		isNamed = true;
		classEvent = eventClass;
	}

	/**
	 * Builds a transition with any modifier on a tagged shape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered
	 * @param outState
	 *            The name of the output state
	 */
	public EventOnTag(String tagName, String keyEvent, String outState) {
		super(keyEvent, outState);
		this.tagName = tagName;
		isNamed = true;
	}

	/**
	 * Builds a transition with any modifier on a tagged shape.
	 * 
	 * @param tagClass
	 *            The class of the tag
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered
	 * @param outState
	 *            The name of the output state
	 */
	public EventOnTag(Class<? extends CTag> tagClass, String keyEvent, String outState) {
		super(keyEvent, outState);
		this.tagClass = tagClass;
		isDesignedByClass = true;
	}

	/**
	 * Builds a transition with any modifier on a tagged shape.
	 * 
	 * @param tag
	 *            The tag
	 * @param keyEvent
	 *            The string describing the events for which this transition
	 *            must be triggered
	 * @param outState
	 *            The name of the output state
	 */
	public EventOnTag(CTag tag, String keyEvent, String outState) {
		super(keyEvent, outState);
		tagObject = tag;
	}

	/**
	 * Builds a transition with any modifier on a tagged shape.
	 * 
	 * @param tagName
	 *            The name of the tag
	 * @param eventClass
	 *            The class of events
	 * @param outState
	 *            The name of the output state
	 */
	public EventOnTag(String tagName, Class eventClass, String outState) {
		super("", outState);
		this.tagName = tagName;
		isNamed = true;
		classEvent = eventClass;
	}

	/**
	 * Builds a transition with any modifier on a tagged shape.
	 * 
	 * @param tgClass
	 *            The class of the tag
	 * @param eventClass
	 *            The class of events
	 * @param outState
	 *            The name of the output state
	 */
	public EventOnTag(Class<? extends CTag> tgClass, Class eventClass, String outState) {
		super("", outState);
		tagClass = tgClass;
		isDesignedByClass = true;
		classEvent = eventClass;
	}

	/**
	 * Builds a transition with any modifier on a tagged shape.
	 * 
	 * @param tag
	 *            The tag
	 * @param eventClass
	 *            The class of events for which that triggers this
	 *            transition.
	 * @param outState
	 *            The name of the output state
	 */
	public EventOnTag(CTag tag, Class eventClass, String outState) {
		super("", outState);
		tagObject = tag;
		classEvent = eventClass;
	}

	/**
	 * Returns the name of the tag hold by the CShape on which the mouse
	 * event firing this transition has occurred.
	 * 
	 * @return name of the tag.
	 */
	public String getTagName() {
		if(tagName != null) return tagName;
		else {
			if(isNamed) {
				if(tagObject != null && tagObject instanceof CNamedTag)
					return ((CNamedTag)tagObject).getName();
			}
		}
		return null;
	}

	/**
	 * Returns the tag instance hold by the CShape on which the mouse
	 * event firing this transition has occurred.
	 * 
	 * @return the tag instance.
	 */
	public CTag getTag() {
		return tagObject;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		String evt = classEvent != null ? classEvent.getSimpleName() + ".class" : event;
		if (isDesignedByClass) {
			return "EventOnTag(" + tagClass.getSimpleName() + ".class, " + evt + ")";
		} else {
			if (isNamed)
				return "EventOnTag(\"" + tagName + "\", " + evt + ")";
			else
				return "EventOnTag(" + tagObject.getClass().getSimpleName()+"@"+Integer.toHexString(hashCode())+ ", " + evt + ")";
		}
	}

	protected boolean matches(CShape source) {
		boolean hasTested = false;
		if (isDesignedByClass && source.getCanvas().getAllTags() != null) {
			for (ListIterator<? extends CTag> it = source.getCanvas().getAllTags().listIterator(); it.hasNext();) {
				CTag o = (CTag) it.next();
				if (tagClass.isAssignableFrom(o.getClass())) {
					if (o.tagsShape(source)) {
						hasTested = true;
						tagObject = o;
//						if (o instanceof CNamedTag)
//							setTagName(((CNamedTag) o).getName());
						break;
					}
				}
			}
		} else {
			if (isNamed) {
				if (tagObject == null) {
					tagObject = source.getCanvas().getTag(tagName);
					if (tagObject == null)
						return false;
					tagClass = (Class<? extends CTag>) tagObject.getClass();
				}
			}
			// else {
			// is denoted by the tag object itself

			// }
		}
		if (hasTested || source.hasTag(tagObject))
			return true;
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EventObject eventObject) {
		boolean b = super.matches(eventObject);
		if (b) {
			boolean c = matches(((VirtualCanvasEvent)eventObject).getShape());
			return c;
		}
		return false;
	}
}
