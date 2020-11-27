package model.dungeon.rooms.treasures;

import controller.graphical.roomview.TreasureRenderer;
import javafx.scene.image.ImageView;
import model.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.characters.Character;

public abstract class AbstractTreasure implements Treasure {
    protected List<Item> content;
    protected int capacity;
    protected boolean hasBeenOpened;

    protected AbstractTreasure(int capacity) {
        this.capacity = capacity;
        hasBeenOpened = false;
        content = new ArrayList<>();
    }

    /**
     * Add all the items in the treasure to the bag of the looter, and remove them all of them in the chest.
     * @param looter the character looting the treasure.
     */
    @Override
    public void transferLoot(Character looter) {
        for(Item item : content) {
            looter.getBag().add(item);
        }
        content = new ArrayList<>();
        hasBeenOpened = true;
    }

    @Override
    public boolean addItem(Item item) {
        if(content.size() >= capacity) return false;
        return content.add(item);
    }

    @Override
    public int getCapacity() { return capacity; }

    @Override
    public boolean hasBeenOpened() { return hasBeenOpened; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractTreasure)) return false;
        AbstractTreasure that = (AbstractTreasure) o;
        return capacity == that.capacity &&
                Objects.equals(content, that.content);
    }
}
