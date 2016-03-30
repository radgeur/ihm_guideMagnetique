package fr.lri.swingstates.events;

import java.awt.Component;
import java.awt.event.MouseWheelEvent;

import fr.lri.swingstates.canvas.CShape;

public class PickerCMouseWheelEvent extends MouseWheelEvent implements PickerCEvent {

	protected Picker picker;
	protected CShape picked;
	
	/**
	 * Builds a <code>PickerCEvent</code>.
	 * @param source The source of the event
	 * @param picked The shape on which this event occurs
	 * @param picker The picker that originates this event
	 * @param id The id of this event
	 * @param when The time at which this event occurs
	 * @param modifiers The modifiers of this event
	 * @param x The x-location of this event
	 * @param y The y-location of this event
	 * @param clickCount The number of clicks of this event
	 * @param popupTrigger If this event triggers a popup
	 * @param scrollType The type of scrolling which should take place in response to this event; valid values are <code>WHEEL_UNIT_SCROLL</code> and <code>WHEEL_BLOCK_SCROLL</code> (in class java.awt.MouseWheelEvent) 
	 * @param scrollAmount for scrollType <code>WHEEL_UNIT_SCROLL</code>, the number of units to be scrolled
	 * @param wheelRotation The amount that the mouse wheel was rotated (the number of "clicks")
	 */
	public PickerCMouseWheelEvent(Component source, CShape picked, Picker picker, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger, int scrollType, int scrollAmount, int wheelRotation) {
		super(source, id, when, modifiers, x, y, clickCount,
				popupTrigger, scrollType, scrollAmount, wheelRotation);
		this.picked = picked;
		this.picker = picker; 
	}

//	/**
//	 * Builds a <code>PickerCEvent</code>.
//	 * @param source The source of the event
//	 * @param picked The shape on which this event occurs
//	 * @param picker The picker that originates this event
//	 * @param id The id of this event
//	 * @param when The time at which this event occurs
//	 * @param modifiers The modifiers of this event
//	 * @param x The x-location of this event
//	 * @param y The y-location of this event
//	 * @param clickCount The number of clicks of this event
//	 * @param popupTrigger If this event triggers a popup
//	 */
//	public PickerCMouseWheelEvent(Component source, CShape picked, Picker picker, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger) {
//		super(source, id, when, modifiers, x, y, clickCount, popupTrigger);
//		this.picked = picked;
//		this.picker = picker; 
//	}

	/**
	 * Builds a <code>PickerCEvent</code>.
	 * @param source The source of the event
	 * @param picker The picker that originates this event
	 * @param id The id of this event
	 * @param when The time at which this event occurs
	 * @param modifiers The modifiers of this event
	 * @param x The x-location of this event
	 * @param y The y-location of this event
	 * @param clickCount The number of clicks of this event
	 * @param popupTrigger If this event triggers a popup
	 * @param scrollType The type of scrolling which should take place in response to this event; valid values are <code>WHEEL_UNIT_SCROLL</code> and <code>WHEEL_BLOCK_SCROLL</code> (in class java.awt.MouseWheelEvent) 
	 * @param scrollAmount for scrollType <code>WHEEL_UNIT_SCROLL</code>, the number of units to be scrolled
	 * @param wheelRotation The amount that the mouse wheel was rotated (the number of "clicks")
	 */
	public PickerCMouseWheelEvent(Component source, Picker picker, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger, int scrollType, int scrollAmount, int wheelRotation) {
		super(source, id, when, modifiers, x, y, clickCount, popupTrigger,
				scrollType, scrollAmount, wheelRotation);
		this.picker = picker; 
	}

//	/**
//	 * Builds a <code>PickerCEvent</code>.
//	 * @param source The source of the event
//	 * @param picker The picker that originates this event
//	 * @param id The id of this event
//	 * @param when The time at which this event occurs
//	 * @param modifiers The modifiers of this event
//	 * @param x The x-location of this event
//	 * @param y The y-location of this event
//	 * @param clickCount The number of clicks of this event
//	 * @param popupTrigger If this event triggers a popup
//	 */
//	public PickerCMouseWheelEvent(Component source, Picker picker, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger) {
//		super(source, id, when, modifiers, x, y, clickCount, popupTrigger);
//		this.picker = picker; 
//	}
	
	public Picker getPicker() {
		return picker;
	}

	public CShape getPicked() {
		return picked;
	}

	public void setPicked(CShape picked) {
		this.picked = picked;
	}

}
