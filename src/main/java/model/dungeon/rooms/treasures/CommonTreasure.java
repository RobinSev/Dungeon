package model.dungeon.rooms.treasures;


import controller.graphical.roomview.TreasureRenderer;
import javafx.scene.image.ImageView;

public class CommonTreasure extends AbstractTreasure {

    private static final int CAPACITY = 1;

    public CommonTreasure() {
        super(CAPACITY);
    }

    @Override
    public void accept(TreasureRenderer renderer) {
        renderer.renderTreasure(this);
    }
}
