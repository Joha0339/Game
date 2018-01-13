package castle.game.model.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest{

    Unit myUnit;

    public void setUp() {
        myUnit = new Militia("Bob");
    }

    public void tearDown() {
        myUnit = null;
    }

    public void shouldGetName() {
        assertEquals("Bob", myUnit.getName());
    }

    public void shouldSetName() {
        myUnit.setName("Carl");
        assertEquals("Carl", myUnit.getName());
    }

    public void shouldGetType() {
        assertEquals("Militia", myUnit.getType());
    }

    public void shouldSetType() {
        myUnit.setType("God");
        assertEquals("God", myUnit.getType());
    }

    public void shouldGetStats() {
        assertNotNull(myUnit.getStats());
    }

    public void shouldGetDescription() {
        assertEquals("Normal shitter dude.", myUnit.getType());
    }

    public void shouldSetDescription() {
        myUnit.setDescription("Pretty cool dude.");
        assertEquals("Pretty cool dude.", myUnit.getType());
    }
}