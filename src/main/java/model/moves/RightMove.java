package model.moves;

import model.dungeon.rooms.doors.Direction;

public class RightMove implements Move {

    private Direction playerOrientation;

    public RightMove(Direction playerOrientation) {
        this.playerOrientation = playerOrientation;
    }

    @Override
    public Direction getAbsoluteMoveDirection() {
        return playerOrientation.getRightDirection();
    }
}
