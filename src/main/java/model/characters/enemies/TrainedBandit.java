package model.characters.enemies;

import controller.graphical.roomview.EnemyRenderer;
import model.characters.AbstractCharacter;

public class TrainedBandit extends AbstractCharacter implements Enemy {
    private static final int MAX_LIFE = 90;
    private static final int STRENGTH = 10;
    private static final String NAME = "Trained bandit";

    public TrainedBandit() { super(NAME, MAX_LIFE, STRENGTH); }

    @Override
    public void accept(EnemyRenderer renderer) {
        renderer.renderEnemy(this);
    }
}
