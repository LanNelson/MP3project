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
 *         -make action once the play button being clicked
 *
 *         Version: 2025-12-9
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonListener implements ActionListener
{
	private MP3PlayerView view; // has MP3PlayerView
	private MP3PlayerModel model; // has MP3PlayerModel
	private PlayButton playButton; // has PlayButton
	private PlayListComboBox playListComboBox; // has PlayListComboBox

	/**
	 * 
	 * Purpose: Constructor of PlayButtonListener
	 * 
	 * @param view             view of the project
	 * @param model            model of the project
	 * @param playButton
	 * @param playListComboBox
	 */
	public PlayButtonListener(MP3PlayerView view, MP3PlayerModel model,
			PlayButton playButton, PlayListComboBox playListComboBox)
	{
		this.view = view;
		this.model = model;
		this.playButton = playButton;
		this.playListComboBox = playListComboBox;
	}

	/**
	 * Purpose: play the song
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String selectedSong = playListComboBox.getSelectedSong();

		switch (model.getCurrentState())
		{
			case PLAYING:
				model.pause();
				break;
			case STOPPED:
				model.play();
				break;
			case PAUSED:
				model.resume();
			default:
				break;
		}

		updateView();

	}

	/**
	 * Purpose: update the text on playButton
	 */
	private void updateView()
	{
		switch (model.getCurrentState())
		{
			case PLAYING:
				playButton.setText("Pause");
				break;
			case STOPPED:
				playButton.setText("Play");
				break;
			case PAUSED:
				playButton.setText("Play");
			default:
				break;
		}
	}
}
