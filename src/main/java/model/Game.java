package model;

import model.dungeon.Coordinates;
import model.dungeon.rooms.doors.Direction;
import model.dungeon.rooms.treasures.Treasure;
import model.exceptions.NotAUsableItemException;
import model.fightsystems.FightSystem;
import model.dungeon.rooms.Room;
import model.dungeon.Dungeon;
import model.characters.Character;
import model.items.Item;
import model.moves.Move;
import model.victoryconditions.RelevantProgress;
import model.victoryconditions.VictoryCondition;
import model.victoryconditions.VictoryForRoomExplored;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Character player;
    private FightSystem fightSystem;
    private Dungeon dungeon;
    private List<VictoryCondition> victoryConditions;
    private RelevantProgress relevantProgress;

    public Game(Character player, FightSystem fightSystem) {
        this.player = player;
        this.fightSystem = fightSystem;
        relevantProgress = new RelevantProgress(player.getBag());
        this.dungeon = new Dungeon();
        this.victoryConditions = new ArrayList<>();
        victoryConditions.add(new VictoryForRoomExplored());
    }

    public int getDungeonWidth() { return Dungeon.WIDTH; }
    public int getDungeonHeight() { return Dungeon.HEIGHT; }
    public Room getCurrentRoom() { return dungeon.getCurrentRoom(); }
    public Character getPlayer() { return player; }
    public Coordinates getPlayerPosition() { return dungeon.getPlayerPosition(); }
    public Direction getPlayerOrientation() { return dungeon.getPlayerOrientation(); }

    public boolean useItem(Item item, Character target) throws NotAUsableItemException {
        return player.use(item, target);
    }

    public void lootTreasure(Treasure treasure) { treasure.transferLoot(player); }

    /**
     * Check if all the victory conditions are met.
     * @return {@code true} if all the victory conditions are met, {@code false} otherwise.
     */
    public boolean isWon() {
        for(VictoryCondition victoryCondition : victoryConditions)
            if(!victoryCondition.test(relevantProgress)) return false;
        return true;
    }

    public boolean isLost() {
        return player.isDead();
    }

    /**
     * Handle the movement of the player in the dungeon. Return the destination room or null if there was no door in
     * this direction.
     *
     * @param move the move the player made.
     * @return the destination room, of null if there was no door in this direction.
     */
    public Room handleMove(Move move) {
        Room newRoom = dungeon.handleMove(move, relevantProgress);
        return newRoom;
    }

    /**
     * Handle the fight between the player and an enemy.
     * @param enemy the enemy attacking the player.
     * @return {@code true} if the player survived the fight, {@code false} otherwise.
     */
    public boolean fight(Character enemy) {
        boolean playerSurvived = fightSystem.fight(player, enemy);
        if(playerSurvived) relevantProgress.incrementNbEnemiesKilled();
        return playerSurvived;
    }
}
