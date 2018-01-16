package castle.game.model.audio;

/**
 * SoundEffect
 *
 * Class that represents soundEffects in the game, smaller sound clips.
 *
 * @Author oi09olk
 * @author c14jhn
 * @version 1.0
 * @since 2018-01-02
 */
public class SoundEffect extends SoundObject implements Runnable{

    /**
     * Constructor.
     * */
    SoundEffect(String path)
    {
        super(path);
    }

    /**
     * Runs the soundEffect clip on a seperate thread.
     * */
    @Override
    public synchronized void run()
    {
        super.getClip().setMicrosecondPosition(0);
        super.getClip().loop(0);
    }
}
