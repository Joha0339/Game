package castle.game.model.unit;

public abstract class Unit implements Fighter{
    protected String name;
    protected String type;
    protected CombatStats stats;
    protected String description;
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
}
