package model.moves;

import model.dungeon.rooms.doors.Direction;

public class ForwardMove implements Move {

    private Direction playerOrientation;

    public ForwardMove(Direction playerOrientation) {
        this.playerOrientation = playerOrientation;
    }

    @Override
    public Direction getAbsoluteMoveDirection() {
        return playerOrientation;
    }
}
