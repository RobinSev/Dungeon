package model.dungeon.rooms.roomgenerators.randomized;

import model.characters.Character;
import model.dungeon.rooms.Room;
import model.dungeon.rooms.roomgenerators.RoomConstituentGenerator;
import model.fileloaders.AllPossibles;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class RandomEnemyGenerator implements RoomConstituentGenerator {
    private List<Character> possibleEnemies = AllPossibles.possibleEnemies;
    private int enemyAppearingThreshold = 70;

    /**
     * Pick a random number between 0 and 99. If it is below the threshold, pick a randon enemy from the list of possible
     * enemies and add it to the room. Otherwise, do nothing.
     * @param roomToFill the room in which to add the enemy.
     */
    @Override
    public void generateConstituent(Room roomToFill) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if(RandomInteger.randomIntIsBelow(enemyAppearingThreshold)) {
            roomToFill.setEnemy(getNewRandomEnemy());
        }
    }

    /**
     * Return a new instance of the object gotten randomly from all possibles (to avoid a copy by reference).
     * @return a new instance of the object gotten randomly from all possibles.
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private Character getNewRandomEnemy() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return possibleEnemies
                .get(RandomInteger.getRandomInt(possibleEnemies.size()))
                .getClass()
                .getConstructor()
                .newInstance();
    }
}
