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
 *         -an interface of list of song
 *
 *         Version: 2025-12-9
 */
package src;

import java.util.List;


public interface SongList
{
	/**
	 * 
	 * Purpose: add song into list
	 * @param fileWav
	 */
	public void addSong(String fileWav);
	
	/**
	 * 
	 * Purpose: getter of list
	 * @return list
	 */
	public List<Song> getSongs();
}
