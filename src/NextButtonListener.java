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
 *         -Listener of next button
 *
 *         Version: 2025-12-9
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButtonListener implements ActionListener
{
	private MP3PlayerView view; // has a MP3PlayerView
	private MP3PlayerModel model; // has a MP3PlayerModel
	private NextButton nextButton; // has a NextButton
	private PlayListComboBox playListComboBox; // has a PlayListComboBox
	private PlayButton playButton; // has a PlayButton

	/**
	 * 
	 * Purpose: Constructor of NextButtonListener
	 * 
	 * @param view             view of the project
	 * @param model            model of the project
	 * @param nextButton
	 * @param playListComboBox
	 */
	public NextButtonListener(MP3PlayerView view, MP3PlayerModel model,
			NextButton nextButton, PlayListComboBox playListComboBox)
	{
		this.view = view;
		this.model = model;
		this.nextButton = nextButton;
		this.playListComboBox = playListComboBox;
	}

	/**
	 * 
	 * Purpose: setter of playButton
	 * 
	 * @param playButton
	 */
	public void setPlayButton(PlayButton playButton)
	{
		this.playButton = playButton;
	}

	/**
	 * Purpose: skip to next song whenever nextButton is being clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		model.next();
		playButton.setText("Pause");
	}

}
