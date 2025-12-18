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
 *         -A comboBox that has contains songs in playList
 *
 *         Version: 2025-12-9
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;


public class PlayListComboBox extends JComboBox implements ActionListener // is a JComboBox
{
	private Library lib; // has Library
	private PlayList playList; //has PlayList
	private MP3PlayerModel model; // has MP3PlayerModel

	/**
	 * 
	 * Purpose: constructor of PlayListComboBox
	 * @param lib
	 * @param playList
	 * @param model
	 */
	public PlayListComboBox(Library lib, PlayList playList,
			MP3PlayerModel model)
	{
		this.lib = lib;
		this.playList = playList;
		this.model = model;

		this.setMaximumSize(new java.awt.Dimension(200, 30));
		this.setPreferredSize(new java.awt.Dimension(200, 30));
		this.setFocusable(false);

		addActionListener(this);
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

	public void updateShuffle() {
	    DefaultComboBoxModel<Song> newModel = new DefaultComboBoxModel<>();

	    for (Song song : playList.getSongs()) {
	        newModel.addElement(song);
	    }

	    this.setModel(newModel);
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
