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
 *         Version: 2025-10-16
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

/**
 * Purpose: The reponsibility of LibraryComboBox is ...
 *
 * LibraryComboBox is-a ...
 * LibraryComboBox is ...
 */
public class PlayListComboBox extends JComboBox implements ActionListener
{
	private Library lib;
	private PlayList playList;
	private MP3PlayerModel model;

	public PlayListComboBox(Library lib, PlayList playList,
			MP3PlayerModel model)
	{
		this.lib = lib;
		this.playList = playList;
		this.model = model;

		this.setMaximumSize(new java.awt.Dimension(200, 30));
		this.setPreferredSize(new java.awt.Dimension(200, 30));
		this.setFocusable(false);

		for (int i = 0; i < playList.getSongs().size(); i++)
		{
			this.addItem(playList.getSongs().get(i));
		}

		addActionListener(this);
		lib.setView(this);
	}

	public String getSelectedSong()
	{
		if (this.getSelectedItem() == null)
		{
			return "";
		}
		return this.getSelectedItem().toString();
	}
	
	

	public void updateSongs()
	{
		this.addItem(playList.getSongs().get(playList.getSongs().size() - 1));

	}

	public void updateShuffle()
	{
	    this.removeAllItems();
	    
		for (int i = 0; i < playList.getSongs().size(); i++)
		{
			this.addItem(playList.getSongs().get(i));
		}
	}


	/**
	 * when user do something to the combo box, this will trigger
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		model.stop();
		String selectedSong = getSelectedSong();
		model.setSelectedSong(selectedSong);

	}

}
