package model.characters.playables;

import model.characters.AbstractCharacter;

public class StrongPlayer extends AbstractCharacter implements Playable {
    private static final int MAX_LIFE = 320;
    private static final int STRENGTH = 60;
    public StrongPlayer(String name) {
        super(name, MAX_LIFE, STRENGTH);
    }

    @Override
    public String toString() {
        return  "Strong player";
    }
}
