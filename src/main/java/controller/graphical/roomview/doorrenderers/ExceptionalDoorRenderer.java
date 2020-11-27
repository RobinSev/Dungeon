package controller.graphical.roomview.doorrenderers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.dungeon.rooms.doors.Door;
import model.dungeon.rooms.doors.StandardDoor;

/**
 * Renders doors of type ExceptionalDoors.
 *
 * Precisely, renders a door if the given door is instance
 * of the class ExceptionalDoors by loading the corresponding
 * image into the container and make it visible.
 * Otherwise, it calls the next DoorRenderer to handle the rendering.
 *
 * It's a node of the Chain of Responsibility to render doors.
 */
public class ExceptionalDoorRenderer extends AbstractDoorRenderer {


    private Image frontDoorImage = loadImage("images/doors/dungeonDoor.png");

    public void renderFrontDoor(ImageView container, Door door) {
        if (door instanceof StandardDoor) {
            container.setImage(frontDoorImage);
            container.setVisible(true);
        } else if (hasNextRenderer())
            next.renderFrontDoor(container, door);
    }


    private Image leftDoorImage = loadImage("images/doors/leftDoor.png");

    public void renderLeftDoor(ImageView container, Door door) {
        if (door instanceof StandardDoor) {
            container.setImage(leftDoorImage);
            container.setVisible(true);
        } else if (hasNextRenderer())
            next.renderLeftDoor(container, door);
    }


    private Image rightDoorImage = loadImage("images/doors/rightDoor.png");

    public void renderRightDoor(ImageView container, Door door) {
        if (door instanceof StandardDoor) {
            container.setImage(rightDoorImage);
            container.setVisible(true);
        } else if (hasNextRenderer())
            next.renderRightDoor(container, door);
    }



}
