package model.fileloaders;

import model.dungeon.rooms.traps.CommonTrap;
import model.dungeon.rooms.traps.DangerousTrap;
import model.dungeon.rooms.traps.Trap;
import model.dungeon.rooms.traps.VeryDangerousTrap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrapsLoaderTest {

    @Test
    public void loadTest() {
        List<Trap> expectedTraps = getExpectedItems();
        List<Trap> actualTraps = TrapsLoader.load();

        assertEquals(expectedTraps.size(), actualTraps.size());
        for(Trap expectedTrap : expectedTraps)
            assertTrue(actualTraps.contains(expectedTrap));
    }

    private List<Trap> getExpectedItems() {
        List<Trap> traps = new ArrayList<>();

        traps.add(new CommonTrap());
        traps.add(new DangerousTrap());
        traps.add(new VeryDangerousTrap());

        return traps;
    }
}
