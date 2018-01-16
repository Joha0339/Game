package castle.game.model.unit;

public class Knight extends Unit{

    public Knight(){
        name = UnitNameGenerator.getInstance().generateName();
        type = "Knight";
        //TODO redo this later.
        stats = new CombatStats(100, 5, 8, 12,
                1, 1);
        description = "Awesome killing machine";
    }

    public Knight(String name){
        this.name = name;
        type = "Knight";
        //TODO redo this later.
        stats = new CombatStats(100, 5, 8, 12,
                1, 1);
        description = "Awesome killing machine";
    }

    @Override
    public int compareTo(Unit compareUnit){
        return super.compareTo(compareUnit);
    }
}
