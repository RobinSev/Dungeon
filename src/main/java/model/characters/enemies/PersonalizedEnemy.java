package model.characters.enemies;

import controller.graphical.roomview.EnemyRenderer;
import model.characters.AbstractCharacter;

public class PersonalizedEnemy extends AbstractCharacter implements Enemy {

    public PersonalizedEnemy(String name, int maximumLife, int strength) {
        super(name, maximumLife, strength);
    }

    @Override
    public void accept(EnemyRenderer renderer) { renderer.renderEnemy(this); }
}
