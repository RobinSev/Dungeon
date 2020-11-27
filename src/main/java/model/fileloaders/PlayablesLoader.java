package model.fileloaders;

import model.characters.Character;


import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayablesLoader extends FileLoader {

    private static final String FILE_NAME = "possiblePlayables.txt";

    /**
     * Construct one version of each playable characters specified in the file on attribute, using the canonical names of their class.
     * Gives each character built the default name "For selection", as those objects must only be used as a selecting
     * type in the menu, or rename according to the player's input.
     * @return the list of those playables characters.
     */
    public static List<Character> load(){
        List<Character> characters = new ArrayList<>();
        List<Constructor<?>> constructors = getConstructors();
        try {
            for (Constructor<?> constructor : constructors)
                characters.add((Character) constructor.newInstance("For selection"));
        }catch (Exception e) { e.printStackTrace(); }

        return characters;
    }

    /**
     * Get the list of the constructors with a string parameter for each class in the file,
     * @return the list of the constructors.
     */
    private static List<Constructor<?>> getConstructors() {
        List<Constructor<?>> constructors = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(FileLoader.DIRECTORY_PATH + FILE_NAME));
            while (scanner.hasNextLine()) {
                constructors.add(Class.forName(scanner.nextLine().trim()).getConstructor(String.class));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return constructors;
    }
}
