package controller.graphical.roomview.doorrenderers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.dungeon.rooms.doors.Door;

public abstract class AbstractDoorRenderer implements DoorRenderer {

    protected DoorRenderer next;

    protected boolean hasNextRenderer() {
        return next != null;
    }

    public void setNext(DoorRenderer next) {
        this.next = next;
    }

    protected Image loadImage(String filepath) {
        return new Image(filepath);
    }

    @Override
    public abstract void renderFrontDoor(ImageView container, Door door);

    @Override
    public abstract void renderLeftDoor(ImageView container, Door door);

    @Override
    public abstract void renderRightDoor(ImageView container, Door door);
}
