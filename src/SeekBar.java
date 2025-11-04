/**
* Lead Author(s):
* @author nelson; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-10-09
*/
package src;

import java.awt.Dimension;

import javax.swing.JSlider;
import javax.swing.SwingConstants;

/**
 * Purpose: The reponsibility of SeekBar is ...
 *
 * SeekBar is-a JSlider
 * SeekBar is ...
 */
public class SeekBar extends JSlider
{
	private int initialValue = 0;
	
	public SeekBar()
	{
		this.setOrientation(SwingConstants.HORIZONTAL);
		this.setValue(initialValue);
		this.setPreferredSize(new Dimension(250, 100));
        this.setMaximumSize(new Dimension(250, 100)); 
		
	}
}
