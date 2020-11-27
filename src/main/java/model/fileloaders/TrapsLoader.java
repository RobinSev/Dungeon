package model.fileloaders;

import model.dungeon.rooms.traps.Trap;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class TrapsLoader extends FileLoader {

    private static final String FILE_NAME = "possibleTraps.txt";

    /**
     * Construct one version of each traps specified in the file on attribute, using the canonical names of their class.
     * @return the list of those traps.
     */
    public static List<Trap> load(){
        List<Trap> traps = new ArrayList<>();
        List<Constructor<?>> constructors = FileLoader.getConstructors(FILE_NAME);
        try {
            for (Constructor<?> constructor : constructors)
                traps.add((Trap) constructor.newInstance());
        }catch (Exception e) { e.printStackTrace(); }

        return traps;
    }
}
