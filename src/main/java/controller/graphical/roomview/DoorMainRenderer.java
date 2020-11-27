package controller.graphical.roomview;

import controller.graphical.roomview.doorrenderers.ExceptionalDoorRenderer;
import controller.graphical.roomview.doorrenderers.StandardDoorRenderer;
import javafx.scene.image.ImageView;

import model.dungeon.rooms.Room;
import model.dungeon.rooms.doors.Direction;
import model.dungeon.rooms.doors.Door;

import java.util.Map;


public class DoorMainRenderer {

    /**
     * The view container for doors.
     */
    private ImageView frontDoorContainer, leftDoorContainer, rightDoorContainer;

    /**
     * The doors renderer
     */
    private StandardDoorRenderer stdRenderer;
    private ExceptionalDoorRenderer excRenderer;


    public DoorMainRenderer(ImageView frontDoorContainer, ImageView leftDoorContainer, ImageView rightDoorContainer) {
        this.frontDoorContainer = frontDoorContainer;
        this.leftDoorContainer = leftDoorContainer;
        this.rightDoorContainer = rightDoorContainer;
        initializeRenderers();
        buildChain();
    }

    private void initializeRenderers() {
        this.stdRenderer = new StandardDoorRenderer();
        this.excRenderer = new ExceptionalDoorRenderer();
    }

    /**
     * Builds the chain of responsibility of renderers.
     */
    private void buildChain() {
        stdRenderer.setNext(excRenderer);
    }

    /**
     * Renders the doors of the specified room in all the
     * direction according to the player orientation.
     *
     * @param room - The room containing the doors to render.
     * @param playerOrientation - The orientation of the player into the room.
     */
    public void renderDoors(Room room, Direction playerOrientation) {
        Map<Direction, Door> map = room.getAllDoors();
        clearContainer();
        renderFrontDoor(map.get(playerOrientation));
        renderRightDoor(map.get(playerOrientation.getRightDirection()));
        renderLeftDoor(map.get(playerOrientation.getLeftDirection()));
    }

    /**
     * Makes the doors container invisible.
     */
    private void clearContainer() {
        this.frontDoorContainer.setVisible(false);
        this.leftDoorContainer.setVisible(false);
        this.rightDoorContainer.setVisible(false);
    }


    private void renderFrontDoor(Door door) {
        stdRenderer.renderFrontDoor(frontDoorContainer, door);
    }

    private void renderLeftDoor(Door door) {
        stdRenderer.renderLeftDoor(leftDoorContainer, door);
    }

    private void renderRightDoor(Door door) {
        stdRenderer.renderRightDoor(rightDoorContainer, door);
    }

}
