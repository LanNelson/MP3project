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
 *         Version: 2025-10-30
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

/**
 * Purpose: The reponsibility of BrowseButtonListener is ...
 *
 * BrowseButtonListener is-a ...
 * BrowseButtonListener is ...
 */
public class BrowseButtonListener implements ActionListener
{
	private MP3PlayerView view;
	private MP3PlayerModel model;
	private BrowseButton browseButton;
	private LibraryComboBox libraryComboBox;

	public BrowseButtonListener(MP3PlayerView view, MP3PlayerModel model,
			BrowseButton browseButton, LibraryComboBox libraryComboBox)
	{
		this.view = view;
		this.model = model;
		this.browseButton = browseButton;
		this.libraryComboBox = libraryComboBox;
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JFileChooser fileChooser = new JFileChooser();
		int response = fileChooser.showOpenDialog(null);
		
		if (response == JFileChooser.APPROVE_OPTION)
		{
			File wavFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
			model.getLibrary().addSong(wavFile.toString());
			libraryComboBox.updateSongs();
		}
	}

}
