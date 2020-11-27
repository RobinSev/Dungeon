package model.fileloaders;

import model.items.Item;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ItemsLoader extends FileLoader {

    private static final String FILE_NAME = "possibleItems.txt";

    /**
     * Construct one version of each items specified in the file on attribute, using the canonical names of their class.
     * @return the list of those items.
     */
    public static List<Item> load(){
        List<Item> items = new ArrayList<>();
        List<Constructor<?>> constructors = FileLoader.getConstructors(FILE_NAME);
        try {
            for (Constructor<?> constructor : constructors)
                items.add((Item) constructor.newInstance());
        }catch (Exception e) { e.printStackTrace(); }

        return items;
    }
}
