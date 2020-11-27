package controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import model.moves.BackwardMove;
import model.moves.ForwardMove;
import model.moves.LeftMove;
import model.moves.RightMove;

public abstract class ViewController implements Controller {

    protected ViewModel viewModel;

    public enum Mode {
        TEXTUAL, GRAPHICAL
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }


    public abstract void initialize(ViewModel viewModel);

    @Override
    public abstract void update();


    @Override
    public void setEventHandler(Scene scene) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, this::handleKeyPressed);
    }

    protected abstract void handleKeyPressed(KeyEvent event);
}
