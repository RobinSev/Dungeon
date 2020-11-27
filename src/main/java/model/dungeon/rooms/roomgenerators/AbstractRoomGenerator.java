package model.dungeon.rooms.roomgenerators;

import model.dungeon.rooms.doors.Door;
import model.dungeon.rooms.doors.Direction;
import model.exceptions.DoorAlreadyExistsException;
import model.dungeon.rooms.Room;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class AbstractRoomGenerator implements RoomGenerator {

    private RoomConstituentGenerator trapGenerator;
    private RoomConstituentGenerator treasureGenerator;
    private RoomConstituentGenerator enemyGenerator;

    public AbstractRoomGenerator(RoomConstituentGeneratorsFactory factory) {
        trapGenerator = factory.createTrapGenerator();
        treasureGenerator = factory.createTreasureGenerator();
        enemyGenerator = factory.createEnemyGenerator();
    }

    /**
     * Delegate the generation of each constituent of the room to the specified generators, calling them a number of times
     * linked to the maximum number of constituent a room is allowed to have.
     * @param forbiddenDirections the directions where there must be no door.
     * @param doorsRequired the doors the room must have.
     * @return the room verifying all constraints expressed on doors and number of constituents allowed.
     */
    @Override
    public Room generateRoom(List<Direction> forbiddenDirections, List<Door> doorsRequired) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Room room = new Room();
        try{
            generateDoors(room, forbiddenDirections, doorsRequired);
        }catch(DoorAlreadyExistsException e) { e.printStackTrace(); }


        int counter = 0;
        while(counter <= MaximumElementsAllowed.MAX_NUMBER_OF_ENEMIES) {
            enemyGenerator.generateConstituent(room);
            counter++;
        }

        counter = 0;
        while(counter <= MaximumElementsAllowed.MAX_NUMBER_OF_TRAPS) {
            trapGenerator.generateConstituent(room);
            counter++;
        }

        counter = 0;
        while(counter <= MaximumElementsAllowed.MAX_NUMBER_OF_TREASURES) {
            treasureGenerator.generateConstituent(room);
            counter++;
        }

        return room;
    }



    /**
     * Determine a method of generation of doors for all allowed directions currently without doors.
     * @param roomToFill the room in which to add doors.
     * @param forbiddenDoorDirections the directions in which no door is allowed.
     * @throws DoorAlreadyExistsException if a door is add in a direction where there is already a door.
     */
    protected abstract void generateDoors(Room roomToFill, List<Direction> forbiddenDoorDirections, List<Door> doorsRequired) throws DoorAlreadyExistsException;

}
