package model.dungeon;

import model.dungeon.rooms.doors.Door;
import model.dungeon.rooms.doors.Direction;
import model.dungeon.rooms.doors.DoorFactory;
import model.dungeon.rooms.Room;
import model.dungeon.rooms.roomgenerators.RoomGenerator;
import model.dungeon.rooms.roomgenerators.RoomWithRandomDoorsGenerator;
import model.dungeon.rooms.roomgenerators.randomized.RandomConstituentGeneratorsFactory;
import model.moves.Move;
import model.victoryconditions.RelevantProgress;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    private Room[][] dungeon;
    private Coordinates playerPosition;
    private RoomGenerator roomGenerator;
    private DoorFactory doorFactory;
    private Direction playerOrientation;

    public Dungeon() {
        dungeon = new Room[HEIGHT][WIDTH];
        playerPosition = new Coordinates(0, 0);
        this.roomGenerator = new RoomWithRandomDoorsGenerator(new RandomConstituentGeneratorsFactory());
        generateRoomAtCoordinates(playerPosition);
        this.doorFactory = new DoorFactory();
        playerOrientation = Direction.EAST;
    }

    /**
     * Handle the movement depending on the {@param move} given in parameter. Returns the destination room, or null
     * if the original room didn't have a door in that direction. Double check if the move is valid, aka if there is a
     * door in this direction in the room (considering a door should not be in a room if taking it would lead out of the
     * dungeon grid).
     *
     * @param move the move the player made.
     * @param relevantProgress the stat tracker, to increment if the player visits a new room.
     * @return the destination room or null if the original room didn't have a door in that direction.
     */
    public Room handleMove(Move move, RelevantProgress relevantProgress) {

        Direction absoluteDirection = move.getAbsoluteMoveDirection();

        if(!getCurrentRoom().hasDoorAtDirection(absoluteDirection) || !isValidDirection(absoluteDirection)) return null;

        playerOrientation = absoluteDirection;

        playerPosition = playerPosition.getCoordinatesForDirection(absoluteDirection);
        if(getCurrentRoom() != null) return getCurrentRoom();

        relevantProgress.incrementNbRoomsExplored();
        return generateRoomAtCoordinates(playerPosition);
    }

    public Room getCurrentRoom() {
        return getRoomAtCoordinates(playerPosition);
    }

    private Room getRoomAtCoordinates(Coordinates coordinates) {
        return dungeon[coordinates.getAbscissa()][coordinates.getOrdinate()];
    }

    private Room generateRoomAtCoordinates(Coordinates coordinates) {
        Room room = null;
        try {
            room = roomGenerator.generateRoom(determineForbiddenDirections(), determineRequiredDoors());
        } catch (Exception e) {
            e.printStackTrace();
        }
        dungeon[coordinates.getAbscissa()][coordinates.getOrdinate()] = room;
        return room;
    }

    /**
     * Using the player current position, determine the directions that would lead the player to exit the dungeon grid if
     * he were to move to this direction. It also forbid directions where This method is used during the room generation to make sure no door leads
     * outside of the dungeon grid, preventing an OutOfBoundException.
     * @return the forbidden direction to puts doors during the room generation.
     */
    private List<Direction> determineForbiddenDirections() {
        List<Direction> forbiddenDirections = new ArrayList<>();
        Coordinates coordinates;
        for(Direction direction : Direction.values()) {
            if(!isValidDirection(direction))
                forbiddenDirections.add(direction);
            else {
                coordinates = playerPosition.getCoordinatesForDirection(direction);
                if(hasRoomAtCoordinates(coordinates) &&
                        !hasDoorTowardsThisRoom(coordinates, direction.getOppositePosition()))
                    forbiddenDirections.add(direction);
            }
        }

        return forbiddenDirections;
    }

    /**
     * Using the current player position, determine if the adjacent existing rooms have doors leading to the current room.
     * If so, create a door leading to them, to use in the room generation, to be consistent. This is link to the
     * symetrical property of our doors : if a door from a first room leads to a second room, then there must be a
     * door in the second room leading to the first room, placed in the proper direction.
     * @return the list of doors required in the generated room
     */
    private List<Door> determineRequiredDoors() {
        List<Door> doorsRequired = new ArrayList<>();
        Coordinates coordinates;

        for(Direction direction : Direction.values()) {
            if(!isValidDirection(direction)) continue;
            coordinates = playerPosition.getCoordinatesForDirection(direction);
            if(hasDoorTowardsThisRoom(coordinates, direction.getOppositePosition()))
                doorsRequired.add(doorFactory.createSimpleDoor(direction));
        }

        return doorsRequired;
    }

    /**
     * Check if a movement in this direction would put the player out of the dungeon grid.
     * @param direction the direction to check.
     * @return {@code true} if the direction does not lead out of the dungeon grid, {@code false} otherwise.
     */
    private boolean isValidDirection(Direction direction) {
        Coordinates coordinates = playerPosition.getCoordinatesForDirection(direction);
        return coordinates.getAbscissa() >= 0 && coordinates.getAbscissa() < HEIGHT
                && coordinates.getOrdinate() >= 0 && coordinates.getOrdinate() < WIDTH;
    }

    private boolean hasRoomAtCoordinates(Coordinates coordinates) {
        return getRoomAtCoordinates(coordinates) != null;
    }

    private boolean hasDoorTowardsThisRoom(Coordinates coordinates, Direction directionTowardsActualRoom) {
        return hasRoomAtCoordinates(coordinates) &&
                getRoomAtCoordinates(coordinates).hasDoorAtDirection(directionTowardsActualRoom);
    }

    public Coordinates getPlayerPosition() { return playerPosition; }

    public Direction getPlayerOrientation() { return playerOrientation; }
}
