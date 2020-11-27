package model.moves;

import model.dungeon.rooms.doors.Direction;

public interface Move {
    Direction getAbsoluteMoveDirection();
}
