package model.fileloaders;

import model.characters.Character;
import model.characters.enemies.LeaderBandit;
import model.characters.enemies.TrainedBandit;
import model.characters.enemies.WeakBandit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EnemiesLoaderTest {

    @Test
    public void loadTest() {
        List<Character> expectedEnemies = getExpectedItems();
        List<Character> actualEnemies = EnemiesLoader.load();

        assertEquals(expectedEnemies.size(), actualEnemies.size());
        for(Character expectedEnemy : expectedEnemies)
            assertTrue(actualEnemies.contains(expectedEnemy));
    }

    private List<Character> getExpectedItems() {
        List<Character> enemies = new ArrayList<>();

        enemies.add(new LeaderBandit());
        enemies.add(new TrainedBandit());
        enemies.add(new WeakBandit());

        return enemies;
    }
}
