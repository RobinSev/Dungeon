package model.items;

import model.characters.Character;
import model.characters.playables.PersonalizedPlayer;
import model.exceptions.NotAUsableItemException;
import model.items.LifePotions.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LifePotionTest {
    Item lifePotion = new PersonalizedLifePotion("test potion", 10);

    @Test
    public void testConstructor() {
        String expectedDescription = "Gives you 10 life points.";
        assertEquals(expectedDescription, lifePotion.getDescription());
        assertEquals("test potion", lifePotion.getName());

        String expectedMessage = "the life benefits must be positive";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new PersonalizedLifePotion("", -1));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testUseOn() throws NotAUsableItemException {
        Character user = new PersonalizedPlayer("Bernard", 20, 10);
        user.updateLife(-15);

        lifePotion.useOn(user);
        assertEquals(15, user.getLife());
    }

    @Test
    public void testEquals() {
        LifePotion lifePotion1 = new LightLifePotion();
        LifePotion lifePotion2 = new LightLifePotion();
        assertEquals(lifePotion1, lifePotion2);

        lifePotion2 = new PersonalizedLifePotion("Light Life Potion", 10);
        assertNotEquals(lifePotion1, lifePotion2);
    }
}
