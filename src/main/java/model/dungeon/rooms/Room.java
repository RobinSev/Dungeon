package model.dungeon.rooms;

import model.characters.Character;
import model.dungeon.rooms.doors.Door;
import model.dungeon.rooms.doors.Direction;
import model.exceptions.DoorAlreadyExistsException;
import model.dungeon.rooms.traps.Trap;
import model.dungeon.rooms.treasures.Treasure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private Map<Direction, Door> doors;
    private List<Treasure> treasures;
    private List<Trap> traps;
    private Character enemy;

    public Room() {
        doors = new HashMap<>();
        treasures = new ArrayList<>();
        traps = new ArrayList<>();
    }

    public boolean addTrap(Trap trap) { return traps.add(trap); }

    public boolean addTreasure(Treasure treasure) { return treasures.add(treasure); }

    public void addDoor(Door door) throws DoorAlreadyExistsException {
        if(doors.containsKey(door.getPosition()))
            throw new DoorAlreadyExistsException("There is already a door at this position");
        doors.put(door.getPosition(), door);
    }

    public void setEnemy(Character enemy) { this.enemy = enemy; }

    public boolean hasDoorAtDirection(Direction direction) {
        return doors.containsKey(direction);
    }

    /**
     * return the enemy in the room, or null if there is no enemy.
     * @return the enemy in the room, or null if there is no enemy.
     */
    public Character getEnemy() { return enemy; }

    public boolean hasEnemy() { return enemy != null; }

    /**
     * Return the door at the specified position, or null if there isn't one.
     * @param direction the position of the door we want to get.
     * @return return the door at the specified position, or null if there isn't one.
     */
    public Door getDoorAtDirection(Direction direction) { return doors.get(direction); }

    public Map<Direction, Door> getAllDoors() { return doors; }

    public List<Treasure> getTreasures() { return treasures; }

    public List<Trap> getTraps() { return traps; }


}
