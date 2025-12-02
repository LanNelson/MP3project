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
* Version: 2025-10-30
*/
package src;

import java.util.List;

/**
 * Purpose: The reponsibility of SongList is ...
 *
 * SongList is-a ...
 * SongList is ...
 */
public interface SongList
{
	
	public void addSong(String fileWav);
	
	public void removeSong(Song song);
	
	public List<Song> getSongs();
}
