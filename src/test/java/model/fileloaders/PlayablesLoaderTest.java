package model.fileloaders;

import model.characters.Character;

import model.characters.playables.StrongPlayer;
import model.characters.playables.TankPlayer;
import model.characters.playables.UnkillablePlayer;

import model.characters.playables.UnpreparedWonderer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayablesLoaderTest {

    @Test
    public void loadTest() {
        List<Character> expectedPlayables = getExpectedItems();
        List<Character> actualPlayables = PlayablesLoader.load();

        assertEquals(expectedPlayables.size(), actualPlayables.size());
        for(Character expectedPlayable : expectedPlayables)
            assertTrue(actualPlayables.contains(expectedPlayable));
    }

    private List<Character> getExpectedItems() {
        List<Character> playables = new ArrayList<>();

        playables.add(new TankPlayer("For selection"));
        playables.add(new StrongPlayer("For selection"));
        playables.add(new UnkillablePlayer("For selection"));
        playables.add(new UnpreparedWonderer("For selection"));

        return playables;
    }
}
