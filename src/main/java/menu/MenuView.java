package menu;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import model.characters.Character;
import model.fightsystems.FightSystem;
import model.fileloaders.AllPossibles;
import controller.ViewController.*;


public class MenuView implements Initializable {

    /**
     * The text field where the user enters the name of the player.
     */
    @FXML private TextField nameField;
    /**
     * The label where the error message will be shown.
     */
    @FXML private Label emptyNameLabel;
    /**
     * The choiceBox provided to the user all the available type of
     * playable characters.
     */
    @FXML private ChoiceBox<Character> playerSelector;

    /**
     * The choiceBox provided to the user all the available fight systems
     */
    @FXML private ChoiceBox<FightSystem> fightSystemSelector;


    /**
     * The model for the starting menu.
     */
    private MenuController model;

    /**
     * The stage containing the menu.
     */
    private Stage stage;


    public MenuView() {
        model = new MenuController(this);
    }

    /**
     * Initializes the FXML components.
     * @param location - The location used to resolve relative paths
     *                 for the root object, or null if the location is not known.
     * @param resources - The resources used to localize the root object,
     *                  or null if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializePlayerSelector();
        initializeFightSystemSelector();
    }

    /**
     * Initializes the player selector with all the possibilities.
     * By default, the first added is selected.
     */
    private void initializePlayerSelector() {
        playerSelector.getItems().addAll(AllPossibles.possiblePlayables);
        playerSelector.getSelectionModel().selectFirst();
    }


    /**
     * Initializes the FightSystem selector by adding all the possible
     * choices to the choices box.
     * By default, the first added is selected.
     */
    private void initializeFightSystemSelector() {
        fightSystemSelector.getItems().addAll(AllPossibles.possibleFightSystems);
        fightSystemSelector.getSelectionModel().selectFirst();
    }

    /**
     * Sets the stage containing the game.view's scene.
     * @param stage - The stage to set.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }


    /**
     * The method called by clicking on the play button.
     * If the user entered a name, the game starts.
     * Otherwise, a message is shown to remember him to enter a name.
     * @throws Exception
     */
    @FXML
    private void playButtonAction() throws Exception {
        if (!hasAName())
            showEmptyNameErrorMessage();
        else {
            model.launchGame(
                    Mode.GRAPHICAL,
                    getPlayerName(),
                    getSelectedFightSystem(),
                    getSelectedPlayer());
        }
    }

    /**
     * Checks if the user entered a name.
     * The field is considered as blank if it is empty
     * or full of spaces.
     *
     * @return true if the user has entered a name.
     */
    private boolean hasAName() {
        return !getPlayerName().matches("( )*");
    }

    /**
     * Returns the content of the nameField property.
     * Precisely, it returns what the user entered as name
     * for the player.
     *
     * @return the content of the name field.
     */
    public String getPlayerName() {
        return nameField.getText();
    }

    public Character getSelectedPlayer() {
        return playerSelector.getValue();
    }

    public FightSystem getSelectedFightSystem() {
        return fightSystemSelector.getValue();
    }


    /**
     * Closes the game.view.
     */
    public void close() {
        stage.close();
    }

    /**
     * Shows the error message corresponding to an absence
     * of name in the corresponding textField.
     */
    private void showEmptyNameErrorMessage() {
        emptyNameLabel.setText("A name is required to continue.");
    }


    /**
     * Exits the program.
     * This function is called when the user clicks
     * on the "quit" button.
     */
    @FXML
    private void quitButtonAction() {
        System.exit(0);
    }


}
