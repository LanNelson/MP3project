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
* Version: 2025-10-16
*/
package src;

import javax.swing.JComboBox;

/**
 * Purpose: The reponsibility of LibraryComboBox is ...
 *
 * LibraryComboBox is-a ...
 * LibraryComboBox is ...
 */
public class LibraryComboBox extends JComboBox
{
	private Library lib;
	public LibraryComboBox(Library lib)
	{	
		this.lib = lib;
		
		this.setMaximumSize(new java.awt.Dimension(200, 30));
		this.setPreferredSize(new java.awt.Dimension(200, 30));
		this.setFocusable(false);
		
		for (int i = 0; i < lib.getSongs().size(); i++)
		{
			this.addItem(lib.getSongs().get(i));
		}
		
	}
	
	public String getSelectedSong()
	{
		return this.getSelectedItem().toString();
	}
	
	public void updateSongs()
	{
		this.removeAllItems();
		for (int i = 0; i < lib.getSongs().size(); i++)
		{
			this.addItem(lib.getSongs().get(i));
		}
	}

}
