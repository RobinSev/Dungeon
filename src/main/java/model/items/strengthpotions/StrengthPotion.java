package model.items.strengthpotions;

import model.characters.Character;
import model.items.Item;

import java.util.Objects;

public abstract class StrengthPotion implements Item {

    private String name, description;
    private int strengthBenefit;

    protected StrengthPotion(String name, int strengthBenefit) throws IllegalArgumentException {
        if(strengthBenefit < 0) throw new IllegalArgumentException("the strength benefits must be positive");
        this.name = name;
        this.strengthBenefit = strengthBenefit;
        this.description = "Gives you "+ strengthBenefit +" strength points.";
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void useOn(Character user) {
        user.updateStrength(strengthBenefit);
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
        StrengthPotion that = (StrengthPotion) o;
        return strengthBenefit == that.strengthBenefit &&
                Objects.equals(name, that.name);
    }
}
