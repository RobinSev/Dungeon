package model.characters.playables;

import model.characters.AbstractCharacter;

public class TankPlayer extends AbstractCharacter implements Playable {
    private static final int MAX_LIFE = 450;
    private static final int STRENGTH = 40;
    public TankPlayer(String name) {
        super(name, MAX_LIFE, STRENGTH);
    }

    @Override
    public String toString() {
        return "Tank player";
    }
}
