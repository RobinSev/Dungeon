package model.fileloaders;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileLoader {
    protected static String DIRECTORY_PATH = "src/main/resources/constituents/";

    /**
     * Provide a method for the inherited class to collect all the constructors with no parameters from the class
     * canonical names written in the file given in parameter, assuming it is stored in the directory path.
     * @param fileName the file name and extension to read on.
     * @return the list of the constructors with no parameters from the file.
     */
    protected static List<Constructor<?>> getConstructors(String fileName) {
        List<Constructor<?>> constructors = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(DIRECTORY_PATH + fileName));
            while (scanner.hasNextLine()) {
                constructors.add(Class.forName(scanner.nextLine().trim()).getConstructor());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return constructors;
    }

}
