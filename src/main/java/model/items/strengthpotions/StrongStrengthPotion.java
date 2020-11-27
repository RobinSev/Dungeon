package model.items.strengthpotions;

public class StrongStrengthPotion extends StrengthPotion {

    private static final int STANDARD_STRENGTH_BENEFIT = 15;
    private static final String STANDARD_NAME = "Strong Strength Potion";

    public StrongStrengthPotion() {
        super(STANDARD_NAME, STANDARD_STRENGTH_BENEFIT);
    }
}
