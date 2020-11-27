package controller.graphical.roomview;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.dungeon.rooms.treasures.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TreasureRenderer {


    private List<ImageView> treasureContainers;

    private Image commonTreasureImage = new Image("images/treasures/commonTreasure.png");
    private Image rareTreasureImage = new Image("images/treasures/rareTreasure.png");
    private Image veryRareTreasureImage = new Image("images/treasures/veryRareTreasure.png");


    public TreasureRenderer(ImageView... treasureContainers) {
        checkNumberTreasureContainers(treasureContainers);
        this.treasureContainers = new ArrayList<>();
        this.treasureContainers.addAll(Arrays.asList(treasureContainers));
    }

    /**
     * Check the number of treasure containers.
     * Precisely throws an IllegalArgumentException if no treasure containers were
     * provided.
     *
     * @param treasureContainers - the collection of treasure containers to check.
     */
    private void checkNumberTreasureContainers(ImageView[] treasureContainers) {
        if (treasureContainers.length == 0)
            throw new IllegalArgumentException("Not enough treasure containers to build a treasureRenderer");
    }

    /**
     * The start point for rendering the treasure.
     * If there is no treasure to render, then the methods returned.
     * Otherwise, for each treasure, it visits each treasure to render.
     * @param treasures - The list of treasures to render.
     */
    public void render(List<Treasure> treasures) {
        clearContainers();
        if (treasures.isEmpty()) return;
        for (int index = 0; index < treasures.size(); index++) {
            visit(treasures.get(index));
        }
    }

    /**
     * Visits the specified treasure if it is not already opened.
     * @param treasure - the treasure to visit.
     */
    private void visit(Treasure treasure) {
        if (treasure.hasBeenOpened()) return;
        treasure.accept(this);
    }

    /**
     * Makes all the containers invisibles.
     */
    private void clearContainers() {
        for (ImageView container : treasureContainers) {
            container.setVisible(false);
        }
    }

    /**
     * Returns an available container if there one, null otherwise.
     * A container is considered as available if it is not visible.
     * Indeed, when the render method is called, the container are
     * cleared and so the view is ot visible if it's not already
     * associates to a treasure of the current room
     *
     * @return an available container if there is one, null otherwise.
     */
    private ImageView getFreeContainer() {
        for (ImageView treasureContainer : treasureContainers) {
            if (treasureContainer.isVisible()) continue;
            return treasureContainer;
        }
        return null;
    }

    public void renderTreasure(CommonTreasure treasure) {
        ImageView container = getFreeContainer();
        if (container == null) return;
        container.setImage(commonTreasureImage);
        container.setVisible(true);
    }

    public void renderTreasure(RareTreasure treasure) {
        ImageView container = getFreeContainer();
        if (container == null) return;
        container.setImage(rareTreasureImage);
        container.setVisible(true);
    }

    public void renderTreasure(VeryRareTreasure treasure) {
        ImageView container = getFreeContainer();
        if (container == null) return;
        container.setImage(veryRareTreasureImage);
        container.setVisible(true);
    }


    public void renderTreasure(PersonalizedTreasure treasure) {
        ImageView container = getFreeContainer();
        if (container == null) return;
        container.setImage(commonTreasureImage);
        container.setVisible(true);
    }


}
