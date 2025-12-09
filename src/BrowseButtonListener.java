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
 *         -BrowseButtonListener is to do action when ever user click browse button
 *
 *         Version: 2025-12-9
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;


public class BrowseButtonListener implements ActionListener
{
	private MP3PlayerView view; // has a MP3PlayerView
	private MP3PlayerModel model; // has a MP3PlayerModel
	private BrowseButton browseButton; // has a BrowseButton
	private PlayListComboBox playListComboBox; // has a PlayListComboBox

	/**
	 * 
	 * Purpose: constructor of BrowseButtonListener
	 * @param view view of mp3 player
	 * @param model model of mp3 player
	 * @param browseButton
	 * @param playListComboBox 
	 */
	public BrowseButtonListener(MP3PlayerView view, MP3PlayerModel model,
			BrowseButton browseButton, PlayListComboBox playListComboBox)
	{
		this.view = view;
		this.model = model;
		this.browseButton = browseButton;
		this.playListComboBox = playListComboBox;
		
	}

	/**
	 * Purpose: adding file from user's computer into play list
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JFileChooser fileChooser = new JFileChooser();
		int response = fileChooser.showOpenDialog(null);
		
		if (response == JFileChooser.APPROVE_OPTION)
		{
			File wavFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
			model.getLibrary().addSong(wavFile.toString());
			model.getPlayList().addSong(wavFile.toString());
		}
	}

}
