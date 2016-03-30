/*  
 *   Authors: Caroline Appert (caroline.appert@lri.fr) and Michel Beaudouin-Lafon
 *   Copyright (c) Universite Paris-Sud XI, 2007. All Rights Reserved
 *   Licensed under the GNU LGPL. For full terms see the file COPYING.
 */
package fr.lri.swingstates.events;

import java.awt.geom.Point2D;


/**
 * An event coming from a <code>Picker</code>.
 *
 * @author Caroline Appert
 *
 */
public interface PickerEvent<E> {

	/**
	 * @return The picker that originated this event.
	 */
	Picker getPicker();

	/**
	 * @return the picked element.
	 */
	E getPicked();

	/**
	 * Sets the picked element for this event.
	 * @param picked The picked element.
	 */
	void setPicked(E picked);

	Point2D getPoint();

}
