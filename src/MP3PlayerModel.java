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
	public enum State {
		PLAYING,
		PAUSED,
		STOPPED
	}

	private State currentState = State.STOPPED;
	
	/**
	 * @return the currentState
	 */
	public State getCurrentState()
	{
		return currentState;
	}

	/**
	 * @param currentState the currentState to set
	 */
	public void setCurrentState(State currentState)
	{
		this.currentState = currentState;
	}

	public MP3PlayerModel(Library lib)
	{
		this.lib = lib;
		this.playList = new PlayList(lib);
	}

	public void play(String songName) {
        // get the song only once and remember it
		
        currentSong = playList.getCurrentSong(songName);
        if (currentSong != null) {
            currentSong.play();
            setCurrentState(State.PLAYING);
        } else {
            System.out.println("Song not found: " + songName);
        }
    }

    public void pause() {
        if (currentSong != null) {
        	
            currentSong.pause();
            setCurrentState(State.PAUSED);
        } else {
            System.out.println("No song is currently playing.");
        }
    }

    public void resume() {
        if (currentSong != null) {
            currentSong.resume();
            setCurrentState(State.PLAYING);
        } else {
            System.out.println("No song to resume.");
        }
    }

    public void stop() {
        if (currentSong != null) {
            currentSong.stop();
            setCurrentState(State.STOPPED);
        } else {
            System.out.println("No song to stop.");
        }
    }

	/**
	 * Purpose: 
	 * @return
	 */
	public Library getLibrary()
	{
		
		return this.lib;
	}
}

	

