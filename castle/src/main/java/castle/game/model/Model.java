package castle.game.model;

import castle.game.model.unit.Militia;
import castle.game.model.unit.Unit;

public class Model {

    Unit testUnit = new Militia("Bob");

    public Unit getTestUnit() {
        return testUnit;
    }
}
