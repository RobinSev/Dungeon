package model.victoryconditions;

public class VictoryForRoomExplored implements VictoryCondition {
    private final int ROOMS_REQUIRED = 20;

    @Override
    public boolean test(RelevantProgress relevantProgress) {
        return relevantProgress.getNbOfRoomsExplored() >= ROOMS_REQUIRED;
    }
}
