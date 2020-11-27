package controller.graphical.bagview;

import controller.ViewModel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import model.items.Item;

/**
 * Describes the way to render an item into the ListView
 * representation of the bag.
 */
public class GraphicalItem extends ListCell<Item> {

    /**
     * The Label containing the description
     * of the Item.
     */
    private Label description;
    /**
     * The button clicked by the user to use the item.
     */
    private Button useItemButton;
    /**
     * The container of the JavaFX Components of this cell.
     */
    private GridPane container;

    private ViewModel viewModel;

    public GraphicalItem(ViewModel viewModel) {
        super();
        this.viewModel = viewModel;
        this.description = new Label();
        this.description.getStyleClass().add("item-description");
        this.useItemButton = new Button("use");
        this.useItemButton.getStyleClass().add("use-item-button");
        initializeContainer();
    }

    /**
     * Creates the container and adds the JFX Components into.
     */
    private void initializeContainer() {
        this.container = new GridPane();
        container.addRow(0);
        container.addColumn(0);
        container.addColumn(1);
        container.setHgap(10);
        container.add(description,1,0);
        container.add(useItemButton, 0, 0);
    }


    /**
     * Updates the cell related to the specified item.
     * First, it calls the updateItem of the superclass
     * Then, clears the text and graphics before
     * updating.
     *
     * @param item - The item to represent in the list game.view.
     * @param empty - True if the cell will appear as empty into the listView.
     */
    @Override
    protected void updateItem(Item item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        setGraphic(null);
        update(item, empty);
    }

    /**
     * Updates the cell related to the specified item.
     * If the item is null or the cell must be empty, the cell is not updated.
     * Otherwise, the cell is updated with the container initialized above.
     * @param item - the item this cell is related to.
     * @param empty - True if this cell must be empty.
     */
    private void update(Item item, boolean empty) {
        if (item == null || empty) return;
        setOnClickEvent(item);
        setDescription(item);
        setGraphic(container);
    }

    /**
     * Sets the event that handle the click on the use button.
     * @param item - the item related to the cell.
     */
    private void setOnClickEvent(Item item) {
        useItemButton.setOnAction(e -> viewModel.use(item, viewModel.getPlayer()));
    }

    /**
     * Sets the description to display.
     *
     * @param item - the item to describe.
     */
    private void setDescription(Item item) {
        description.setText(item.getName() + "\n" + item.getDescription());
    }

}
