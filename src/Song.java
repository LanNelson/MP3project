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

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Purpose: The reponsibility of Song is ...
 *
 * Song is-a ...
 * Song is ...
 */
public class Song implements Playable
{
	private String title;
	private String artist;
	private String filePath;
	private Clip clip;

	public Song(String title, String artist, String filePath)
	{
		this.title = title;
		this.artist = artist;
		this.filePath = filePath;
		loadClip();
	}

	public String getSong()
	{
		return filePath;
	}

	public String toString()
	{
		return title + " - " + artist;
	}

	private void loadClip()
	{
		try
		{
			File musicFile = new File(filePath);
			AudioInputStream audioStream = AudioSystem
					.getAudioInputStream(musicFile);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void play()
	{
		if (clip == null)
		{
			loadClip();
		}
		clip.start();
	}

	/**
	 * Purpose:
	 */
	public void pause()
	{
		if (clip != null && clip.isRunning())
		{
			clip.stop();
		}
	}

	public void resume()
	{
		if (clip != null && !clip.isRunning())
		{
			clip.start();
			System.out.println("Resumed: " + filePath);
		}
	}

	public void stop()
	{
		if (clip != null)
		{
			clip.stop();
			clip.setFramePosition(0); // reset to beginning
			System.out.println("Stopped: " + filePath);
		}
	}
	
	

}
