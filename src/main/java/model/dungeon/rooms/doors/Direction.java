package model.dungeon.rooms.doors;

public enum Direction {
    NORTH,
    EAST,
    WEST,
    SOUTH;

    public Direction getOppositePosition() {
        switch (this) {
            case EAST: return WEST;
            case WEST: return EAST;
            case NORTH: return SOUTH;
            case SOUTH: return NORTH;
        }
        return null;
    }

    public Direction getLeftDirection() {
        switch (this) {
            case NORTH: return WEST;
            case EAST: return NORTH;
            case SOUTH: return EAST;
            case WEST: return SOUTH;
        }
        return null;
    }

    public Direction getRightDirection() {
        switch (this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
        }
        return null;
    }


}
