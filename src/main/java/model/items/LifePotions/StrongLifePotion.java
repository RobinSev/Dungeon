package model.items.LifePotions;

public class StrongLifePotion extends LifePotion {

    private static final int LIFE_BENEFIT = 15;
    private static final String NAME = "Strong Life Potion";

    public StrongLifePotion() {
        super(NAME, LIFE_BENEFIT);
    }
}
