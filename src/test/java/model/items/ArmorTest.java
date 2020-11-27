package model.items;

import model.characters.Character;
import model.characters.playables.PersonalizedPlayer;
import model.items.armors.Armor;
import model.items.armors.IronArmor;
import model.items.armors.PersonalizedArmor;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArmorTest {

    Armor armor = new PersonalizedArmor("test", 10);

    @Test
    public void testConstructor() {
        String expectedDescription = "Increases your maximum life by 10.";
        assertEquals(expectedDescription, armor.getDescription());
        assertEquals("test", armor.getName());

        String expectedMessage = "the protection value must be positive";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new PersonalizedArmor("", -1));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testUseOn() {
        Character user = new PersonalizedPlayer("Bernard", 20, 10);
        user.updateLife(-10);

        armor.useOn(user);
        assertEquals(30, user.getMaximumLife());
        assertEquals(20, user.getLife());
    }

    @Test
    public void testEquals() {
        Armor armor1 = new IronArmor();
        Armor armor2 = new IronArmor();
        assertEquals(armor1, armor2);

        armor2 = new PersonalizedArmor("Iron Armor", 10);
        System.out.println(armor1.getClass().toString());
        System.out.println(armor2.getClass().toString());
        assertNotEquals(armor1, armor2);
    }
}
