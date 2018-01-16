package castle.game.model.unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Battle {

    private ArrayList<Unit> attackers;
    private ArrayList<Unit> defenders;

    /**
     * Constructor for the battle. Takes a list of attackers and a list of
     * defenders.
     * @param attackers The list of attackers. Team 1.
     * @param defenders The list of defenders. Team 2.
     */
    public Battle(ArrayList<Unit> attackers, ArrayList<Unit> defenders){

        this.attackers = attackers;
        this.defenders = defenders;
    }

    /**
     * Makes the two armies fight untill only one of them has any living units.
     * @return The winner. 0 = none, 1 = attackers, 2 = defenders.
     */
    public synchronized int doBattle(){
        while(anyoneAlive(attackers) && anyoneAlive(defenders)){
            combatStep();
        }
        if (anyoneAlive(attackers)){
            return 1;
        }
        if (anyoneAlive(defenders)){
            return 2;
        }
        return 0;
    }

    /**
     * Makes two units fight each other. They will deal their damage with all
     * modifiers to each other. Will set both to not ready.
     * @param attacker The attacker.
     * @param defender The defender.
     */
    public synchronized void fight(Unit attacker, Unit defender){

        //Sets ut damage for attacker.
        int atkMult = attacker.getStats().getOffense();
        int atkMin = attacker.getStats().getMinDamage();
        int atkMax = attacker.getStats().getMaxDamage();
        int atkArmor = defender.getStats().getArmor();
        int atkDmg = ThreadLocalRandom.current().nextInt(atkMin, atkMax + 1);

        //Sets up damage for defender.
        int defMult = defender.getStats().getDefense();
        int defMin = defender.getStats().getMinDamage();
        int defMax = defender.getStats().getMaxDamage();
        int defArmor = defender.getStats().getArmor();
        int defDmg = ThreadLocalRandom.current().nextInt(defMin, defMax + 1);

        atkDmg = atkDmg * atkMult;
        atkDmg = armorCalc(atkDmg, defArmor);
        defDmg = defDmg * defMult;
        defDmg = armorCalc(defDmg, atkArmor);

        if(attacker.isReady()){
            defender.getStats().dealDamage(atkDmg);
            String out = attacker.getName() + " attacked " + defender.getName()
                    + " for " + atkDmg + " damage. " + defender.getName() +
                    " has " + defender.getStats().getCurrentHealth() +
                    " health left. ";
            if (!defender.getStats().isAlive()){
                out = out + defender.getName() + " is dead.";
            }
            System.out.println(out);
        }

        if(defender.isReady()){
            attacker.getStats().dealDamage(defDmg);
            String out = defender.getName() + " attacked " + attacker.getName()
                    + " for " + defDmg + " damage. " + attacker.getName() +
                    " has " + attacker.getStats().getCurrentHealth() +
                    " health left. ";
            if (!attacker.getStats().isAlive()){
                out = out + attacker.getName() + " is dead.";
            }
            System.out.println(out);
        }

        attacker.setReady(false);
        defender.setReady(false);
    }

    /**
     * This makes all units fight one other unit.
     */
    public synchronized void combatStep(){

        System.out.println("---NEW ROUND---\n");

        Random random = new Random();

        ArrayList<Unit> initiativeList = new ArrayList<Unit>();

        for(Unit unit : attackers){
            if (unit.getStats().isAlive()){
                unit.setReady(true);
                unit.setTeam(1);
                initiativeList.add(unit);
            }
        }

        for(Unit unit : defenders){
            if (unit.getStats().isAlive()){
                unit.setReady(true);
                unit.setTeam(2);
                initiativeList.add(unit);
            }
        }

        Collections.sort(initiativeList);

        for(Unit unit : initiativeList){

            if (anyoneAlive(attackers) && anyoneAlive(defenders)){
                if(unit.isReady()){
                    if(unit.getTeam() == 1){
                        int index = random.nextInt(defenders.size());
                        fight(unit, defenders.get(index));
                    }
                    if(unit.getTeam() == 2){
                        int index = random.nextInt(attackers.size());
                        fight(unit, attackers.get(index));
                    }
                }
            }
        }

        initiativeList = null;
    }

    /**
     * Calculates armor from damage. Damage = damage - armor (min 1).
     * @param damage The damage.
     * @param armor The armor.
     * @return The damage after reduction.
     */
    private int armorCalc(int damage, int armor){

        int outputDamage = damage - armor;
        if(outputDamage < 1){
            outputDamage = 1;
        }

        return outputDamage;
    }

    /**
     * Checks if anyone is alive in a list.
     * @param list The attackers or defenders.
     * @return True if anyone is alive else false.
     */
    private boolean anyoneAlive(ArrayList<Unit> list){
        for(Unit unit : list){
            if (unit.getStats().isAlive()){
                return true;
            }
        }
        return false;
    }
}
