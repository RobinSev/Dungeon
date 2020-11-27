package model.moves;

import model.dungeon.rooms.doors.Direction;

public class LeftMove implements Move {

    private Direction playerOrientation;

    public LeftMove(Direction playerOrientation) {
        this.playerOrientation = playerOrientation;
    }

    @Override
    public Direction getAbsoluteMoveDirection() {
        return playerOrientation.getLeftDirection();
    }
}
