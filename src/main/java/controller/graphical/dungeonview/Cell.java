package controller.graphical.dungeonview;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.dungeon.rooms.doors.Direction;

/**
 * A cells representing a room into the graphical dungeon grid.
 * Initially, the state of a state is empty because room are generated tour-by-tour.
 */
public class Cell extends Rectangle {

    private static Image playerNorth = new Image("Images/playerOrientation/playerNorth.png");
    private static Image playerSouth = new Image("Images/playerOrientation/playerSouth.png");
    private static Image playerEast = new Image("Images/playerOrientation/playerEast.png");
    private static Image playerWest = new Image("Images/playerOrientation/playerWest.png");


    private CellState state;


    public Cell(double width, double height) {
        super(width, height);
        this.state = CellState.EMPTY;
    }

    public void setState(CellState state, Direction playerOrientation) {
        this.state = state;
        setFill(state.getColor());
        if (state.equals(CellState.ACTUAL)) {
            setFill(new ImagePattern(getOrientationMark(playerOrientation)));
        }
    }


    private Image getOrientationMark(Direction playerDirection) {
        Image mark;
        switch (playerDirection) {
            case EAST: mark = playerEast; break;
            case WEST: mark = playerWest; break;
            case SOUTH: mark = playerSouth; break;
            default: mark = playerNorth; break;
        }
        return mark;
    }


}
