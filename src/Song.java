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
import java.util.List;

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

	// listeners for song events
	private final List<SongListener> listeners = new ArrayList<>();

	/**
	 * Listener interface for song events. Implementors can register to be
	 * notified when the clip stops.
	 */
	public interface SongListener
	{
		void songStopped(Song song);
	}

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

	public String getSong()
	{
		return filePath;
	}

	public String toString()
	{
		return title + " - " + artist;
	}

	public Clip getClip()
	{
		return clip;
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
		}
	}

	public void stop()
	{
		if (clip != null)
		{
			clip.stop();
			clip.setFramePosition(0); // reset to beginning
		}
	}

	/**
	 * Register a listener to receive song events (e.g., when playback stops).
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