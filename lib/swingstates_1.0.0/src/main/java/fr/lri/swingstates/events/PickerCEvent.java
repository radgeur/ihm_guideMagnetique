/*  
 *   Authors: Caroline Appert (caroline.appert@lri.fr) and Michel Beaudouin-Lafon
 *   Copyright (c) Universite Paris-Sud XI, 2007. All Rights Reserved
 *   Licensed under the GNU LGPL. For full terms see the file COPYING.
*/
package fr.lri.swingstates.events;

import fr.lri.swingstates.canvas.CShape;

/**
 * An event coming from a <code>Picker</code> on a SwingStates <code>Canvas</code>.
 *
 * @author Caroline Appert
 *
 */
public interface PickerCEvent extends PickerEvent<CShape> {

	int getID();

	Object getSource(); 
	
}
