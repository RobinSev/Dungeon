package model.characters.enemies;

import controller.graphical.roomview.EnemyRenderer;

public interface Enemy {

    void accept(EnemyRenderer renderer);
}
