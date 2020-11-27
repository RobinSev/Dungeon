package model.fileloaders;

import model.items.Item;
import model.items.LifePotions.LightLifePotion;
import model.items.LifePotions.MediumLifePotion;
import model.items.LifePotions.StrongLifePotion;
import model.items.armors.IronArmor;
import model.items.armors.LeatherArmor;
import model.items.armors.SteelArmor;
import model.items.questobjects.RareMedallion;
import model.items.strengthpotions.LightStrengthPotion;
import model.items.strengthpotions.MediumStrengthPotion;
import model.items.strengthpotions.StrongStrengthPotion;
import model.victoryconditions.VictoryCondition;
import model.victoryconditions.victoriesbyitems.VictoryByRareMedallion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AllPossiblesTest {

    @Test
    public void attributeTest() {
        AllPossibles.resetAllPossibles();

        List<Item> expectedItems = getExpectedItems();

        assertEquals(expectedItems.size(), AllPossibles.possibleItems.size());
        for(Item item : expectedItems) {
            assertTrue(AllPossibles.possibleItems.contains(item));
        }

        expectedItems.add(new RareMedallion());
        VictoryCondition victory = new VictoryByRareMedallion();
            assertEquals(expectedItems.size(), AllPossibles.possibleItems.size());
            for(Item item : expectedItems) {
                assertTrue(AllPossibles.possibleItems.contains(item));
            }
    }

    private List<Item> getExpectedItems() {
        List<Item> items = new ArrayList<>();

        items.add(new LightLifePotion());
        items.add(new MediumLifePotion());
        items.add(new StrongLifePotion());
        items.add(new LightStrengthPotion());
        items.add(new MediumStrengthPotion());
        items.add(new StrongStrengthPotion());
        items.add(new IronArmor());
        items.add(new SteelArmor());
        items.add(new LeatherArmor());

        return items;
    }
}
