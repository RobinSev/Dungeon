package model.characters.playables;


import model.characters.AbstractCharacter;

public class PersonalizedPlayer extends AbstractCharacter implements Playable {
    public PersonalizedPlayer(String name, int maximumLife, int strength) {
        super(name, maximumLife, strength);
    }
}
