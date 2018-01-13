package castle.game.model.unit;

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
    public void shouldSetHealthToOneWhenSetToZero(){
        stats = new CombatStats(0, 5, 2,
                4, 40, 20);
        assertEquals(1, stats.getMaxHealth());
    }

    @Test
    public void shouldSetHealthToOneWhenSetToNegativeValue(){
        stats = new CombatStats(-25, 5, 2,
                4, 40, 20);
        assertEquals(1, stats.getMaxHealth());
    }

    @Test
    public void shouldKillUnitIfsetToZero(){
        stats.setCurrentHealth(0);
        assertFalse(stats.isAlive());
    }

    @Test
    public void shouldKillUnitIfsetToBelowZero(){
        stats.setCurrentHealth(-25);
        assertFalse(stats.isAlive());
    }

    @Test
    public void shouldKillUnitIfKillIsCalled(){
        stats.kill();
        assertFalse(stats.isAlive());
    }

    @Test
    public void shouldKillUnitIfAliveIsSetToFalse(){
        stats.setAlive(false);
        assertFalse(stats.isAlive());
    }

    @Test
    public void currentHealthShouldStillBeSameAsMaxWhenMaxIsLowered(){
        stats.setMaxHealth(5);
        assertEquals(stats.getMaxHealth(), stats.getCurrentHealth());
    }

    @Test
    public void minDamageShouldBeZeroWhenSetToNegative(){
        stats = new CombatStats(25, 5, -2,
                4, 40, 20);
        assertEquals(0, stats.getMinDamage());
    }

    @Test
    public void maxDamageShouldBeMinDamageWhenSetBelowMinDamage(){
        stats = new CombatStats(25, 5, 2,
                1, 40, 20);
        assertEquals(stats.getMinDamage(), stats.getMaxDamage());
    }

    @Test
    public void minDamageShouldBeMaxDamageWhenSetToAboveMaxDamage(){
        stats.setMinDamage(8);
        assertEquals(stats.getMaxDamage(), stats.getMinDamage());
    }

    @Test
    public void OffenseShouldBeZeroWhenSetToNegative(){
        stats = new CombatStats(25, 5, 2,
                4, -40, 20);
        assertEquals(0, stats.getOffense());
    }

    @Test
    public void DefenseShouldBeZeroWhenSetToNegative(){
        stats = new CombatStats(25, 5, 2,
                4, 40, -20);
        assertEquals(0, stats.getDefense());
    }

    @Test
    public void ShouldSetAliveProperly(){
        stats = new CombatStats(25, 5, 2,
                4, 40, 20);
        stats.kill();
        stats.setAlive(true);
        assertTrue(stats.isAlive());
    }


}