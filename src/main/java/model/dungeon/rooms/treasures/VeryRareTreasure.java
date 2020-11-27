package model.dungeon.rooms.treasures;

import controller.graphical.roomview.TreasureRenderer;
import javafx.scene.image.ImageView;

public class VeryRareTreasure extends AbstractTreasure {

    private static final int CAPACITY = 3;

    public VeryRareTreasure() { super(CAPACITY); }

    @Override
    public void accept(TreasureRenderer renderer) {
        renderer.renderTreasure(this);
    }
}
