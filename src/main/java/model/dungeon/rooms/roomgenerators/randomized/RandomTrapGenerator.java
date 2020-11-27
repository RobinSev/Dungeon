package model.dungeon.rooms.roomgenerators.randomized;

import model.dungeon.rooms.Room;
import model.dungeon.rooms.roomgenerators.RoomConstituentGenerator;
import model.dungeon.rooms.traps.Trap;
import model.fileloaders.AllPossibles;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class RandomTrapGenerator implements RoomConstituentGenerator {

    private List<Trap> possibleTraps = AllPossibles.possibleTraps;
    private int trapAppearingThreshold = 10;

    /**
     * Pick a random number between 0 and 99. If it is below the threshold, pick a randon trap from the list of possible
     * traps and add it to the room. Otherwise, do nothing.
     * @param roomToFill the room in which to add the trap.
     */
    @Override
    public void generateConstituent(Room roomToFill) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if(RandomInteger.randomIntIsBelow(trapAppearingThreshold)) {
            roomToFill.addTrap(getNewRandomTrap());
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
    private Trap getNewRandomTrap() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return possibleTraps
                .get(RandomInteger.getRandomInt(possibleTraps.size()))
                .getClass()
                .getConstructor()
                .newInstance();
    }
}
