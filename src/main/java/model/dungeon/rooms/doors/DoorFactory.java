package model.dungeon.rooms.doors;

public class DoorFactory {

    public Door createSimpleDoor(Direction direction) {
        return new StandardDoor(direction);
    }

    public Door createExceptionalDoor(Direction direction) {
        return new ExceptionalDoor(direction);
    }

}
