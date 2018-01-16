package castle.game.model.unit;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class UnitNameGenerator {

    private static UnitNameGenerator instance = null;
    private static ArrayList<String> names;

    /**
     * Singleton constructor
     * */
    private UnitNameGenerator(){
        names = new ArrayList<String>();
        FileReader input = null;
        try {
            input = new FileReader("UnitNames.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufRead = new BufferedReader(input);
        String myLine = null;

        try {
            while ((myLine = bufRead.readLine()) != null) {
                names.add(myLine);
            }
        } catch (IOException e){
            e.printStackTrace();
        }


    }

    /**
     * @return if no audioController instances exist creates one and return that
     * else returns the existing one.
     * */
    public static UnitNameGenerator getInstance() {
        if(instance == null){

            instance = new UnitNameGenerator();
        }
        return instance;
    }

    public static String generateName(){
        String name = null;
        Random random = new Random();
        int index = random.nextInt(names.size());
        return names.get(index);
    }
}
