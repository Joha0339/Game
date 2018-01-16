package castle.game.model.unit;

public abstract class Unit implements Comparable<Unit>, Fighter {
    protected String name;
    protected String type;
    protected CombatStats stats;
    protected String description;
    protected boolean isReady = true;
    private int team = 0;
    //private Image picture;

    public Unit(){
        name = "Missing name";
        type = "Missing type";
        stats = null;
        description = "Missing description";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CombatStats getStats() {
        return stats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public boolean isReady() {
        return isReady;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int compareTo(Unit compareUnit){
        int compareInit = compareUnit.getStats().getInitiative();
        return this.getStats().getInitiative() - compareInit;
    }
}
