package model.characters;

import model.exceptions.NotAUsableItemException;
import model.items.Item;

public interface Character {

    void updateLife(int delta);
    void updateMaxLife(int delta);
    void updateStrength(int delta);
    Bag getBag();
    String getName();
    void attack(Character target);
    boolean isDead();
    int getMaximumLife();
    int getLife();
    int getStrength();
    boolean use(Item item, Character target) throws NotAUsableItemException;

}
