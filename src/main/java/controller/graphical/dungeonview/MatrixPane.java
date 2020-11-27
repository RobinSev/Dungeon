package controller.graphical.dungeonview;

import controller.ViewModel;
import javafx.scene.layout.GridPane;
import model.dungeon.Coordinates;

/**
 * This class represents the game.view of the labyrinth as a matrix.
 * It consists in a matrix with the same dimensions of the dungeon,
 * filled with cells whose colors change according to their states.
 * Initially, the cells are in the UNEXPLORED state, so they are displayed as black.
 * When the user comes into a room, the corresponding cell switches to the ACTUAL state.
 * and so becomes blue.
 * After leaving, the cell becomes EXPLORED (green).
 */
public class MatrixPane extends GridPane {

    private ViewModel viewModel;

    private int nbRows, nbColumns;

    /**
     * Dimensions of a cell into the grid.
     */
    private double cellWidth, cellHeight;

    /**
     * The cell corresponding to the current position of the player.
     */
    private Cell currentCell;


    public void initialize(ViewModel viewModel) {
        this.viewModel = viewModel;
        setNbRows(viewModel.getDungeonHeight());
        setNbColumns(viewModel.getDungeonWidth());
        computeCellDimensions();
        fillWithCells();
        update();
    }

    /**
     * Computes the width and height of each cell
     * according to the dimensions of the dungeon and
     * the dimensions of the displayed matrix.
     */
    private void computeCellDimensions() {
        this.cellWidth = getPrefWidth() / nbColumns;
        this.cellHeight = getPrefHeight() / nbRows;
    }


    private void setNbColumns(int nbColumns) {
        this.nbColumns = nbColumns;
    }

    private void setNbRows(int nbRows) {
        this.nbRows = nbRows;
    }


    /**
     * Fills the matrix with cells.
     * Each coordinates contains one cell
     * that can take different color according to their states.
     */
    private void fillWithCells() {
        for (int row = 0; row < nbRows; row++) {
            for (int column = 0; column < nbColumns; column++) {
                add(new Cell(cellWidth, cellHeight), column, row);
            }
        }
    }

    /**
     * Updates the matrix.
     * More precisely, gets the current position of the player
     * and update the cell corresponding to this position.
     */
    public void update() {
        Coordinates currentPosition = viewModel.getPlayerPosition();
        int row = currentPosition.getAbscissa();
        int column = currentPosition.getOrdinate();
        updateCurrentCell(row, column);
    }

    /**
     * Returns the cell having the coordinates
     * (row, column) in the matrix.
     *
     * @param row - the row index of the cell.
     * @param column - the column index of the cell.
     * @return the cell of the matrix at the coordinates (row, column).
     */
    private Cell getCell(int row, int column) {
        return (Cell) getChildren().get(row * nbRows + column);
    }


    /**
     * Updates the current cell and its state.
     * Precisely, changes the state of the previous cell to explored
     * and sets the state of the current one as actual.
     *
     * @param row - the row index of the new current cell.
     * @param column - the column index of the new current cell.
     */
    private void updateCurrentCell(int row, int column) {
        if (currentCell != null)
            currentCell.setState(CellState.EXPLORED, viewModel.getPlayerOrientation());
        currentCell = getCell(row, column);
        currentCell.setState(CellState.ACTUAL, viewModel.getPlayerOrientation());
    }


}
