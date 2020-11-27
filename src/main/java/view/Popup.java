package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

/**
 * This class contains method that shows informations windows,
 * freezing the other windows until the player closes them and
 * put on hold the thread.
 *
 * A Pop-up is a parameterized JavaFX Alert.
 */
public class Popup {

    /**
     * Shows an error pop-up with the specified message
     * as content.
     *
     * @param message - The content of the window.
     */
    public static void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR, message);
        alert.setTitle("An error occurred :/");
        alert.setContentText(message);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }

    /**
     * Shows a pop-up that informs the player he won.
     * When the user closes this window, it exits the program.
     *
     * @param playerName - The name of the winner.
     */
    public static void showWinningWindow(String playerName) {
        ButtonType buttonType = new ButtonType("Close");
        Alert alert = new Alert(AlertType.NONE, getWinMessage(playerName), buttonType);
        alert.setTitle("YOU WIN !");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setOnCloseRequest(e -> System.exit(0));
        alert.showAndWait();
    }

    /**
     * Shows a pop-up that informs the player he lost.
     * When the user closes this window, it exits the program.
     *
     * @param playerName - The name of the loser.
     */
    public static void showLostWindow(String playerName) {
        Alert alert = new Alert(AlertType.INFORMATION, getLoseMessage(playerName));
        alert.setTitle("YOU LOSE...");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setOnCloseRequest(e -> System.exit(0));
        alert.showAndWait();
    }

    /**
     *
     * @param name - The name of the player.
     * @return the message to display in case of win.
     */
    private static String getWinMessage(String name) {
        return "Congratulations ! You managed to beat the dungeon !\n" +
                "Respect to you, "+ name +"!";
    }

    /**
     *
     * @param name - The name of the player.
     * @return the message to display in case of lost.
     */
    private static String getLoseMessage(String name) {
        return "Sorry"+ name +", but the dungeon beats you this time...";
    }
}
