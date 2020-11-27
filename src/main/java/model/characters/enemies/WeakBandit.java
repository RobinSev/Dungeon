package model.characters.enemies;

import controller.graphical.roomview.EnemyRenderer;
import model.characters.AbstractCharacter;

public class WeakBandit extends AbstractCharacter implements Enemy {
    private static final int MAX_LIFE = 60;
    private static final int STRENGTH = 5;
    private static final String NAME = "Weak bandit";

    public WeakBandit() { super(NAME, MAX_LIFE, STRENGTH); }

    @Override
    public void accept(EnemyRenderer renderer) { renderer.renderEnemy(this); }
}
