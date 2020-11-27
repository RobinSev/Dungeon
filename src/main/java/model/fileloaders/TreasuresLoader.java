package model.fileloaders;


import model.dungeon.rooms.treasures.Treasure;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class TreasuresLoader extends FileLoader {

    private static final String FILE_NAME = "possibleTreasures.txt";

    /**
     * Construct one version of each treasures specified in the file on attribute, using the canonical names of their class.
     * @return the list of those treasures.
     */
    public static List<Treasure> load(){
        List<Treasure> treasures = new ArrayList<>();
        List<Constructor<?>> constructors = FileLoader.getConstructors(FILE_NAME);
        try {
            for (Constructor<?> constructor : constructors)
                treasures.add((Treasure) constructor.newInstance());
        }catch (Exception e) { e.printStackTrace(); }

        return treasures;
    }
}
