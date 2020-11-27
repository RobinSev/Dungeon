package model.dungeon.rooms.roomgenerators;

import model.dungeon.rooms.doors.Door;
import model.dungeon.rooms.doors.Direction;
import model.dungeon.rooms.Room;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface RoomGenerator {

    Room generateRoom(List<Direction> forbiddenDirections, List<Door> doorsRequired) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
