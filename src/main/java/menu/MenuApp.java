package menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuApp extends Application {

    /**
     * The path to the FXML file
     */
    private static final String RESOURCE_PATH = "menu.fxml";
    /**
     * The name of the window.
     */
    private static final String TITLE = "THE DUNGEON GAME";

    /**
     * The javaFX's Group containing all the other
     * observable components.
     */
    private Parent view;

    /**
     * The method where the application is run from.
     * @param args - Possible arguments in the console.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes the application by loading the FXML file
     * set parameters of the controller and show the stage.
     * @param primaryStage - the stage to show.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeView(primaryStage);
        initializeStage(primaryStage);
        showStage(primaryStage);
    }

    /**
     * Loads the FXML file and provide the using
     * stage to the controller.
     *
     * @param primaryStage - the stage providing to the controller.
     * @throws IOException
     */
    private void initializeView(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(RESOURCE_PATH));
        view = loader.load();
        MenuView controller = loader.getController();
        controller.setStage(primaryStage);
    }

    /**
     * Initializes the stage by setting his title,
     * teh way to handle a close request and
     * adjust its size.
     * @param primaryStage - the initialized stage.
     */
    private void initializeStage(Stage primaryStage) {
        primaryStage.setTitle(TITLE);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.sizeToScene();
    }

    /**
     * Show the stage given stage to the user.
     * @param primaryStage - the stage to show.
     */
    private void showStage(Stage primaryStage) {
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
