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

import java.io.File;
import java.util.ArrayList;

/**
 * Purpose: The reponsibility of Library is ...
 *
 * Library is-a ...
 * Library is ...
 * Library has many songs
 */
public class Library extends SongList
{
	private ArrayList<Song> songs; // has many songs

	public Library()
	{
		songs = new ArrayList<Song>();
	}

	

	public String toString()
	{
		return songs.toString();
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
	}

	@Override
	public void removeSong(Song song)
	{
		// TODO Auto-generated method stub
		
	}



	@Override
	public ArrayList<Song> getSongs()
	{
		return songs;
	}
	
}
