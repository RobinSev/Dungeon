package controller.graphical.dungeonview;

import javafx.scene.paint.Color;

/**
 * Represents the state of a cell in the graphical dungeon grid.
 * Each state is associated to a color.
 */
public enum CellState {

    EMPTY(Color.BLACK),
    ACTUAL(Color.BLUE),
    EXPLORED(Color.GREEN);

    private Color color;

    CellState(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
