package controller.graphical.roomview;

import controller.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.dungeon.rooms.Room;

/**
 * The controller of the room view.
 * It initializes and update the renderer related to
 * this view.
 */
public class RoomController {

    public ViewModel viewModel;
    /**
     * The context of the canvas describing the background.
     */
    public GraphicsContext background;

    /**
     * The canvas containing the background.
     */
    @FXML
    public Canvas backgroundContainer;

    /**
     * The container of the image of the enemy.
     */
    @FXML
    private ImageView enemyContainer;


    /**
     * The containers of the image of a treasure.
     */
    @FXML
    private ImageView leftTreasureContainer;
    @FXML
    private ImageView rightTreasureContainer;

    /**
     * The containers of the doors images.
     */
    @FXML
    private ImageView leftDoorView;
    @FXML
    private ImageView rightDoorView;
    @FXML
    private ImageView frontDoorView;


    /**
     * The renderers of rendable objects contained into a room.
     */
    private TreasureRenderer treasureRenderer;
    private EnemyRenderer enemyRenderer;
    private DoorMainRenderer doorMainRenderer;


    public void initialize(ViewModel viewModel) {
        this.viewModel = viewModel;
        this.enemyRenderer = new EnemyRenderer(enemyContainer);
        initializeTreasureRenderer();
        initializeDoorMainRenderer();
        initializeBackground();
    }

    /**
     * Initializes the door renderer, giving it the door containers.
     */
    private void initializeDoorMainRenderer() {
        this.doorMainRenderer = new DoorMainRenderer(
                frontDoorView,
                leftDoorView,
                rightDoorView
        );
    }

    /**
     * Initializes the treasure renderer, giving it the treasure containers.
     */
    private void initializeTreasureRenderer() {
        this.treasureRenderer = new TreasureRenderer(
                        leftTreasureContainer,
                        rightTreasureContainer
                );
    }

    /**
     * The image of the walls in perspective.
     */
    private Image backgroundImage = loadImage("images/myRoomTemplate.png");

    /**
     * Sets the background as the image of the canvas.
     */
    private void initializeBackground() {
        background = backgroundContainer.getGraphicsContext2D();
        background.drawImage(backgroundImage,
                0,
                0,
                backgroundContainer.getWidth(),
                backgroundContainer.getHeight()
        );
    }

    /**
     * Call the renderer to update the room view.
     */
    public void update() {
        Room room = viewModel.getCurrentRoom();
        doorMainRenderer.renderDoors(room, viewModel.getPlayerOrientation());
        treasureRenderer.render(room.getTreasures());
        if (!room.hasEnemy())
            enemyRenderer.clearContainer();
        else
            enemyRenderer.render(room.getEnemy());
    }

    private Image loadImage(String path) {
        return new Image(path);
    }
}
