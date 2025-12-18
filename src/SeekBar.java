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
 *         -seekBar of the MP3 player
 *
 *         Version: 2025-12-9
 */
package src;

import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.Clip;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


public class SeekBar extends JSlider // is a JSlider
{
	private Clip clip; // has a Clip
	private Timer timer; // has a Timer

	/**
	 * 
	 * Purpose: set the size of seekBar
	 */
	public SeekBar()
	{
		this.setOrientation(SwingConstants.HORIZONTAL);
		this.setValue(0);
		this.setPreferredSize(new Dimension(250, 20));
		this.setMaximumSize(new Dimension(250, 20));

	}

	

	/**
	 * 
	 * Purpose: setter of clip
	 * @param clip
	 */
	public void setClip(Clip clip)
	{
		this.clip = clip;

		if (clip != null)
		{
			this.setMaximum((int) clip.getMicrosecondLength());
			startSync();
		}
	}

	/**
	 * 
	 * Purpose: keep updating the GUI
	 */
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

	/**
	 * 
	 * Purpose:stop updating the GUI
	 */
	public void stopSync()
	{
		if (timer != null)
		{
			timer.cancel();
			timer = null;
		}
	}

	/**
	 * 
	 * Purpose: enable user to drag seek bar, to seek through to song
	 */
	public void enableUserSeek()
	{
		this.addChangeListener(e -> {
			if (clip != null && !getValueIsAdjusting())
			{
				clip.setMicrosecondPosition(getValue());
			}
		});
	}
}