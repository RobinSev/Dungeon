package model.dungeon.rooms.treasures;

import controller.graphical.roomview.TreasureRenderer;
import javafx.scene.image.ImageView;

public class RareTreasure extends AbstractTreasure {

    private static final int CAPACITY = 2;

    public RareTreasure() {
        super(CAPACITY);
    }

    @Override
    public void accept(TreasureRenderer renderer) {
        renderer.renderTreasure(this);
    }
}
