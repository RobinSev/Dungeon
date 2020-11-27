package model.dungeon.rooms.traps;
import model.characters.Character;

public interface Trap {

    /**
     * Reduce the life of the character that triggered the trap.
     * @param character the charactère that triggered the trap.
     */
    void triggeredBy(Character character);

    boolean wasTriggered();
}
