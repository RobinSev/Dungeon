package model.fileloaders;

import model.items.Item;
import model.items.LifePotions.*;
import model.items.strengthpotions.LightStrengthPotion;
import model.items.strengthpotions.MediumStrengthPotion;
import model.items.strengthpotions.StrongStrengthPotion;
import model.items.armors.IronArmor;
import model.items.armors.LeatherArmor;
import model.items.armors.SteelArmor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemsLoaderTest {

    @Test
    public void loadTest() {
        List<Item> expectedItems = getExpectedItems();
        List<Item> actualItems = ItemsLoader.load();

        assertEquals(expectedItems.size(), actualItems.size());

        for(Item expectedItem : expectedItems)
            assertTrue(actualItems.contains(expectedItem));
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
