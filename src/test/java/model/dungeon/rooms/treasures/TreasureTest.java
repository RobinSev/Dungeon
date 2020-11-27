package model.dungeon.rooms.treasures;
import model.characters.playables.PersonalizedPlayer;


import model.items.armors.Armor;
import model.items.armors.IronArmor;
import model.characters.Character;
import model.items.LifePotions.LifePotion;
import model.items.LifePotions.LightLifePotion;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;


public class TreasureTest {

    @Test
    public void testAddItem() {
        Armor armor = new IronArmor();
        LifePotion potion = new LightLifePotion();

        Treasure treasure = new PersonalizedTreasure(2);
        assertTrue(treasure.addItem(armor));
        assertTrue(treasure.addItem(potion));
        assertFalse(treasure.addItem(new LightLifePotion()));
    }

    @Test
    public void testTransferLoot() {
        Character looter = new PersonalizedPlayer("", 10, 10);
        Armor armor = new IronArmor();
        LifePotion potion = new LightLifePotion();

        Treasure treasure = new PersonalizedTreasure(2);
        treasure.addItem(armor);
        treasure.addItem(potion);

        assertTrue(looter.getBag().isEmpty());
        treasure.transferLoot(looter);
        assertEquals(2, looter.getBag().getItems().size());
        assertTrue(looter.getBag().contains(armor));
        assertTrue(looter.getBag().contains(potion));
    }
}
