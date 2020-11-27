package model.items.strengthpotions;

public class LightStrengthPotion extends StrengthPotion {

    private static final int STANDARD_STRENGTH_BENEFIT = 5;
    private static final String STANDARD_NAME = "Light Strength Potion";


    public LightStrengthPotion() {
        super(STANDARD_NAME, STANDARD_STRENGTH_BENEFIT);
    }
}
