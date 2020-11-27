package controller.graphical.bagview;

import controller.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import model.items.Item;

/**
 * This class is a sub-controller in charge of the list of items of the GUI.
 */
public class BagController {


    private ViewModel viewModel;

    /**
     * The observable list displayed into the GUI.
     */
    private ListView<Item> bag;

    /**
     * The list of the items to display.
     */

    public BagController(ListView<Item> bag, ViewModel viewModel) {
        this.viewModel = viewModel;
        this.bag = bag;
        this.bag.setCellFactory(
                item -> new GraphicalItem(viewModel));
        update();
    }

    /**
     * Updates the listView by reloading the listView with
     * the player's bag's items.
     */
    public void update() {
        ObservableList<Item> items =
                FXCollections.observableArrayList(viewModel.getPlayer().getBag().getItems());
        bag.setItems(items);
    }

}
