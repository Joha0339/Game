package castle.game.model.audio;

import javax.sound.sampled.*;

/**
 * Music
 *
 * Class that plays background music, should be able to stop the music
 * and resume it.
 *
 * @Author oi09olk
 * @Author c14jhn
 * @version 1.0
 * @since 2018-01-02
 */
public class Music extends SoundObject implements Runnable{

    /**
     * Constructor.
     * */
    Music(String path)
    {
        super(path);
    }

    /**
     * Method that starts the music clip and loops it continiously.
     * */
    void start(){
        super.getClip().loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Method that stops the music clip.
     * */
    void stop(){
        super.getClip().stop();
    }

    /**
     * Starts running the clip on a seperate thread.
     * */
    @Override
    public void run()
    {
        start();
    }
}