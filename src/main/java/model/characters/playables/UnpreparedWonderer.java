package model.characters.playables;

import model.characters.AbstractCharacter;

public class UnpreparedWonderer extends AbstractCharacter implements Playable {

    private static final int MAX_LIFE = 40;
    private static final int STRENGTH = 5;

    public UnpreparedWonderer(String name) {
        super(name, MAX_LIFE, STRENGTH);
    }

    @Override
    public String toString() {
        return "Unprepared wonderer";
    }
}
