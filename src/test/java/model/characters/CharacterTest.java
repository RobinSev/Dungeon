package model.characters;

import model.characters.playables.PersonalizedPlayer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

public class CharacterTest {
    Character testCharacter;

    @BeforeEach
    public void initTestCharacter() {
        testCharacter = new PersonalizedPlayer("Bernard", 80, 60);
    }

    @Test
    public void testConstructor() {
        assertEquals(80, testCharacter.getMaximumLife());
        assertEquals(60, testCharacter.getStrength());
        assertEquals(80, testCharacter.getLife());
        assertTrue(testCharacter.getBag().getItems().isEmpty());
        assertEquals("Bernard", testCharacter.getName());
    }

    @Test
    public void testUpdateLife() {
        testCharacter.updateLife(-40);
        assertEquals(40, testCharacter.getLife());

        testCharacter.updateLife(100);
        assertEquals(80, testCharacter.getLife());
    }

    @Test
    public void testUpdateMaximumLife() {
        testCharacter.updateMaxLife(10);
        assertEquals(90, testCharacter.getMaximumLife());

        testCharacter.updateMaxLife(-20);
        assertEquals(70, testCharacter.getMaximumLife());
    }

    @Test
    public void testUpdateStrength() {
        testCharacter.updateStrength(-40);
        assertEquals(20, testCharacter.getStrength());

        testCharacter.updateStrength(100);
        assertEquals(120, testCharacter.getStrength());
    }

    @Test
    public void testIsDead() {
        testCharacter.updateLife(- 100);
        assertTrue(testCharacter.isDead());

        testCharacter.updateLife(20);
        assertTrue(testCharacter.isDead());

        testCharacter.updateLife(1);
        assertFalse(testCharacter.isDead());
    }

    @Test
    public void testAttack() {
        Character target = new PersonalizedPlayer("Loïc", 80, 60);

        testCharacter.attack(target);
        assertEquals(20, target.getLife());
        assertEquals(80, target.getMaximumLife());

        testCharacter.attack(target);
        assertEquals(- 40, target.getLife());
    }
}
