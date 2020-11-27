package model.items;

import model.characters.Character;
import model.exceptions.NotAUsableItemException;

public interface Item {

    void useOn(Character user) throws NotAUsableItemException;
    String getDescription();
    String getName();
}
