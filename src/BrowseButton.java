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
 *         -BrowseButton is a button that to browse file from user's computer
 *
 *         Version: 2025-12-9
 */
package src;

import java.awt.Dimension;

import javax.swing.JButton;

public class BrowseButton extends JButton // is a JButton
{
	/**
	 * 
	 * Purpose: Create browse Button
	 */
	public BrowseButton()
	{
		this.setText("browse");
		this.setPreferredSize(new Dimension(60, 30));
		this.setMaximumSize(new Dimension(60, 30));
		setFocusable(false);
	}
}
