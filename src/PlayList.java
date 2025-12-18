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
 *         -An list of song that contain all songs
 *
 *         Version: 2025-12-9
 */
package src;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PlayList implements SongList
{
	private ArrayList<Song> songs; // has a many songs
	private Song currentSong; // has a Song
	private PlayListComboBox comboBox; // has a PlayListComboBox

	/**
	 * Purpose: constructor of the PlayList creating an arryaList
	 */
	public PlayList()
	{
		songs = new ArrayList<Song>();
	}

	/**
	 * 
	 * Purpose: setter of comboBox
	 * 
	 * @param comboBox PlayListComboBox
	 */
	public void setComboBox(PlayListComboBox comboBox)
	{
		this.comboBox = comboBox;
	}

	/**
	 * Purpose: Add song into the arrayList
	 */
	@Override
	public void addSong(String fileWav)
	{
		if (fileWav.lastIndexOf('-') == -1 || fileWav.lastIndexOf('.') == -1
				|| fileWav.lastIndexOf('.') < fileWav.lastIndexOf('-')
				|| !fileWav.endsWith(".wav"))
		{
			JOptionPane.showMessageDialog(null,
					"Please ensure the file name is in the format \"Title - Artist.wav\".",
					"Invalid File Name", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int lastSlash = fileWav.lastIndexOf('/');
		int dotIndex = fileWav.lastIndexOf('.');
		String name = fileWav.substring(lastSlash + 1, dotIndex);
		int dashIndex = name.indexOf('-');
		String title = name.substring(0, dashIndex).trim();
		String artist = name.substring(dashIndex + 1).trim();
		songs.add(new Song(title, artist, fileWav));
		comboBox.updateSongs();
	}

	/**
	 * 
	 * Purpose: Shuffle the songs into random order
	 */
	public void shuffleSongs()
	{
		ArrayList<Song> shuffledSongs = new ArrayList<Song>();
		ArrayList<Song> tempSongs = new ArrayList<Song>(songs);

		while (!tempSongs.isEmpty())
		{
			int randomIndex = (int) (Math.random() * tempSongs.size());
			shuffledSongs.add(tempSongs.get(randomIndex));
			tempSongs.remove(randomIndex);
		}
		songs = shuffledSongs;
		comboBox.updateShuffle();
		setCurrentSong(comboBox.getSelectedSong());
	}

	/**
	 * Purpose: getter of the arrayList
	 */
	@Override
	public ArrayList<Song> getSongs()
	{
		return songs;
	}

	/**
	 * 
	 * Purpose: getting current song that is playing
	 * 
	 * @return song
	 */
	public Song getCurrentSong()
	{
		return currentSong;
	}

	/**
	 * 
	 * Purpose: getting next song in the list
	 * 
	 * @return song
	 */
	public Song getNextSong()
	{
		if (songs.isEmpty())
		{
			return null;
		}
		int currentIndex = songs.indexOf(currentSong);
		int nextIndex = (currentIndex + 1) % songs.size();
		return songs.get(nextIndex);

	}

	/**
	 * 
	 * Purpose: set comboBox into next song
	 */
	public void next()
	{
		currentSong = getNextSong();
		int index = comboBox.getSelectedIndex();
		comboBox.setSelectedIndex((index + 1) % songs.size());
	}

	/**
	 * Purpose: set current song to selected Song
	 * 
	 * @param selectedSong
	 */
	public void setCurrentSong(String selectedSong)
	{
		for (Song s : songs)
		{
			if (s.toString().equals(selectedSong))
			{
				currentSong = s;
				return;
			}
		}

	}

	/**
	 * Purpose: set comboBox into previous song
	 */
	public void previous()
	{
		if (songs.size() == 0)
		{
			return;
		}
		currentSong = getPreviousSong();
		int index = comboBox.getSelectedIndex();
		comboBox.setSelectedIndex((index - 1 + songs.size()) % songs.size());

	}

	/**
	 * Purpose: getting previous song in the list
	 * 
	 * @return song
	 */
	private Song getPreviousSong()
	{
		if (songs.isEmpty())
		{
			return null;
		}
		int currentIndex = songs.indexOf(currentSong);
		int nextIndex = (currentIndex - 1 + songs.size()) % songs.size();
		return songs.get(nextIndex);
	}

}
