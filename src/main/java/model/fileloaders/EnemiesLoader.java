package model.fileloaders;

import model.characters.Character;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;


public class EnemiesLoader extends FileLoader {

    private static final String FILE_NAME = "possibleEnemies.txt";

    /**
     * Construct one version of each possible ennemy specified in the file on attribute, using the canonical names of their class.
     * @return the list of those possible enemies.
     */
    public static List<Character> load(){
        List<Character> characters = new ArrayList<>();
        List<Constructor<?>> constructors = FileLoader.getConstructors(FILE_NAME);
        try {
            for (Constructor<?> constructor : constructors)
                characters.add((Character) constructor.newInstance());
        }catch (Exception e) { e.printStackTrace(); }

        return characters;
    }
}
