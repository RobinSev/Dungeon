package view;

import controller.ViewController;
import controller.ViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import model.*;

import java.io.IOException;

/**
 * This class contains all the methods that should be common to all the possible views.
 * So this class can be extends by both the graphical and the textual view.
 */
public abstract class AbstractView implements View {

    /**
     * The object that loads the FXML file
     */
    protected FXMLLoader loader;
    private Game game;
    /**
     * The controller class of the FXML.
     */
    protected ViewController view;


    protected AbstractView(Game game) {
        this.game = game;
        this.loader = new FXMLLoader();
    }

    /**
     * Initializes the window and its controller before
     * showing it.
     *
     * @param path - The path to the FXML file.
     * @param title - The title of the window.
     * @param width - The width of the window.
     * @param height - The height of the window.
     * @throws IOException - throws if the file couldn't be found.
     */
    protected void start(String path, String title, int width, int height)
            throws IOException {
        Parent root = getParent(path);
        Scene scene = new Scene(root, width, height);
        initializeView(scene);
        Stage stage = initializeStage(title, scene);
        stage.show();

    }


    /**
     * Returns the javaFX root component for the interface
     * (the JavaFX container that contains all the other container and
     * JavaFX components, so the root node of the interface's tree structure).
     *
     * @return the JavaFX root component for the interface.
     * @throws IOException - the exception thrown if the fxml file can't be loaded.
     */
    private Parent getParent(String path) throws IOException {
        loader.setLocation(getClass().getResource(path));
        return loader.load();
    }


    /**
     * Initializes the FXML controller by giving it the viewModel and setting
     * the event handler related to the specified scene.
     */
    private void initializeView(Scene scene) {
        view = loader.getController();
        view.initialize(new ViewModel(game, view));
        view.setEventHandler(scene);
    }


    /**
     * Creates a stage with the specified title and scene.
     * The returned stage has the same dimension of its scene
     * and is not resizable.
     *
     * @param title - The title of the stage.
     * @param scene - The scene contained by the stage.
     */
    private Stage initializeStage(String title, Scene scene) {
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.sizeToScene();
        return stage;
    }

    public abstract void start() throws Exception;
}

