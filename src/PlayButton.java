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
 *         -Create play button
 *
 *         Version: 2025-12-9
 */
package src;

import java.awt.Dimension;

import javax.swing.JButton;

public class PlayButton extends JButton // is a JButton
{
	private boolean isPaused = true;
	private MP3PlayerModel model; // has a MP3PlayerModel

	/**
	 * 
	 * Purpose: set size of the button
	 * 
	 * @param model model of the project
	 */
	public PlayButton(MP3PlayerModel model)
	{
		this.model = model;
		this.setText("Play");
		this.setPreferredSize(new Dimension(60, 30));
		this.setMaximumSize(new Dimension(60, 30));
		setFocusable(false);
	}

	/**
	 * Purpose: tracking the status of song
	 * 
	 * @return the isPaused
	 */
	public boolean isPaused()
	{
		return isPaused;
	}

	/**
	 * Purpose: setter of isPaused
	 * 
	 * @param isPaused the isPaused to set
	 */
	public void setPaused(boolean isPaused)
	{
		this.isPaused = isPaused;
	}

}