package castle.game.model.unit;

import java.util.ArrayList;
import java.util.Collections;

public class Battle {

    public Battle(ArrayList<Unit> attacker, ArrayList<Unit> defender){

        //Sorts The teams so
        Collections.sort(attacker);
        Collections.sort(defender);
    }
}
