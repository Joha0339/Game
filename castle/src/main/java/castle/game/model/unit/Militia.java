package castle.game.model.unit;

public class Militia extends Unit{

    public Militia(){
        name = UnitNameGenerator.getInstance().generateName();
        type = "Militia";
        //TODO redo this later.
        stats = new CombatStats(25, 0, 2, 4,
                1, 1);
        description = "Normal shitter dude.";
    }

    public Militia(String name){
        this.name = name;
        type = "Militia";
        //TODO redo this later.
        stats = new CombatStats(25, 0, 2, 4,
                1, 1);
        description = "Normal shitter dude.";
    }

    @Override
    public int compareTo(Unit compareUnit){
        return super.compareTo(compareUnit);
    }
}
