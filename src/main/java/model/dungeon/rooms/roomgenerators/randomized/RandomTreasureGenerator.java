package model.dungeon.rooms.roomgenerators.randomized;

import model.fileloaders.AllPossibles;
import model.items.Item;
import model.dungeon.rooms.Room;
import model.dungeon.rooms.roomgenerators.RoomConstituentGenerator;
import model.dungeon.rooms.treasures.Treasure;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class RandomTreasureGenerator implements RoomConstituentGenerator {

    private List<Item> possibleItems = AllPossibles.possibleItems;
    private List<Treasure> possibleTreasures = AllPossibles.possibleTreasures;
    private int treasureAppearingThreshold = 30;


    public Treasure generateTreasure() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Treasure treasure = selectRandomTreasure();
        fillWithRandomItems(treasure);
        return treasure;
    }

    /**
     * Pick a random number between 0 and 99. If it is below the threshold, pick a random treasure from the list of possible
     * treasures, fill it to its maximum capacity with random items, and add it to the room. Otherwise, do nothing.
     * @param roomToFill the room in which to add the treasure.
     */
    @Override
    public void generateConstituent(Room roomToFill) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(RandomInteger.randomIntIsBelow(treasureAppearingThreshold)) {
            Treasure treasure = selectRandomTreasure();
            fillWithRandomItems(treasure);
            roomToFill.addTreasure(treasure);
        }
    }

    private Treasure selectRandomTreasure() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return getNewRandomTreasure();
    }


    private void fillWithRandomItems(Treasure treasure) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int itemAdded = 0;
        while(hasFreeSpace(itemAdded, treasure)) {
            treasure.addItem(getNewRandomItem());
            itemAdded++;
        }
    }

    private boolean hasFreeSpace(int numberOfItem, Treasure treasure) {
        return numberOfItem < treasure.getCapacity();
    }

    /**
     * Return a new instance of the object gotten randomly from all possibles (to avoid a copy by reference).
     * @return a new instance of the object gotten randomly from all possibles.
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private Item getNewRandomItem() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return possibleItems
                .get(RandomInteger.getRandomInt(possibleItems.size()))
                .getClass()
                .getConstructor()
                .newInstance();
    }

    /**
     * Return a new instance of the object gotten randomly from all possibles (to avoid a copy by reference).
     * @return a new instance of the object gotten randomly from all possibles.
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private Treasure getNewRandomTreasure() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return possibleTreasures
                .get(RandomInteger.getRandomInt(possibleTreasures.size()))
                .getClass()
                .getConstructor()
                .newInstance();
    }
}
