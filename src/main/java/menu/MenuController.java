package menu;

import controller.ViewController.*;
import view.GraphicalView;
import view.Popup;
import view.TextualView;

import model.Game;
import model.characters.Character;
import model.fightsystems.FightSystem;

/**
 * This class is the controller of the menu.
 * Its only task consists in launch the game according
 * to the information provided by the user or show errors
 * if one or more of these information are not considered as valid.
 */
public class MenuController {

    /**
     * The game.view of the menu, containing the FXML components.
     */
    private MenuView view;

    public MenuController(MenuView view) {
        this.view = view;
    }

    /**
     * Creates a new game linked with the approriate
     * user interface according to the information provided in the menu.
     * The game is not started if one or more information are not correct.
     *
     * The case "TEXTUAL" is voluntarily left blank to show that it is possible
     * to code a textual interface to interact with the game model.
     *
     * @param mode - the selected mode for the textual interface.
     * @param name - the entered for the player
     * @param fightSystem - the selected fight system
     * @param selectedPlayer - the selected type of player.
     * @throws Exception
     */
    public void launchGame(Mode mode, String name, FightSystem fightSystem, Character selectedPlayer)
            throws Exception {
        if (!isValidName(name)) {
            Popup.showError("Not a valid name.");
            return;
        }
        Character player = getPlayerFromName(name, selectedPlayer);
        switch (mode.toString()) {
            case "TEXTUAL": return;
            case "GRAPHICAL":
                startGraphicalGame(new Game(player, fightSystem));
                break;
        }
        view.close();
    }

    /**
     * Returns, as a Character, an instance of the class
     * selected by the user, built with the entered name.
     * If the instantiation fails, this method throws the
     * corresponding exception and return null.
     *
     * @param name - The name of the returned player
     * @param selectedPlayer - The instance of the selected class.
     * @return an instance of the the selected player class.
     */
    private Character getPlayerFromName(String name, Character selectedPlayer) {
        Character player = null;
        try {
            player = selectedPlayer.getClass().getConstructor(String.class).newInstance(name);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return player;
    }

    /**
     * Checks is the entered name is valid.
     * In other words, returns True if the name
     * is no longer than 10 letters and only contains letters,
     * numbers, or signs '-' and '_'
     *
     * @param name - the string to check.
     * @return true if the specifed name is valid.
     */
    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z0-9-_]{1,10}");
    }

    /**
     * Starts a game in a textual mode. This function is not used
     * yet but was implemented to let the opportunity to code this
     * functionnality.
     */
    private void startTextualGame(Game game) throws Exception {
        TextualView textualView = new TextualView(game);
        textualView.start();
    }

    /**
     * Starts the game in a graphical mode.
     * Precisely, it starts a graphical game.view linked to the specified
     * Game class.
     *
     * @param game - the game to link with the game.view.
     * @throws Exception
     */
    private void startGraphicalGame(Game game) throws Exception {
        GraphicalView graphicalView = new GraphicalView(game);
        graphicalView.start();
    }
}
