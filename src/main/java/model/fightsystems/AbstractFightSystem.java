package model.fightsystems;

import java.util.List;
import model.characters.Character;
import model.characters.playables.Playable;

public abstract class AbstractFightSystem implements FightSystem {

    /**
     * Handle the fight between the player and an enemy.
     * @param player the played character.
     * @param enemy the enemy he is in fight with.
     * @return {@code true} if the player survived the fight, {@code false} otherwise.
     */
    public boolean fight(Character player, Character enemy) {
        List<Character> charactersOrdered = defineTurnOrder(player, enemy);
        Character firstAttacker = charactersOrdered.get(0);
        Character secondAttacker = charactersOrdered.get(1);
        while(true) {
            if(isDefeated(firstAttacker)) {
                return !(isThePlayer(firstAttacker));
            }
            executeAction(firstAttacker, secondAttacker);
            if(isDefeated(secondAttacker)) {
                return !(isThePlayer(secondAttacker));
            }
            executeAction(secondAttacker, firstAttacker);
        }
    }

    protected boolean isThePlayer(Character character) {
        return character instanceof Playable;
    }

    /**
     * Define the turn order of the fight depending on the options selected before the exploration.
     * @param player refers to the character played by the human player.
     * @param enemy refers to the enemy with whom the player is fighting.
     * @return a list containing the player and its enemy positioned at their turn.
     */
    protected abstract List<Character> defineTurnOrder(Character player, Character enemy);


    /**
     * Define the conditions making a character unable to keep fighting.
     * @param character the character to evaluate.
     * @return {@code true} if he is unable to keep fighting, {@code false} otherwise.
     */
    protected abstract boolean isDefeated(Character character);

    /**
     * Decide of the action a character will do at his turn.
     * @param character the character who has to act.
     * @param enemy the enemy selected to be the target for a potential attack.
     */
    protected abstract void executeAction(Character character, Character enemy);


    protected List<Character> addInOrder(Character first, Character second) {
        return List.of(first, second);
    }

    public abstract String toString();

}
