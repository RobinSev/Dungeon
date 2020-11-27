package model.fightsystems;

import java.util.List;
import model.characters.Character;

public class MonsterFirstSystem extends AbstractFightSystem {

    @Override
    protected List<Character> defineTurnOrder(Character player, Character enemy) {
        return super.addInOrder(enemy, player);
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
    public String toString() { return "Monster attack first"; }
}
