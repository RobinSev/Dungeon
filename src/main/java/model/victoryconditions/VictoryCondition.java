package model.victoryconditions;

import java.util.function.Predicate;

public interface VictoryCondition extends Predicate<RelevantProgress> {
    boolean test(RelevantProgress relevantProgress);
}
