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
 *         Version: 2025-10-30
 */
package src;

import java.awt.Dimension;

import javax.swing.JButton;

/**
 * Purpose: The reponsibility of BrowseButton is ...
 *
 * BrowseButton is-a ...
 * BrowseButton is ...
 */
public class BrowseButton extends JButton
{
	public BrowseButton()
	{
		this.setText("browse");
		this.setPreferredSize(new Dimension(60, 30));
		this.setMaximumSize(new Dimension(60, 30));
		setFocusable(false);
	}
}
