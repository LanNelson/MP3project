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
 *         -The listener of previous button
 *
 *         Version: 2025-12-9
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousButtonListener implements ActionListener
{
	private MP3PlayerView view; // has a MP3Player
	private MP3PlayerModel model; // has a MP3PlayerModel
	private PreviousButton previousButton; // has a PreviousButton
	private PlayListComboBox playListComboBox; // has a PlayListComboBox
	private PlayButton playButton; // has a PlayButton

	/**
	 * 
	 * Purpose: constructor of PreviousButtonListener
	 * 
	 * @param view
	 * @param model
	 * @param previousButton
	 * @param playListComboBox
	 */
	public PreviousButtonListener(MP3PlayerView view, MP3PlayerModel model,
			PreviousButton previousButton, PlayListComboBox playListComboBox)
	{
		this.view = view;
		this.model = model;
		this.previousButton = previousButton;
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
	 * Purpose: when previous button is being clicked make action
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		model.previous();
		playButton.setText("Pause");
	}

}
