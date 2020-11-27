package model.items.armors;

import model.characters.Character;
import model.items.Item;

import java.util.Objects;

public abstract class Armor implements Item {
    protected int protectionValue;
    protected String name;
    protected String description;

    protected Armor(String name, int protectionValue) throws IllegalArgumentException {
       if(protectionValue < 0) throw new IllegalArgumentException( "the protection value must be positive");

        this.protectionValue = protectionValue;
        this.name = name;
        this.description = "Increases your maximum life by " + protectionValue + ".";
    }

    @Override
    public void useOn(Character user) {
        user.updateMaxLife(protectionValue);
        user.updateLife(protectionValue);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armor armor = (Armor) o;
        return protectionValue == armor.protectionValue &&
                Objects.equals(name, armor.name);
    }
}
