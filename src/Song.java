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
 *         -information of a song
 *
 *         Version: 2025-12-9
 */
package src;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Song
{
	private String title = null;
	private String artist = null;
	private String filePath;
	private Clip clip; // has a Clip
	private final List<SongListener> listeners = new ArrayList<>();

	/**
	 * Listener interface for song events. Implementors can register to be
	 * notified when the clip stops.
	 */
	public interface SongListener
	{
		void songStopped(Song song);
	}

	/**
	 * 
	 * Purpose: constructor of Song and loadClip to enable to play song
	 * @param title
	 * @param artist
	 * @param filePath
	 */
	public Song(String title, String artist, String filePath)
	{
		this.title = title;
		this.artist = artist;
		this.filePath = filePath;
		loadClip();
		clip.addLineListener(e -> {
			if (e.getType() == javax.sound.sampled.LineEvent.Type.STOP)
			{
				notifySongStopped();
			}
		});

	}

	/**
	 * 
	 * Purpose: start the song
	 */
	public void play()
	{
		if (clip == null)
		{
			loadClip();
		}
		clip.start();
	}

	/**
	 * Purpose: pause the song
	 */
	public void pause()
	{
		if (clip != null && clip.isRunning())
		{
			clip.stop();
		}
	}

	/**
	 * 
	 * Purpose: resume the song
	 */
	public void resume()
	{
		if (clip != null && !clip.isRunning())
		{
			clip.start();
		}
	}

	/**
	 * 
	 * Purpose: stop the song and set clip frame position to 0
	 */
	public void stop()
	{
		if (clip != null)
		{
			clip.stop();
			clip.setFramePosition(0); // reset to beginning
		}
	}

	/**
	 * 
	 * Purpose: getter of song 
	 * @return the path of the song
	 */
	public String getSong()
	{
		return filePath;
	}

	/**
	 * @return song title and artist
	 */
	public String toString()
	{
		return title + " - " + artist;
	}

	/**
	 * 
	 * Purpose: getter of the clip
	 * @return clip
	 */
	public Clip getClip()
	{
		return clip;
	}

	/**
	 * 
	 * Purpose: add clip to the song
	 */
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

	/**
	 * Register a listener to receive song events
	 */
	public void addSongListener(SongListener l)
	{
		if (l == null) return;
		if (hasListener(l))
		{
			return;
		}
		synchronized (listeners)
		{
			listeners.add(l);
		}
	}

	/**
	 * Remove a previously registered listener.
	 */
	public void removeSongListener(SongListener l)
	{
		if (l == null) return;
		synchronized (listeners)
		{
			listeners.remove(l);
		}
	}

	/**
	 * 
	 * Purpose: check if listener is created
	 * @param l songListener
	 * @return
	 */
	public boolean hasListener(SongListener l)
	{
		return listeners.contains(l);
	}

	/**
	 * Notify all listeners that the song stopped. A copy of the listener list
	 * is used to avoid concurrent modification.
	 */
	private void notifySongStopped()
	{
		List<SongListener> copy;
		synchronized (listeners)
		{
			copy = new ArrayList<>(listeners);
		}
		for (SongListener l : copy)
		{
			try
			{
				l.songStopped(this);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

}