package controller;

import javafx.scene.Scene;


public interface Controller {

    void setViewModel(ViewModel viewModel);
    void setEventHandler(Scene scene);

    void update();
}
