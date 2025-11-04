/**
* Lead Author(s):
* @author nelson; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-10-09
*/
package src;

import java.awt.Dimension;

import javax.swing.JButton;

/**
 * Purpose: The reponsibility of playButton is ...
 *
 * playButton is-a ...
 * playButton is ...
 */
public class PlayButton extends JButton
{
	private boolean isPaused = true;
	private MP3PlayerModel model;

    /**
	 * @return the isPaused
	 */
	public boolean isPaused()
	{
		return isPaused;
	}

	/**
	 * @param isPaused the isPaused to set
	 */
	public void setPaused(boolean isPaused)
	{
		this.isPaused = isPaused;
	}
	
	public void togglePause() {
		model.pause();
	}

	public PlayButton(MP3PlayerModel model)
    {
		this.model = model;
    	this.setText("Play");
		this.setPreferredSize(new Dimension(60,30));
		this.setMaximumSize(new Dimension(60,30));
		setFocusable(false);
    }
    
    
}