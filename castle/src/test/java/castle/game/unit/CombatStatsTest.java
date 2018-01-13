package castle.game.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombatStatsTest {

    CombatStats stats;

    @Before
    public void setUp(){
        stats = new CombatStats(25, 5, 2,
                4, 40, 20);
    }

    @After
    public void tearDown(){
        stats = null;
    }

    @Test
    public void shouldCreateCombatStats(){
        assertNotNull(stats);
    }

    @Test
    public void shouldSetHealthCorrectly(){
        assertEquals(25, stats.getMaxHealth());
    }

    @Test
    public void shouldStartWithMaxHealth(){
        assertEquals(stats.getMaxHealth(), stats.getCurrentHealth());
    }

    @Test
    public void shouldSetArmorCorrectly(){
        assertEquals(5, stats.getArmor());
    }

    @Test
    public void shouldSetMinDamageCorrectly(){
        assertEquals(2, stats.getMinDamage());
    }

    @Test
    public void shouldSetMaxDamageCorrectly(){
        assertEquals(4, stats.getMaxDamage());
    }

    @Test
    public void shouldSetOffenseCorrectly(){
        assertEquals(40, stats.getOffense());
    }

    @Test
    public void shouldSetDefenseCorrectly(){
        assertEquals(20, stats.getDefense());
    }

    @Test
    public void shouldSetHealthToOne(){
        stats = new CombatStats(-25, 5, 2,
                4, 40, 20);
        assertEquals(1, stats.getMaxHealth());
    }

    @Test
    public void shouldKillUnitIfsetToZero(){
        stats.setCurrentHealth(0);
        assertTrue(stats.isAlive());
    }

}