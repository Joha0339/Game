package castle.game.model.unit;

/**
 * All the stats a unit needs.
 */
public class CombatStats {
    //Basic stats
    private int maxHealth = 0;
    private int currentHealth = 0;
    private int armor = 0;
    private int minDamage = 0;
    private int maxDamage = -1;

    //Defense for defending and offense for attacking.
    //Does nothing atm.
    private int offense = 0;
    private int defense = 0;

    //Decides who attacks first. Higher is better.
    private int initiative = 0;

    //To see if the unit is dead.
    private boolean isAlive;

    /**
     * The constructor for the combat stats of a unit.
     * @param health The health of the unit. Needs to be 1 or higher. Will be
     *               set to 1 in other cases.
     * @param armor The armor of the unit.
     * @param minDamage The minimmum damage of the unit. Needs to be bigger
     *                  than or equal to 0.
     * @param maxDamage The maxmimum damage of the unit. Needs to be bigger
     *                  than or equal to minDamage.
     * @param offense The offense of the unit. Needs to be bigger than or equal
     *                to 0.
     * @param defense The defense of the unit. Needs to be bigger than or equal
     *                to 0.
     */
    public CombatStats(int health, int armor, int minDamage, int maxDamage,
                       int offense, int defense){
        setMaxHealth(health);
        setCurrentHealth(health);
        setArmor(armor);
        setMinDamage(minDamage);
        setMaxDamage(maxDamage);

        setOffense(offense);
        setDefense(defense);

        this.isAlive = true;
    }

    /**
     * Gets the maximum health of the unit.
     * @return The maximum health of the unit.
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Sets the maximum health of the unit. Can not be lower then 1.
     * @param maxHealth The new value for the maximum health of the unit.
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        if (maxHealth <= 1){
            this.maxHealth = 1;
        }
        if(currentHealth > maxHealth){
            setCurrentHealth(this.maxHealth);
        }
    }

    /**
     * Gets the current health of the unit.
     * @return The current health of the unit.
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * Sets the current health of the unit. Will not go over the units maximum
     * health.
     * Will also kill the unit if the health goes under 0.
     * @param currentHealth The new value of the units current health.
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        if(currentHealth <= 0){
            kill();
        }
    }

    /**
     * Gets the armor of the unit.
     * @return The armor of the unit.
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Sets the armor of the unit. Negative armor will increase damage taken.
     * @param armor The new value for the armor of the unit.
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     * Gets the units minimum damage.
     * @return The units minimum damage.
     */
    public int getMinDamage() {
        return minDamage;
    }

    /**
     * Sets the units minimum damage. Needs to be lower then maximum damage and
     * needs to be equal to or higher then 0.
     * @param minDamage The new value for the minimum damage of the unit.
     */
    public void setMinDamage(int minDamage) {
        if (minDamage < 0){
            this.minDamage = 0;
            System.out.println("goes here?");
        } else if (maxDamage != -1 && minDamage > maxDamage){
            this.minDamage = maxDamage;
        } else {
            this.minDamage = minDamage;
        }
    }

    /**
     * Gets the units maximum damage.
     * @return The units maximum damage.
     */
    public int getMaxDamage() {
        return maxDamage;
    }

    /**
     * Sets the units maximum damage. Needs to be higher then minimum damage.
     * @param maxDamage The new value for the maximum damage of the unit.
     */
    public void setMaxDamage(int maxDamage) {
        if (maxDamage < minDamage){
            this.maxDamage = minDamage;
        } else {
            this.maxDamage = maxDamage;
        }
    }

    /**
     * Gets the offense points for the unit.
     * @return The offense points for the unit.
     */
    public int getOffense() {
        return offense;
    }

    /**
     * Sets the offense points for the unit. Needs to be a positive value.
     * @param offense The new value for the offense points of the unit.
     */
    public void setOffense(int offense) {
        if (offense < 0){
            this.offense = 0;
        } else {
            this.offense = offense;
        }
    }

    /**
     * Gets the defense points for the unit.
     * @return The defense points for the unit.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Sets the defense points for the unit. Needs to be a positive value.
     * @param defense The new value for the defense points of the unit.
     */
    public void setDefense(int defense) {
        if (defense < 0){
            this.defense = 0;
        } else {
            this.defense = defense;
        }
    }

    /**
     * Gets the units alive status.
     * @return True if alive.
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Sets the units alive status.
     * @param alive True is alive. False is dead.
     */
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Gets the initiative of the unit.
     * @return The initiative of the unti.
     */
    public int getInitiative() {
        return initiative;
    }

    /**
     * Sets the initiative of the unit.
     * @param initiative Sets the new initiative of the unit.
     */
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    /**
     * Kills the unit. Sets Alive to false.
     */
    public void kill(){
        isAlive = false;
    }

    @Override
    public String toString(){
        String finalString;
        String healthString;
        String armorString;
        String damageString;
        String offenseString;
        String defenseString;
        String initiativeString;
        healthString = "Health: " + currentHealth + "/" + maxHealth + ".\n";
        armorString = "Armor: " + armor + ".\n";
        damageString = "Damage: " + minDamage + "-" + maxDamage + ".\n";
        offenseString = "Offensive power: " + offense + ".\n";
        defenseString = "Defensive power: " + defense + ".\n";
        initiativeString = "Initiative: " + initiative +".\n";
        finalString = healthString + armorString + damageString + offenseString
                + defenseString +initiativeString;

        return finalString;
    }
}