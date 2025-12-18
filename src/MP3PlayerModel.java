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
 *         -function of the project
 *
 *         Version: 2025-12-9
 */
package src;

import src.Song.SongListener;

public class MP3PlayerModel implements SongListener
{
	private PlayList playList; // has a PlayList
	private Library lib; // has a Library
	private Song currentSong; // has a Song
	private String selectedSong;
	private State currentState = State.STOPPED; // has a State
	private SeekBar seekBar; // has a SeekBar
	private boolean isPaused = true;
	private boolean isManualSkiped = false;

	/**
	 * 
	 * Purpose: The reponsibility of State is to monitor the state of song
	 */
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

	/**
	 * 
	 * Purpose: constructor of the class
	 * @param lib Library class
	 * @param playList
	 */
	public MP3PlayerModel(Library lib, PlayList playList)
	{
		this.lib = lib;
		this.playList = playList;

	}

	/**
	 * 
	 * Purpose: Setter of seekbar
	 * @param seekBar
	 */
	public void setSeekBar(SeekBar seekBar)
	{
		this.seekBar = seekBar;
	}

	/**
	 * 
	 * Purpose: setter of song being selected
	 * @param selectedSong
	 */
	public void setSelectedSong(String selectedSong)
	{
		this.selectedSong = selectedSong;
		playList.setCurrentSong(selectedSong);
		playList.getCurrentSong().addSongListener(this);

	}

	/**
	 * Purpose: skip to next song automatically
	 */
	@Override
	public void songStopped(Song song)
	{

		if (!song.getClip().isRunning() && !isPaused && !isManualSkiped)
		{
			next();
		}
	}

	/**
	 * 
	 * Purpose: Play the song
	 */
	public void play()
	{
		currentSong = playList.getCurrentSong();
		if (currentSong != null)
		{
			currentSong.play();
			setCurrentState(State.PLAYING);
			isPaused = false;
			if (seekBar != null)
			{
				seekBar.setClip(currentSong.getClip());
				seekBar.enableUserSeek();
				seekBar.startSync();
			}
		}

	}
	
	/**
	 * 
	 * Purpose: Pause the song
	 */
	public void pause()
	{
		currentSong = playList.getCurrentSong();
		if (currentSong != null)
		{

			currentSong.pause();
			setCurrentState(State.PAUSED);
			isPaused = true;
			if (seekBar != null)
			{
				seekBar.stopSync();
			}
		}

	}

	/**
	 * 
	 * Purpose: Resume the song
	 */
	public void resume()
	{
		currentSong = playList.getCurrentSong();
		if (currentSong != null)
		{
			currentSong.resume();
			setCurrentState(State.PLAYING);
			isPaused = false;
			if (seekBar != null)
			{
				seekBar.setClip(currentSong.getClip());
			}
		}

	}

	/**
	 * 
	 * Purpose: Stop the song
	 */
	public void stop()
	{
		currentSong = playList.getCurrentSong();
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

	}

	/**
	 * 
	 * Purpose: Skip the song
	 */
	public void next()
	{
		isManualSkiped = true;

		currentSong = playList.getCurrentSong();
		if (currentSong != null)
		{
			currentSong.stop();
		}
		isPaused = false;
		playList.next();
		play();

		isManualSkiped = false;
	}

	/**
	 * 
	 * Purpose: Change to previouse song
	 */
	public void previous()
	{
		isManualSkiped = true;

		currentSong = playList.getCurrentSong();
		if (currentSong != null)
		{
			currentSong.stop();
		}
		isPaused = false;
		playList.previous();
		play();

		isManualSkiped = false;
	}

	/**
	 * @return the currentState
	 */
	public State getCurrentState()
	{
		return currentState;
	}

	/**
	 * Purpose: getter of Library
	 * 
	 * @return Library
	 */
	public Library getLibrary()
	{
		return this.lib;
	}

	/**
	 * Purpose: getter of PlayList
	 * 
	 * @return PlayList
	 */
	public PlayList getPlayList()
	{
		return playList;
	}
}
