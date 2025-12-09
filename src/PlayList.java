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
 *         Version: 2025-10-09
 */
package src;

import java.util.ArrayList;

/**
 * Purpose: The reponsibility of PlayList is ...
 *
 * PlayList is-a ...
 * PlayList is ...
 */
public class PlayList implements SongList
{
	private ArrayList<Song> songs;
	private Song currentSong;
	private PlayListComboBox comboBox;

	public PlayList()
	{
		songs = new ArrayList<Song>();
	}

	public void setComboBox(PlayListComboBox comboBox)
	{
		this.comboBox = comboBox;
	}

	@Override
	public void addSong(String fileWav)
	{
		int lastSlash = fileWav.lastIndexOf('/');
		int dotIndex = fileWav.lastIndexOf('.');
		String name = fileWav.substring(lastSlash + 1, dotIndex);
		int dashIndex = name.indexOf('-');
		String title = name.substring(0, dashIndex).trim();
		String artist = name.substring(dashIndex + 1).trim();
		songs.add(new Song(title, artist, fileWav));
		comboBox.updateSongs();
	}


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
	}

	@Override
	public ArrayList<Song> getSongs()
	{
		return songs;
	}

	public Song getCurrentSong()
	{
		return currentSong;
	}

	public Song getNextSong()
	{
		if(songs.isEmpty()) {
			return null;
		}
		int currentIndex = songs.indexOf(currentSong);
		int nextIndex = (currentIndex + 1) % songs.size();
		return songs.get(nextIndex);
		
	}

	public void next()
	{		
		currentSong = getNextSong();
		int index = comboBox.getSelectedIndex();
		System.out.println(songs.size());
		comboBox.setSelectedIndex((index + 1) % songs.size());
	}

	/**
	 * Purpose:
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
	 * Purpose: 
	 */
	public void previous()
	{
		if(songs.size()==0) {
			return;
		}
		currentSong = getPrevousSong();
		int index = comboBox.getSelectedIndex();
		comboBox.setSelectedIndex((index - 1 + songs.size()) % songs.size());
		
	}

	/**
	 * Purpose: 
	 * @return
	 */
	private Song getPrevousSong()
	{
		if(songs.isEmpty()) {
			return null;
		}
		int currentIndex = songs.indexOf(currentSong);
		int nextIndex = (currentIndex - 1 + songs.size()) % songs.size();
		return songs.get(nextIndex);
	}

}
