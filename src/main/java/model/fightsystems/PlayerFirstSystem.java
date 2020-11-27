package model.fightsystems;

import model.characters.Character;

import java.util.List;

public class PlayerFirstSystem extends AbstractFightSystem {


    @Override
    protected List<Character> defineTurnOrder(Character player, Character enemy) {
        return super.addInOrder(player, enemy);
    }

    @Override
    protected boolean isDefeated(Character character) {
        return character.isDead();
    }

    @Override
    protected void executeAction(Character character, Character enemy) {
        character.attack(enemy);
    }

    @Override
    public String toString() { return "Player attack first"; }
}
