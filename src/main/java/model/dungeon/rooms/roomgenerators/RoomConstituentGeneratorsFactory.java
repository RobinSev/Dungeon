package model.dungeon.rooms.roomgenerators;

public interface RoomConstituentGeneratorsFactory {

    RoomConstituentGenerator createTrapGenerator();
    RoomConstituentGenerator createTreasureGenerator();
    RoomConstituentGenerator createEnemyGenerator();
}
