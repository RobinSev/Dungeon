package model.characters;

import model.items.Item;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents the set of items belonging to a character.
 * The character can add an item by collecting it (or winning it?).
 */
public class Bag {

    private List<Item> items;

    public Bag() {
        this.items = new ArrayList<>();
    }

    /**
     * Returns the list of all the items contained in the bag.
     * @return the list of all the items contained in the bag
     */
    public List<Item> getItems() {
        return items;
    }

    public boolean contains(Item item) { return items.contains(item); }

    public boolean isEmpty() { return items.isEmpty(); }

    /**
     * Adds the specified <code>item</code> to the bag.
     *
     * @param item - The item to add.
     */
    public void add(Item item) {
        items.add(item);
    }

    /**
     * Removes the specified <code>item</code> from the bag.
     *
     * @param item - The item to remove.
     */
    public void remove(Item item) {
        items.remove(item);
    }

}
