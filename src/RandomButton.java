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
 *         -create random button
 * 
 *         Version: 2025-12-9
 */
package src;

import java.awt.Dimension;

import javax.swing.JButton;

public class RandomButton extends JButton
{
	/**
	 * 
	 * Purpose: setup of random button
	 */
	public RandomButton()
	{
		this.setText("Ran");
		this.setPreferredSize(new Dimension(60, 30));
		this.setMaximumSize(new Dimension(60, 30));
		setFocusable(false);
	}

}
