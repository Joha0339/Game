package castle.game.model.unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Battle {

    private ArrayList<Unit> attackers;
    private ArrayList<Unit> defenders;

    public Battle(ArrayList<Unit> attackers, ArrayList<Unit> defenders){

        this.attackers = attackers;
        this.defenders = defenders;
    }

    public int doBattle(){
        while(attackers.size() > 0 && defenders.size() > 0){
            System.out.println(attackers.size() + " - " + defenders.size());
            combatStep();
        }
        if (attackers.size() > 0){
            return 1;
        }
        if (defenders.size() > 0){
            return 2;
        }
        return 0;
    }

    public void fight(Unit attacker, Unit defender){

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

        if(!attacker.getStats().isAlive()){
            attackers.remove(attacker);
        }

        if(!defender.getStats().isAlive()){
            defenders.remove(defender);
        }

    }

    public void combatStep(){

        System.out.println("---NEW ROUND---\n");

        Random random = new Random();

        ArrayList<Unit> initiativeList = new ArrayList<Unit>();

        for(Unit unit : attackers){
            unit.setReady(true);
            unit.setTeam(1);
            initiativeList.add(unit);
        }

        for(Unit unit : defenders){
            unit.setReady(true);
            unit.setTeam(2);
            initiativeList.add(unit);
        }

        Collections.shuffle(initiativeList);

        for(Unit unit : initiativeList){
            if(attackers.size() > 0 && defenders.size() > 0){
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

    private int armorCalc(int damage, int armor){

        int outputDamage = damage - armor;
        if(outputDamage < 1){
            outputDamage = 1;
        }

        return outputDamage;
    }
}
