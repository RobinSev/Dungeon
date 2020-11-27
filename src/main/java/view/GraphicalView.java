package view;

import model.Game;

public class GraphicalView extends AbstractView {

    /**
     * The title of the window.
     */
    private static final String TITLE = "THE DUNGEON GAME - Graphical Experience";

    /**
     * The dimensions of the scene.
     */
    private static final int WINDOW_WIDTH = 1200, WINDOW_HEIGHT = 700;

    /**
     * The path to the FXML file describing the scene.
     */
    private static final String RESOURCE_PATH = "graphicalGameWindow.fxml";


    public GraphicalView(Game game) {
        super(game);
    }

    public void start() throws Exception {
        start(RESOURCE_PATH, TITLE, WINDOW_WIDTH, WINDOW_HEIGHT);
    }




}
