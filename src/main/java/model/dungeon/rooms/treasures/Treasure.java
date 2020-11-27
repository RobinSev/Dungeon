package model.dungeon.rooms.treasures;

import controller.graphical.roomview.TreasureRenderer;
import javafx.scene.image.ImageView;
import model.characters.Character;
import model.items.Item;



public interface Treasure {

    /**
     * Add all the items in the treasure to the bag of the looter, and remove them all of them in the chest.
     * @param looter the character looting the treasure.
     */
    void transferLoot(Character looter);
    boolean addItem(Item item);
    int getCapacity();
    boolean hasBeenOpened();
    void accept(TreasureRenderer renderer);
}
