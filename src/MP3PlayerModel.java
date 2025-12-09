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

import src.Song.SongListener;

/**
 * Purpose: The reponsibility of MP3PlayerModel is ...
 *
 * MP3PlayerModel is-a ...
 * MP3PlayerModel is ...
 */
public class MP3PlayerModel implements SongListener
{
	private PlayList playList;
	private Library lib;
	private Song currentSong;
	private String selectedSong;
	private State currentState = State.STOPPED;
	private SeekBar seekBar;
	private boolean isPaused = true;
	private boolean isManualSkiped = false;

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

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			if (currentSong != null && currentSong.getClip() != null)
			{
				currentSong.getClip().stop();
				currentSong.getClip().close();
			}
		}));
	}

	public void setSeekBar(SeekBar seekBar)
	{
		this.seekBar = seekBar;
	}

	public void setSelectedSong(String selectedSong)
	{
		this.selectedSong = selectedSong;
		playList.setCurrentSong(selectedSong);

		playList.getCurrentSong().addSongListener(this);

	}

	@Override
	public void songStopped(Song song)
	{

		if (!song.getClip().isRunning() && !isPaused && !isManualSkiped)
		{
			next();
		}
	}

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
		return playList;
	}
}
