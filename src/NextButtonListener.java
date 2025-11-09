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
 * Purpose: The reponsibility of NextButtonListener is ...
 *
 * NextButtonListener is-a ...
 * NextButtonListener is ...
 */
public class NextButtonListener implements ActionListener
{
	private MP3PlayerView view;
	private MP3PlayerModel model;
	private NextButton nextButton;
	private LibraryComboBox libraryComboBox;

	public NextButtonListener(MP3PlayerView view, MP3PlayerModel model,
			NextButton nextButton, LibraryComboBox libraryComboBox)
	{
		this.view = view;
		this.model = model;
		this.nextButton = nextButton;
		this.libraryComboBox = libraryComboBox;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int currentIndex = libraryComboBox.getSelectedIndex();
		int totalItems = libraryComboBox.getItemCount();

		if (totalItems > 0)
		{
			int nextIndex = (currentIndex + 1) % totalItems;
			libraryComboBox.setSelectedIndex(nextIndex);
		}
		model.play();
	}

}
