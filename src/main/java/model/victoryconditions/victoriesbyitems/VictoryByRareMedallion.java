package model.victoryconditions.victoriesbyitems;

import model.items.Item;
import model.items.questobjects.RareMedallion;

public class VictoryByRareMedallion extends VictoryByItemFound{
    private static final Item item = new RareMedallion();

    public VictoryByRareMedallion() { super(item); }
}
