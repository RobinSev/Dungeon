package model.moves;

import model.dungeon.rooms.doors.Direction;

public class BackwardMove implements Move{

    private Direction playerOrientation;

    public BackwardMove(Direction playerOrientation) {
        this.playerOrientation = playerOrientation;
    }

    @Override
    public Direction getAbsoluteMoveDirection() {
        return playerOrientation.getOppositePosition();
    }
}
