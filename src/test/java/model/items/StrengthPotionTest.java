package model.items;

import model.characters.Character;
import model.characters.playables.PersonalizedPlayer;
import model.exceptions.NotAUsableItemException;
import model.items.strengthpotions.LightStrengthPotion;
import model.items.strengthpotions.PersonalizedStrengthPotion;
import model.items.strengthpotions.StrengthPotion;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StrengthPotionTest {

    Item strengthPotion = new PersonalizedStrengthPotion("test potion", 10);

    @Test
    public void testConstructor() {
        String expectedDescription = "Gives you 10 strength points.";
        assertEquals(expectedDescription, strengthPotion.getDescription());
        assertEquals("test potion", strengthPotion.getName());

        String expectedMessage = "the strength benefits must be positive";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new PersonalizedStrengthPotion("", -1));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testUseOn() throws NotAUsableItemException {
        Character user = new PersonalizedPlayer("Bernard", 20, 10);
        strengthPotion.useOn(user);
        assertEquals(20, user.getStrength());
    }

    @Test
    public void testEquals() {
        StrengthPotion potion1 = new LightStrengthPotion();
        StrengthPotion potion2 = new LightStrengthPotion();
        assertEquals(potion1, potion2);

        potion2 = new PersonalizedStrengthPotion("Light Strength Potion", 10);
        assertNotEquals(potion1, potion2);
    }
}
