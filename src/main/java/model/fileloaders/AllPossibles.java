package model.fileloaders;

import model.fightsystems.FightSystem;
import model.items.Item;
import model.characters.Character;
import model.dungeon.rooms.traps.Trap;
import model.dungeon.rooms.treasures.Treasure;

import java.util.List;

public class AllPossibles {

    public static List<Item> possibleItems = ItemsLoader.load();
    public static List<Character> possibleEnemies = EnemiesLoader.load();
    public static List<Character> possiblePlayables = PlayablesLoader.load();
    public static List<Treasure> possibleTreasures = TreasuresLoader.load();
    public static List<Trap> possibleTraps = TrapsLoader.load();
    public static List<FightSystem> possibleFightSystems = FightSystemLoader.load();

    /**
     * Reset all the possible elements found in game to their default values, which is the content of each file listing
     * those possibles elements.
     */
    public static void resetAllPossibles() {
        possibleItems = ItemsLoader.load();
        possibleEnemies = EnemiesLoader.load();
        possiblePlayables = PlayablesLoader.load();
        possibleTreasures = TreasuresLoader.load();
        possibleTraps = TrapsLoader.load();
        possibleFightSystems = FightSystemLoader.load();
    }
}
