package model.items.LifePotions;

import model.characters.Character;
import model.items.Item;

import java.util.Objects;

public abstract class LifePotion implements Item {

    protected String name, description;
    protected int lifeBenefit;

    protected LifePotion(String name, int lifeBenefit) throws IllegalArgumentException {
        if(lifeBenefit < 0) throw new IllegalArgumentException("the life benefits must be positive");
        this.name = name;
        this.description = "Gives you "+ lifeBenefit +" life points.";
        this.lifeBenefit = lifeBenefit;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLifeBenefit() {
        return lifeBenefit;
    }

    public void useOn(Character user) {
        user.updateLife(lifeBenefit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LifePotion that = (LifePotion) o;
        return lifeBenefit == that.lifeBenefit &&
                Objects.equals(name, that.name);
    }
}
