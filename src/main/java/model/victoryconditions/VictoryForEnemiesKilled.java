package model.victoryconditions;

public class VictoryForEnemiesKilled implements VictoryCondition {
    private final int KILLS_REQUIRED = 20;

    @Override
    public boolean test(RelevantProgress relevantProgress) {
        return relevantProgress.getNbOfEnemiesKilled() >= KILLS_REQUIRED;
    }
}
