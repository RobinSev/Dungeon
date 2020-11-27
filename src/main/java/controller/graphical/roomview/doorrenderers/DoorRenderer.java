package controller.graphical.roomview.doorrenderers;

import javafx.scene.image.ImageView;
import model.dungeon.rooms.doors.Door;

public interface DoorRenderer {

    void renderFrontDoor(ImageView container, Door door);
    void renderLeftDoor(ImageView container, Door door);
    void renderRightDoor(ImageView container, Door door);

}
