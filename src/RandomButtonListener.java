/**
 * Lead Author(s):
 * 
 * @author Nelson
 * 
 *
 *         Other Contributors:
 *         none
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 *         Responsibility:
 *         -Listener of random button
 *         
 *         Version: 2025-12-9
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomButtonListener implements ActionListener
{
	
	private MP3PlayerView view;
	private MP3PlayerModel model;
	private RandomButton randomButton;
	private PlayList playList;
	
	/**
	 * 
	 * Purpose: constructor of randomButtonListener
	 * @param view
	 * @param model
	 * @param randomButton
	 * @param playList
	 */
	public RandomButtonListener(MP3PlayerView view, MP3PlayerModel model,
			RandomButton randomButton, PlayList playList)
	{
		this.view = view;
		this.model = model;
		this.randomButton = randomButton;
		this.playList = playList;
	}

	/**
	 * Purpose: make action whenever randomButton is being clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		model.stop();
		playList.shuffleSongs();
	}

}
