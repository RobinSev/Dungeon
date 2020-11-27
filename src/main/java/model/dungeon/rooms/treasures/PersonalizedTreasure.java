package model.dungeon.rooms.treasures;

import controller.graphical.roomview.TreasureRenderer;
import javafx.scene.image.ImageView;

public class PersonalizedTreasure extends AbstractTreasure {

    protected PersonalizedTreasure(int capacity) { super(capacity); }

    @Override
    public void accept(TreasureRenderer renderer) {
        renderer.renderTreasure(this);
    }
}
