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
 *         -Create previous button
 *
 *         Version: 2025-12-9
 */
package src;

import java.awt.Dimension;

import javax.swing.JButton;

public class PreviousButton extends JButton // is a JButton
{
	/**
	 * 
	 * Purpose: set size of the button
	 */
	public PreviousButton()
	{
		this.setText("Prev");
		this.setPreferredSize(new Dimension(60, 30));
		this.setMaximumSize(new Dimension(60, 30));
		setFocusable(false);
	}

}
