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
 *         Version: 2025-10-14
 */
package src;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Purpose: The reponsibility of MP3PlayerModel is ...
 *
 * MP3PlayerModel is-a ...
 * MP3PlayerModel is ...
 */
public class MP3PlayerModel
{
	private PlayList playList;
	private Library lib;
	private Song currentSong;
	private String selectedSong;
	private State currentState = State.STOPPED;
	private SeekBar seekBar;

	public enum State
	{
		PLAYING, PAUSED, STOPPED
	}

	/**
	 * @param currentState the currentState to set
	 */
	public void setCurrentState(State currentState)
	{
		this.currentState = currentState;
	}

	public MP3PlayerModel(Library lib, PlayList playList)
	{
		this.lib = lib;
		this.playList = playList;
	}

	public void setSeekBar(SeekBar seekBar)
	{
		this.seekBar = seekBar;
	}

	public void setSelectedSong(String selectedSong)
	{
		this.selectedSong = selectedSong;
	}

	public void play()
	{
		// get the song only once and remember it

		currentSong = playList.getCurrentSong(selectedSong);
		if (currentSong != null)
		{
			currentSong.play();
			setCurrentState(State.PLAYING);
			if (seekBar != null)
			{
				seekBar.setClip(currentSong.getClip());
				seekBar.enableUserSeek();
				seekBar.startSync();
			}
		}
		else
		{
			System.out.println("Song not found: " + selectedSong);
		}
	}

	public void pause()
	{
		if (currentSong != null)
		{

			currentSong.pause();
			setCurrentState(State.PAUSED);
			if (seekBar != null)
			{
				seekBar.stopSync();
			}
		}
		else
		{
			System.out.println("No song is currently playing.");
		}
	}

	public void resume()
	{
		if (currentSong != null)
		{
			currentSong.resume();
			setCurrentState(State.PLAYING);
			if (seekBar != null)
			{
				seekBar.setClip(currentSong.getClip());
			}
		}
		else
		{
			System.out.println("No song to resume.");
		}
	}

	public void stop()
	{
		if (currentSong != null)
		{
			currentSong.stop();
			setCurrentState(State.STOPPED);
			if (seekBar != null)
			{
				seekBar.stopSync();
				seekBar.setValue(0);
			}
		}
		else
		{
			System.out.println("No song to stop.");
		}
	}

	/**
	 * @return the currentState
	 */
	public State getCurrentState()
	{
		return currentState;
	}

	/**
	 * Purpose:
	 * 
	 * @return
	 */
	public Library getLibrary()
	{
		return this.lib;
	}

	/**
	 * Purpose:
	 * 
	 * @return
	 */
	public PlayList getPlayList()
	{
		// TODO Auto-generated method stub
		return playList;
	}
}
