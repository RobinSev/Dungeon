package model.fightsystems;

import model.characters.Character;

public interface FightSystem {
    boolean fight(Character player, Character enemy);
}
