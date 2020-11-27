package model.dungeon.rooms.roomgenerators;

import model.dungeon.rooms.doors.Door;
import model.dungeon.rooms.doors.DoorFactory;
import model.dungeon.rooms.doors.Direction;
import model.exceptions.DoorAlreadyExistsException;
import model.dungeon.rooms.Room;
import model.dungeon.rooms.roomgenerators.randomized.RandomInteger;

import java.util.List;

public class RoomWithRandomDoorsGenerator extends AbstractRoomGenerator {

    private DoorFactory doorFactory = new DoorFactory();
    private int doorAppearingThreshold = 40;

    public RoomWithRandomDoorsGenerator(RoomConstituentGeneratorsFactory factory) {
        super(factory);
    }

    /**
     * For each authorized direction, pick a random number between 0 and 99. If this number is below the threshold in
     * attribute, add a door. Make sure that there is at least one door leading to a unexplored room, if possible.
     * @param roomToFill the room in which to add doors.
     * @param forbiddenDirections the directions in which no door is allowed.
     * @param requiredDoors the requiredDoor to be consistent.
     * @throws DoorAlreadyExistsException if there is a attempt to add a door in a position already occupied.
     */
    @Override
    protected void generateDoors(Room roomToFill, List<Direction> forbiddenDirections, List<Door> requiredDoors) throws DoorAlreadyExistsException {
        addAllDoors(requiredDoors, roomToFill);
        completeForbiddenDirections(forbiddenDirections, requiredDoors);
        if(mustBeAnImpasse(forbiddenDirections)) return;

        while(!canLeadToANewRoom(requiredDoors, roomToFill)) {
            for (Direction direction : Direction.values()) {
                if (isAnAuthorizedDoorPosition(roomToFill, forbiddenDirections, direction)) {
                    generateDoorForPosition(direction, roomToFill);
                }
            }
        }
    }

    private boolean mustBeAnImpasse(List<Direction> forbiddenDirection) { return forbiddenDirection.size() == Direction.values().length; }

    private boolean isAnAuthorizedDoorPosition(Room roomToFill, List<Direction> forbiddenDirections, Direction direction) {
        return !roomToFill.hasDoorAtDirection(direction) && !forbiddenDirections.contains(direction);
    }

    private void generateDoorForPosition(Direction direction, Room roomToFill) throws DoorAlreadyExistsException {
        if(RandomInteger.randomIntIsBelow(doorAppearingThreshold))
            roomToFill.addDoor(doorFactory.createSimpleDoor(direction));
    }


    private void addAllDoors(List<Door> doorsRequired, Room room) throws DoorAlreadyExistsException {
        for(Door door : doorsRequired)
            room.addDoor(door);
    }

    /**
     * Check if a door leading to a currently unvisited room was generated. Relies on the fact that all doors leading
     * to a visited room are in the requiredDoors list.
     * @param requiredDoors the doors required to be consistent.
     * @param room the room generated.
     * @return {@code true} if the room can lead to a new room, {@code false} otherwise.
     */
    private boolean canLeadToANewRoom(List<Door> requiredDoors, Room room) {
        for(Door door : room.getAllDoors().values()) {
            if(!requiredDoors.contains(door)) return true;
        }
        return false;
    }

    /**
     * Add all the doors required directions to the forbidden directions, as thoses directions are already occupied.
     * @param forbiddenDirections the forbidden direction to put doors in.
     * @param requiredDoors the doors required to be consistent.
     */
    private void completeForbiddenDirections(List<Direction> forbiddenDirections, List<Door> requiredDoors) {
        for(Door door : requiredDoors) {
            forbiddenDirections.add(door.getPosition());
        }
    }

}
