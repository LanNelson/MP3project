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
 *         Version: 2025-12-10
 */
package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Purpose: The reponsibility of UserInstructions is ...
 *
 * UserInstructions is-a ...
 * UserInstructions is ...
 */
public class UserInstructions extends JFrame
{
	private JTextArea textArea;

	/**
	 * 
	 * Purpose: setup user instruction window
	 */
	public UserInstructions()
	{
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		try
		{
			String content = Files.readString(
					Paths.get("UserInstructions/user_instruction.txt"));
			textArea.setText(content);
		}
		catch (IOException e)
		{
			textArea.setText("Could not read instructions file.");
		}

		JScrollPane scrollPane = new JScrollPane(textArea);

		add(scrollPane);

		setTitle("User Instructions");
		setVisible(true);
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
