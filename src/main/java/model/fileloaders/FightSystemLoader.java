package model.fileloaders;

import model.fightsystems.FightSystem;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class FightSystemLoader extends FileLoader {

    private static final String FILE_NAME = "possibleFightSystems.txt";

    /**
     * Construct one version of each items specified in the file on attribute, using the canonical names of their class.
     * @return the list of those items.
     */
    public static List<FightSystem> load(){
        List<FightSystem> fightSystems = new ArrayList<>();
        List<Constructor<?>> constructors = FileLoader.getConstructors(FILE_NAME);
        try {
            for (Constructor<?> constructor : constructors)
                fightSystems.add((FightSystem) constructor.newInstance());
        }catch (Exception e) { e.printStackTrace(); }

        return fightSystems;
    }
}
