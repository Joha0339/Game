package castle.game.model.audio;

/**
 * AudioController
 *
 * Singleton class used to play sound globally.
 *
 * @Author oi09olk
 * @Author c14jhn
 * @version 1.0
 * @since 2018-01-02
 */
public class AudioController {

    public final static int startVolume = 3;
    public final static int maxVolume = 10;
    public final static int minVolume = 0;

    public final static int MUSIC = 0;
    public final static int SOUND_EFFECT_CANNON = 1;

    //private static int volume;
    private static boolean muted = true;
    private static AudioController instance = null;
    private static Music music = new Music("/MainMenu.wav");
    private static SoundEffect soundEffectCannon = new SoundEffect("/Cannon.wav");

    /**
     * Singleton constructor
     * */
    private AudioController(){
        setVolume(startVolume);
    }

    /**
     * @return if no audioController instances exist creates one and return that
     * else returns the existing one.
     * */
    public static AudioController getInstance() {
        if(instance == null){

            synchronized (AudioController.class)
            {
                if (instance==null)
                {
                    instance = new AudioController();
                    setVolume(startVolume);
                }
            }
        }
        return instance;
    }

    /**
     * Method that plays a specified sound.
     *
     * @param type sound to play
     * */
    public static void playSound(int type){
        if(!muted){
            switch (type)
            {
                case SOUND_EFFECT_CANNON:
                    soundEffectCannon.run();
                    break;
                case MUSIC:
                    music.run();
                    break;
                default:
            }
        }
    }

    /**
     * Method that sets the volume for all the soundEffects/music.
     *
     * @param volume volume to set it to.
     * */
    public static void setVolume(int volume)
    {
        //soundEffectCannon.setVolume(volume);
        music.setVolume(volume);
    }

    /**
     * Sets the volume for a specified sound.
     *
     * @param volume what volume to set it to.
     * @param type what type to set the volume of.
     * */
    public static void setVolumeFor(int volume, int type)
    {
        switch (type)
        {
            case SOUND_EFFECT_CANNON:
                soundEffectCannon.setVolume(volume);
                break;
            case MUSIC:
                music.setVolume(volume);
                break;
            default:
        }
    }

    /**
     * Method that toggles the sound. On/off.
     * */
    public static void toggleMute(){
        muted = !muted;

        if(muted){
            //Stopping music.
            music.stop();
        } else {
            //Starting music.
            music.start();
        }
    }
}