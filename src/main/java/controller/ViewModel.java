package controller;

import model.Game;
import model.characters.Character;
import model.dungeon.Coordinates;
import model.dungeon.rooms.Room;
import model.dungeon.rooms.doors.Direction;
import model.dungeon.rooms.treasures.Treasure;
import model.exceptions.NotAUsableItemException;
import model.items.Item;
import model.moves.Move;
import view.Popup;


/**
 * Communicates with the model (Game class)
 * This class is a mediator between the view and the model.
 * Containing the view-side of the application logic, it sends
 * information to the model and handles the view according to the
 * answer of the model.
 */
public class ViewModel {

    /**
     * The model.
     */
    private Game game;

    /**
     * The FXML main controller.
     */
    private ViewController view;


    public ViewModel(Game game, ViewController view) {
        this.game = game;
        this.view = view;
    }

    public int getDungeonWidth() {
        return game.getDungeonWidth();
    }

    public int getDungeonHeight() {
        return game.getDungeonHeight();
    }

    public Character getPlayer() {
        return game.getPlayer();
    }

    /**
     * Transfers the wished move to the model.
     * After the move was done, the player have a fight with the
     * enemy of the destination room.
     * If the player has moved (i.e.the move is not authorized)
     * an error pop-up is shown to the user.
     *
     * @param move - The move done by the player.
     */
    public void handleMove(Move move) {
        Room newRoom = game.handleMove(move);
        if (!hasMovedTo(newRoom)) {
            Popup.showError("Can't go there");
            return;
        }
        update();
        fight();
    }

    /**
     * Makes the player fight the enemy of the current room.
     * If there is no enemy to fight, the method does nothing.
     * Otherwise, the player fight the enemy according to the
     * pre-selected fight system.
     *
     */
    public void fight() {
        Room room = getCurrentRoom();
        if (!hasEnemyToFight(room)) return;
        game.fight(room.getEnemy());
        update();
    }
    /*  try {
            Thread.sleep(1000);
        } catch (Exception e) { e.printStackTrace();}*/


    /**
     * Returns true if the room contains an enemy to fight.
     *
     * @param room - The room to check the enemy.
     * @return True if the room contains an enemy to fight.
     */
    private boolean hasEnemyToFight(Room room) {
        return hasMovedTo(room) && room.hasEnemy() && !room.getEnemy().isDead();
    }


    /**
     * Returns true if the player has moved.
     * In other words, returns true if the given room
     * is null.
     *
     * @param room - the room to tests.
     * @return true if the player hasMoved.
     */
    private boolean hasMovedTo(Room room) {
        return room != null;
    }

    /**
     * Checks the game state before updating the view.
     */
    private void update() {
        checkGameState();
        view.update();
    }

    /**
     * Checks the game state.
     * If the player has won or lost, a pop-up is shown before exiting the game.
     * Otherwise, this function does nothing.
     */
    private void checkGameState() {
        if (game.isWon())
            Popup.showWinningWindow(getPlayer().getName());
        if (game.isLost()) {
            Popup.showLostWindow(getPlayer().getName());
        }
    }

    /**
     *
     * @return the room in which the user is currently located.
     */
    public Room getCurrentRoom() {
        return game.getCurrentRoom();
    }

    /**
     *
     * @return the coordinates of the room in which the player is located.
     */
    public Coordinates getPlayerPosition() {
        return game.getPlayerPosition();
    }


    /**
     * Sends to the model the instruction to use the specified
     * item on the specified character.
     * If the given character cannot be usable, a pop-up error is
     * shown to the user.
     *
     * @param item - The item to use
     * @param character - The character using this item.
     */
    public void use(Item item, Character character) {
        try {
            game.useItem(item, character);
            update();
        } catch(NotAUsableItemException e) {
            Popup.showError("Not a usable item");
        }
    }

    /**
     * Loots all the treasures into the current room.
     * If the room doesn't contain any treasures,
     * nothing will happen for the user.
     */
    public void collectTreasures() {
        for (Treasure treasure : getCurrentRoom().getTreasures()) {
            game.lootTreasure(treasure);
        }
        update();
    }

    /**
     * Returns the relative orientation of the player.
     * In other words, the direction (North, South, East, West)
     * the player faces to.
     *
     * @return the relative orientation of the player.
     */
    public Direction getPlayerOrientation() {
        return game.getPlayerOrientation();
    }


}
