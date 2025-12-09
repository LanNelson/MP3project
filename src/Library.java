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
 *         -To adding song into a file that contain list of songs
 *
 *         Version: 2025-12-9
 */
package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Library implements SongList
{
	private ArrayList<Song> songs; // has many songs
	private static int seiralNum;

	/**
	 * 
	 * Purpose: Constructor of Library, create an array list and text file
	 */
	public Library()
	{
		songs = new ArrayList<Song>();
		if (new File("Library.txt").exists())
		{
			try
			{
				FileWriter fileWriter = new FileWriter("Library.txt");
			}
			catch (IOException e)
			{
				System.out.println(e);
			}
		}
	}
	
	/**
	 * Purpose: adding songs into a text file
	 */
	@Override
	public void addSong(String fileWav)
	{
		createNewSerialNumber();
		
		int lastSlash = fileWav.lastIndexOf('/');
		int dotIndex = fileWav.lastIndexOf('.');
		String name = fileWav.substring(lastSlash + 1, dotIndex);
		int dashIndex = name.indexOf('-');
		String title = name.substring(0, dashIndex).trim();
		String artist = name.substring(dashIndex + 1).trim();
		songs.add(new Song(title, artist, fileWav));
		addSongToFile(seiralNum + ", " + title + "-" + artist);

	}

	/**
	 * 
	 * Purpose: 
	 * @param fileWav
	 */
	public void addSongToFile(String fileWav)
	{

		try
		{
			PrintWriter filePrinter = new PrintWriter(
					new FileWriter(new File("Library.txt"), true));
			filePrinter.println(fileWav);
			filePrinter.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
	
	public static int createNewSerialNumber()
	{
		seiralNum++;
		return seiralNum;
	}

	
	@Override
	public ArrayList<Song> getSongs()
	{
		return songs;
	}

}
