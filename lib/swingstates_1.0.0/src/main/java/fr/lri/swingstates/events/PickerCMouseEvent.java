package fr.lri.swingstates.events;

import java.awt.Component;
import java.awt.event.MouseEvent;

import fr.lri.swingstates.canvas.CShape;

public class PickerCMouseEvent extends MouseEvent implements PickerCEvent {

	protected Picker picker;
	protected CShape picked;
	
	/**
	 * Builds a <code>PickerCMouseEvent</code>.
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
	 * @param button The mouse button
	 */
	public PickerCMouseEvent(Component source, CShape picked, Picker picker, int id, long when,
			int modifiers, int x, int y, int clickCount, boolean popupTrigger,
			int button) {
		super(source, id, when, modifiers, x, y, clickCount, popupTrigger, button);
		this.picked = picked;
		this.picker = picker; 
	}
	
	/**
	 * Builds a <code>PickerCMouseEvent</code>.
	 * @param source The source of the event
	 * @param picker The picker that originates this event
	 * @param id The id of this event
	 * @param when The time at which this event occurs
	 * @param modifiers The modifiers of this event
	 * @param x The x-location of this event
	 * @param y The y-location of this event
	 * @param clickCount The number of clicks of this event
	 * @param popupTrigger If this event triggers a popup
	 * @param button The mouse button
	 */
	public PickerCMouseEvent(Component source, Picker picker, int id, long when,
			int modifiers, int x, int y, int clickCount, boolean popupTrigger,
			int button) {
		super(source, id, when, modifiers, x, y, clickCount, popupTrigger, button);
		this.picker = picker; 
	}

	/**
	 * Builds a <code>PickerCMouseEvent</code>.
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
	 */
	public PickerCMouseEvent(Component source, CShape picked, Picker picker, int id, long when,
			int modifiers, int x, int y, int clickCount, boolean popupTrigger) {
		super(source, id, when, modifiers, x, y, clickCount, popupTrigger);
		this.picked = picked;
		this.picker = picker; 
	}
	
	/**
	 * Builds a <code>PickerCMouseEvent</code>.
	 * @param source The source of the event
	 * @param picker The picker that originates this event
	 * @param id The id of this event
	 * @param when The time at which this event occurs
	 * @param modifiers The modifiers of this event
	 * @param x The x-location of this event
	 * @param y The y-location of this event
	 * @param clickCount The number of clicks of this event
	 * @param popupTrigger If this event triggers a popup
	 */
	public PickerCMouseEvent(Component source, Picker picker, int id, long when,
			int modifiers, int x, int y, int clickCount, boolean popupTrigger) {
		super(source, id, when, modifiers, x, y, clickCount, popupTrigger);
		this.picker = picker; 
	}


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
