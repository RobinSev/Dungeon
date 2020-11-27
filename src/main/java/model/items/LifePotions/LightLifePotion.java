package model.items.LifePotions;

public class LightLifePotion extends LifePotion {

    private static final int LIFE_BENEFIT = 10;
    private static final String NAME = "Light Life Potion";

    public LightLifePotion() {
        super(NAME, LIFE_BENEFIT);
    }
}
