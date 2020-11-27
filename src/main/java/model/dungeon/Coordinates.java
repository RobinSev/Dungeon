package model.dungeon;

import model.dungeon.rooms.doors.Direction;

public class Coordinates {

    private int abscissa;
    private int ordinate;

    public Coordinates(int abscissa, int ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    public int getAbscissa() {
        return abscissa;
    }

    public int getOrdinate() {
        return ordinate;
    }

    public void setAbscissa(int abscissa) {
        this.abscissa = abscissa;
    }

    public void setOrdinate(int ordinate) {
        this.ordinate = ordinate;
    }

    public Coordinates getCoordinatesForDirection(Direction direction) {
        switch(direction) {
            case SOUTH: return new Coordinates(abscissa + 1, ordinate);
            case NORTH: return new Coordinates(abscissa - 1, ordinate);
            case WEST: return new Coordinates(abscissa, ordinate - 1);
            case EAST: return new Coordinates(abscissa, ordinate + 1);
            default: return null;
        }
    }
}
