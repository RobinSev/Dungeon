package model.characters.playables;

import model.characters.AbstractCharacter;

public class UnkillablePlayer extends AbstractCharacter implements Playable {
    private static final int MAX_LIFE = 10000;
    private static final int STRENGTH = 10000;

    public UnkillablePlayer(String name) {
        super(name, MAX_LIFE, STRENGTH);
    }

    @Override
    public String toString() {
        return "Unkillable player";
    }
}
