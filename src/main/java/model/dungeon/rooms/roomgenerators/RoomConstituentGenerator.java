package model.dungeon.rooms.roomgenerators;

import model.dungeon.rooms.Room;

import java.lang.reflect.InvocationTargetException;

public interface RoomConstituentGenerator {

    void generateConstituent(Room roomToFill) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
