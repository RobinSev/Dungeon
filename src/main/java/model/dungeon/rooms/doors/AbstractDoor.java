package model.dungeon.rooms.doors;

public abstract class AbstractDoor implements Door {

    private Direction direction;

    protected AbstractDoor(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Direction getPosition() { return direction; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractDoor)) return false;
        AbstractDoor that = (AbstractDoor) o;
        return direction == that.direction;
    }

}
