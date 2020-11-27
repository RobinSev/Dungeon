package model.victoryconditions;

import model.characters.Bag;

public class RelevantProgress {

    private int nbOfEnemiesKilled;
    private int nbOfRoomsExplored;
    private Bag itemsPossessed;

    public RelevantProgress(Bag bag) {
        nbOfEnemiesKilled = 0;
        nbOfRoomsExplored = 0;
        itemsPossessed = bag;
    }

    public int getNbOfEnemiesKilled() {
        return nbOfEnemiesKilled;
    }

    public void incrementNbEnemiesKilled() { nbOfEnemiesKilled++; }

    public int getNbOfRoomsExplored() { return nbOfRoomsExplored; }

    public void incrementNbRoomsExplored() { nbOfRoomsExplored++; }

    public void resetProgress(Bag newBag) {
        nbOfEnemiesKilled = 0;
        nbOfRoomsExplored = 0;
        itemsPossessed = newBag;
    }

    public Bag getItemsPossessed() { return itemsPossessed; }
}
