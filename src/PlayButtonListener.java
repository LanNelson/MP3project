/**
 * Lead Author(s):
 * 
 * @author nelson; student ID
 * @author Full name; student ID
 *         <<Add additional lead authors here>>
 *
 *         Other Contributors:
 *         Full name; student ID or contact information if not in class
 *         <<Add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 *         <<Add more references here>>
 *
 *         Version: 2025-10-14
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Purpose: The reponsibility of ButtonListener is ...
 *
 * ButtonListener is-a ...
 * ButtonListener is ...
 */
public class PlayButtonListener implements ActionListener
{
	private MP3PlayerView view;
	private MP3PlayerModel model;
	private PlayButton playButton;
	private LibraryComboBox libraryComboBox;

	public PlayButtonListener(MP3PlayerView view, MP3PlayerModel model,
			PlayButton playButton, LibraryComboBox libraryComboBox)
	{
		this.view = view;
		this.model = model;
		this.playButton = playButton;
		this.libraryComboBox = libraryComboBox;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String selectedSong = libraryComboBox.getSelectedSong();

		switch (model.getCurrentState())
		{
			case PLAYING:
				model.pause();
				break;
			case STOPPED:
				model.play(selectedSong);
				break;
			case PAUSED:
				model.resume();
			default:
				break;
		}
		
		updateView();

	}

	/**
	 * Purpose: 
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
