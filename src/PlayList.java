/**
* Lead Author(s):
* @author nelson; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-10-09
*/
package src;

import java.util.ArrayList;

/**
 * Purpose: The reponsibility of PlayList is ...
 *
 * PlayList is-a ...
 * PlayList is ...
 */
public class PlayList extends SongList
{	
	private Library lib;
	private ArrayList<Song> songs;
	
	public PlayList(Library lib) {
		
		this.lib = lib;
		songs = new ArrayList<Song>();
		songs = lib.getSongs(); // NEED TO CHANGE THIS, SO PLAYLIST HAS DIFFERENT SONGS THAN LIBRARY
	}

	@Override
	public void addSong(String fileWav)
	{
		// TODO Auto-generated method stub
		
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
		
	public Song getCurrentSong(String title)
	{
		for(Song s : songs)
		{
			if(s.toString().equals(title))
			{
				return s;
			}
		}
		return null;
	}
	
}
