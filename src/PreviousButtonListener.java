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
 *         Version: 2025-11-08
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Purpose: The reponsibility of PreviousButtonListener is ...
 *
 * PreviousButtonListener is-a ...
 * PreviousButtonListener is ...
 */
public class PreviousButtonListener implements ActionListener
{
	private MP3PlayerView view;
	private MP3PlayerModel model;
	private PreviousButton previousButton;
	private LibraryComboBox libraryComboBox;

	public PreviousButtonListener(MP3PlayerView view, MP3PlayerModel model,
			PreviousButton previousButton, LibraryComboBox libraryComboBox)
	{
		this.view = view;
		this.model = model;
		this.previousButton = previousButton;
		this.libraryComboBox = libraryComboBox;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int currentIndex = libraryComboBox.getSelectedIndex();
		int totalItems = libraryComboBox.getItemCount();

		if (totalItems > 0)
		{
			int previousIndex = (currentIndex - 1 + totalItems) % totalItems;
			libraryComboBox.setSelectedIndex(previousIndex);
		}
		model.play();
	}
}
