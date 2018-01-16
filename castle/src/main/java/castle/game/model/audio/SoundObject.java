package castle.game.model.audio;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * SoundObject
 *
 * Abstract class that all soundPlaying classes should inherit from.
 *
 * @Author oi09olk
 * @version 1.0
 * @since 2018-01-02
 */
abstract class SoundObject
{
    private Clip clip;
    private FloatControl floatControl;
    private float maxVolume;
    private FloatControl.Type volumeControlType;

    /**
     * Constructor for a SoundObject. Creates and sets up a clip that can
     * later be played by another class.
     *
     * @param name The name of the sound file.
     */
    SoundObject(String name)
    {
        InputStream soundFile = getClass().getResourceAsStream(name);

        InputStream bufferedInputStream = new BufferedInputStream(soundFile);

        try {
            AudioInputStream audioIn =
                    AudioSystem.getAudioInputStream(bufferedInputStream);
            AudioFormat format = audioIn.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioIn);

            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN))
            {
                floatControl = (FloatControl)
                        clip.getControl(FloatControl.Type.MASTER_GAIN);
                volumeControlType = FloatControl.Type.MASTER_GAIN;
            }else if (clip.isControlSupported(FloatControl.Type.VOLUME))
            {
                floatControl = (FloatControl)
                        clip.getControl(FloatControl.Type.VOLUME);
                volumeControlType = FloatControl.Type.VOLUME;
            }

            maxVolume = floatControl.getMaximum();

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the volume to a float value.
     *
     * @param volume The new volume.
     */
    void setVolume(float volume)
    {
        if (volume>10)
        {
            volume = 10;
        }else if(volume<0) {
            volume = 0;
        }

        if (volumeControlType == FloatControl.Type.VOLUME)
        {
            float volumeValue = maxVolume/10*volume;
            floatControl.setValue(volumeValue);
        }else if (volumeControlType == FloatControl.Type.MASTER_GAIN)
        {
            double gain = .6D;
            double gainRelativeToVolume = (volume/10)*gain;
            float dB = (float)
                    (Math.log(gainRelativeToVolume) / Math.log(10.0) * 20.0);

            floatControl.setValue(dB);
        }
    }

    /**
     * Gets the clip.
     *
     * @return The clip.
     */
    Clip getClip()
    {
        return clip;
    }
}
