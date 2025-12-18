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
 *         - Main of the project
 *         
 *         Version: 2025-12-9
 */
package src;

public class MP3Player
{
	public static void main(String[] args)
	{
		Library lib = new Library();
		PlayList playList = new PlayList();
		new MP3PlayerView(new MP3PlayerModel(lib,playList), lib, playList);
		new UserInstructions();
	}
}
