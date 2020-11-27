package model.victoryconditions.victoriesbyitems;

import model.fileloaders.AllPossibles;
import model.items.Item;
import model.victoryconditions.RelevantProgress;
import model.victoryconditions.VictoryCondition;

public abstract class VictoryByItemFound implements VictoryCondition {
    private final Item itemRequired;

    protected VictoryByItemFound(Item item) {
        this.itemRequired = item;
        AllPossibles.possibleItems.add(itemRequired);
    }

    @Override
    public boolean test(RelevantProgress relevantProgress) {
        return relevantProgress.getItemsPossessed().contains(itemRequired);
    }
}
