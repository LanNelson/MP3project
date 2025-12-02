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
 *         Version: 2025-10-09
 */
package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 * Purpose: The reponsibility of MP3Player is ...
 *
 * MP3Player is-a ...
 * MP3Player is ...
 */
public class MP3PlayerView extends JFrame
{

	private SeekBar seekBar;
	private PlayButton playButton;
	private PreviousButton previousButton;
	private NextButton nextButton;
	private RandomButton randomButton;
	private BrowseButton browseButton;
	private PlayListComboBox playListComboBox;
	private MP3PlayerModel model;

	public MP3PlayerView(MP3PlayerModel model, Library lib, PlayList playList)
	{
		this.model = model;

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		// add buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setAlignmentX(CENTER_ALIGNMENT);

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
		seekBar.setNextButton(nextButton);

		PreviousButtonListener previousListener = new PreviousButtonListener(
				this, model, previousButton, playListComboBox);
		previousButton.addActionListener(previousListener);
		previousListener.setPlayButton(playButton);

		RandomButtonListener randomListener = new RandomButtonListener(this,
				model, randomButton, playList);
		randomButton.addActionListener(randomListener);

		setTitle("MP3 Player");
		setVisible(true);
		setSize(400, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// TODO: remove this hardcoded song addition later
//		File wavFile = new File("Songs/Lose my mind-Don Tolive.wav");
//		model.getLibrary().addSong(wavFile.toString());
//		model.getPlayList().addSong(wavFile.toString());
//		File wavFile1 = new File("Songs/黑洞里-方大同.wav");
//		model.getLibrary().addSong(wavFile1.toString());
//		model.getPlayList().addSong(wavFile1.toString());
	}

	public void clickNext()
	{
		nextButton.doClick();
	}

}
