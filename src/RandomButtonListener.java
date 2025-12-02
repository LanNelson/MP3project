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
* Version: 2025-11-13
*/
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Purpose: The reponsibility of RamdomButtonListener is ...
 *
 * RamdomButtonListener is-a ...
 * RamdomButtonListener is ...
 */
public class RandomButtonListener implements ActionListener
{
	
	private MP3PlayerView view;
	private MP3PlayerModel model;
	private RandomButton randomButton;
	private PlayList playList;
	
	public RandomButtonListener(MP3PlayerView view, MP3PlayerModel model,
			RandomButton randomButton, PlayList playList)
	{
		this.view = view;
		this.model = model;
		this.randomButton = randomButton;
		this.playList = playList;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		playList.shuffleSongs();
	}

}
