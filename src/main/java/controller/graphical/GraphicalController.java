package controller.graphical;

import controller.ViewController;
import controller.ViewModel;
import controller.graphical.bagview.BagController;
import controller.graphical.dungeonview.MatrixPane;
import controller.graphical.roomview.RoomController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyEvent;
import model.items.Item;
import model.moves.BackwardMove;
import model.moves.ForwardMove;
import model.moves.LeftMove;
import model.moves.RightMove;


public class GraphicalController extends ViewController {

    /**
     * The grid representing the dungeon into the GUI.
     */
    @FXML
    private MatrixPane dungeonGrid;

    /**
     * The ListView representing the player's bag.
     */
    @FXML
    private ListView<Item> bag;

    /**
     * The graphical representation of the life level of the player.
     */
    @FXML
    private ProgressBar lifeBar;

    /**
     * The Label containing the strength point of the player.
     */
    @FXML
    private Label strengthLabel;

    /**
     * The sub-controller that handles the content
     * of the graphical Bag.
     */
    private BagController bagController;

    /**
     * The sub-controller that handles the graphical
     * representation of a room;
     */
    @FXML
    private RoomController roomController;


    public GraphicalController() {
        super();
    }

    /**
     * Handles the event launched by a keyboard action.
     * It retrieves the code of the event and call the right method of the viewModel
     * for each key taken into account.
     *
     * @param event - The event to handle.
     */
    protected void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP: viewModel.handleMove(new ForwardMove(viewModel.getPlayerOrientation())); break;
            case LEFT: viewModel.handleMove(new LeftMove(viewModel.getPlayerOrientation())); break;
            case RIGHT: viewModel.handleMove(new RightMove(viewModel.getPlayerOrientation())); break;
            case DOWN: viewModel.handleMove(new BackwardMove(viewModel.getPlayerOrientation())); break;
            case C: viewModel.collectTreasures();break;
        }
    }

    /**
     * Updates all the elements of the game.view.
     */
    @Override
    public void update() {
        bagController.update();
        roomController.update();
        dungeonGrid.update();
        updateLife();
        updateStrength();
    }



    /**
     * Initializes the controllers with the FXML components.
     * @param viewModel - The game.view model
     */
    public void initialize(ViewModel viewModel) {
        setViewModel(viewModel);
        dungeonGrid.initialize(viewModel);
        roomController.initialize(viewModel);
        bagController = new BagController(bag, viewModel);
        update();
        viewModel.fight();
    }

    /**
     * Updates the strength into the GUI.
     */
    private void updateStrength() {
        strengthLabel.setText(
                String.valueOf(viewModel.getPlayer().getStrength()));
    }

    /**
     * Updates the level of the life bar.
     */
    public void updateLife() {
        double life = viewModel.getPlayer().getLife();
        double maxLife = viewModel.getPlayer().getMaximumLife();
        lifeBar.setProgress(life/maxLife);
    }

}
