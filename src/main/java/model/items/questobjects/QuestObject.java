package model.items.questobjects;

import model.characters.Character;
import model.exceptions.NotAUsableItemException;
import model.items.Item;

import java.util.Objects;

public abstract class QuestObject implements Item {

    String name;
    String description;

    public QuestObject(String name) {
        this.name = name;
        this.description = "The " + name + " you were asked to find.";
    }

    @Override
    public void useOn(Character user) throws NotAUsableItemException {
        throw new NotAUsableItemException("This is a quest item.");
    }

    @Override
    public String getDescription() { return description; }

    @Override
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RareMedallion that = (RareMedallion) o;
        return Objects.equals(name, that.name);
    }
}
