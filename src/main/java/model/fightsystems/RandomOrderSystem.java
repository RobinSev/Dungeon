package model.fightsystems;

import java.util.List;
import java.util.Random;
import model.characters.Character;

public class RandomOrderSystem extends AbstractFightSystem {

    @Override
    protected List<Character> defineTurnOrder(Character player, Character enemy) {
        Random random = new Random();
        int firstAttacker = random.nextInt(2);
        return firstAttacker == 1 ? super.addInOrder(enemy, player) : super.addInOrder(player, enemy);
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
    public String toString() { return "Random turn order each fight"; }
}
