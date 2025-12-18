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
 *         -The view of the project, creating GUI
 *
 *         Version: 2025-12-9
 */
package src;

import java.awt.BorderLayout;


import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MP3PlayerView extends JFrame // is a JFrame
{

	private SeekBar seekBar;  // has a seekBar
	private PlayButton playButton; // has a PlayButton
	private PreviousButton previousButton; // has a PreviousButton
	private NextButton nextButton; // has a NextButton
	private RandomButton randomButton; // has a RandomButton
	private BrowseButton browseButton; // has a BrowseButton
	private PlayListComboBox playListComboBox; // has a PlayListComboBox
	private ImageIcon image;

	/**
	 * 
	 * Purpose: Creating GUI
	 * @param model MP3 player model
	 * @param lib Library
	 * @param playList PlayList
	 */
	public MP3PlayerView(MP3PlayerModel model, Library lib, PlayList playList)
	{
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		// add buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setAlignmentX(CENTER_ALIGNMENT);

		// Buttons
		playButton = new PlayButton(model);
		previousButton = new PreviousButton();
		nextButton = new NextButton();
		randomButton = new RandomButton();
		browseButton = new BrowseButton();

		playListComboBox = new PlayListComboBox(lib, playList, model);
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(browseButton, BorderLayout.NORTH);
		topPanel.add(playListComboBox, BorderLayout.SOUTH);

		add(topPanel, BorderLayout.NORTH);

		image = new ImageIcon("Icon/Icon.png");
		JLabel imageLabel = new JLabel();
		imageLabel.setIcon(image);
		JPanel imagePanel = new JPanel();
		imagePanel.add(imageLabel);
		add(imagePanel, BorderLayout.CENTER);

		buttonPanel.add(previousButton);
		buttonPanel.add(playButton);
		buttonPanel.add(nextButton);
		buttonPanel.add(randomButton);

		southPanel.add(buttonPanel);

		// add seek bar
		seekBar = new SeekBar();
		southPanel.add(seekBar);

		add(southPanel, BorderLayout.SOUTH);

		playList.setComboBox(playListComboBox);

		model.setSeekBar(seekBar);
		browseButton.addActionListener(new BrowseButtonListener(this, model,
				browseButton, playListComboBox));
		playButton.addActionListener(new PlayButtonListener(this, model,
				playButton, playListComboBox));

		NextButtonListener nextListener = new NextButtonListener(this, model,
				nextButton, playListComboBox);
		nextButton.addActionListener(nextListener);
		nextListener.setPlayButton(playButton);

		PreviousButtonListener previousListener = new PreviousButtonListener(
				this, model, previousButton, playListComboBox);
		previousButton.addActionListener(previousListener);
		previousListener.setPlayButton(playButton);

		RandomButtonListener randomListener = new RandomButtonListener(this,
				model, randomButton, playList);
		randomButton.addActionListener(randomListener);

		setTitle("MP3 Player");
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

	}

}
