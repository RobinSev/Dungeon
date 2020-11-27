package controller.graphical.roomview.doorrenderers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.dungeon.rooms.doors.Door;
import model.dungeon.rooms.doors.StandardDoor;

/**
 * A node of the Chain of responsibility of doors renderers
 */
public class StandardDoorRenderer extends AbstractDoorRenderer {


    private Image frontDoorImage = loadImage("images/doors/dungeonDoor.png");

    @Override
    public void renderFrontDoor(ImageView container, Door door) {
        if (door instanceof StandardDoor) {
            container.setImage(frontDoorImage);
            container.setVisible(true);
        } else if(hasNextRenderer())
            next.renderFrontDoor(container, door);
    }


    private Image leftDoorImage = loadImage("images/doors/leftDoor.png");

    @Override
    public void renderLeftDoor(ImageView container, Door door) {
        if (door instanceof StandardDoor) {
            container.setImage(leftDoorImage);
            container.setVisible(true);
        } else if(hasNextRenderer())
            next.renderLeftDoor(container, door);
    }



    private Image rightDoorImage = loadImage("images/doors/rightDoor.png");

    @Override
    public void renderRightDoor(ImageView container, Door door) {
        if (door instanceof StandardDoor) {
            container.setImage(rightDoorImage);
            container.setVisible(true);
        } else if(hasNextRenderer())
            next.renderRightDoor(container, door);
    }


}
