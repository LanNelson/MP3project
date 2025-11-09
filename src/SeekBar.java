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

import java.awt.Dimension;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Purpose: The reponsibility of SeekBar is ...
 *
 * SeekBar is-a JSlider
 * SeekBar is ...
 */
public class SeekBar extends JSlider
{
	private Clip clip;
	private Timer timer;

	public SeekBar()
	{
		this.setOrientation(SwingConstants.HORIZONTAL);
		this.setValue(0);
		this.setPreferredSize(new Dimension(250, 20));
		this.setMaximumSize(new Dimension(250, 20));
	}

	public void setClip(Clip clip)
	{
		this.clip = clip;
		if (clip != null)
		{
			this.setMaximum((int) clip.getMicrosecondLength());
			startSync();
		}
	}

	public void startSync()
	{
		if (timer != null)
		{
			timer.cancel();
		}

		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				if (clip != null && clip.isRunning())
				{
					int currentPos = (int) clip.getMicrosecondPosition();

					SwingUtilities.invokeLater(() -> {
						setValue(currentPos);
					});
				}
			}
		}, 0, 200);
	}

	public void stopSync()
	{
		if (timer != null)
		{
			timer.cancel();
			timer = null;
		}
	}

	public void enableUserSeek()
	{
		this.addChangeListener(e -> {
			if (clip != null && !getValueIsAdjusting())
			{
				clip.setMicrosecondPosition(getValue());
			}
		});
	}

	public void reset()
	{
		stopSync();
		this.setValue(0);
		this.clip = null;
	}
}