package view;

import model.*;

public class TextualView extends AbstractView {


    private static final String TITLE = "THE DUNGEON GAME - Textual Experience";
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 600;

    /**
     * The path to the FXML file describing the user interface
     */
    private static final String RESOURCE_PATH = "view/textualGameWindow.fxml";



    public TextualView(Game game) {
        super(game);
    }

    public void start() throws Exception {
        super.start(RESOURCE_PATH, TITLE, WINDOW_WIDTH, WINDOW_HEIGHT);
    }



}
