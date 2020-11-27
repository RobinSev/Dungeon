package model.dungeon.rooms.roomgenerators.randomized;

import model.dungeon.rooms.roomgenerators.RoomConstituentGenerator;
import model.dungeon.rooms.roomgenerators.RoomConstituentGeneratorsFactory;

public class RandomConstituentGeneratorsFactory implements RoomConstituentGeneratorsFactory {


    @Override
    public RoomConstituentGenerator createTrapGenerator() {
        return new RandomTrapGenerator();
    }

    @Override
    public RoomConstituentGenerator createTreasureGenerator() {
        return new RandomTreasureGenerator();
    }

    @Override
    public RoomConstituentGenerator createEnemyGenerator() {
        return new RandomEnemyGenerator();
    }
}
