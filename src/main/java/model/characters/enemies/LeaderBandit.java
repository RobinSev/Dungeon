package model.characters.enemies;

import controller.graphical.roomview.EnemyRenderer;
import model.characters.AbstractCharacter;

public class LeaderBandit extends AbstractCharacter implements Enemy {
    private static final int MAX_LIFE = 150;
    private static final int STRENGTH = 15;
    private static final String NAME = "Leader bandit";

    public LeaderBandit() { super(NAME, MAX_LIFE, STRENGTH); }

    @Override
    public void accept(EnemyRenderer renderer) { renderer.renderEnemy(this); }
}
