package model.fileloaders;


import model.dungeon.rooms.treasures.CommonTreasure;
import model.dungeon.rooms.treasures.RareTreasure;
import model.dungeon.rooms.treasures.Treasure;
import model.dungeon.rooms.treasures.VeryRareTreasure;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TreasuresLoaderTest {

    @Test
    public void loadTest() {
        List<Treasure> expectedTreasures = getExpectedItems();
        List<Treasure> actualTreasures = TreasuresLoader.load();

        assertEquals(expectedTreasures.size(), actualTreasures.size());
        for(Treasure expectedTreasure : expectedTreasures)
            assertTrue(actualTreasures.contains(expectedTreasure));
    }

    private List<Treasure> getExpectedItems() {
        List<Treasure> treasures = new ArrayList<>();

        treasures.add(new CommonTreasure());
        treasures.add(new RareTreasure());
        treasures.add(new VeryRareTreasure());

        return treasures;
    }
}
