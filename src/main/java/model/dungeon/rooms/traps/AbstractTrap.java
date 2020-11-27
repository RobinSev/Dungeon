package model.dungeon.rooms.traps;
import model.characters.Character;

public abstract class AbstractTrap implements Trap {
    protected int damagesDone;
    protected boolean wasTriggered;

    protected AbstractTrap(int damagesDone) {
        this.wasTriggered = false;
        this.damagesDone = damagesDone;
    }

    /**
     * Reduce the life of the character that triggered the trap.
     * @param character the charactère that triggered the trap.
     */
    public void triggeredBy(Character character) {
        if(!wasTriggered) {
            character.updateLife(- damagesDone);
            wasTriggered = true;
        }
    }

    @Override
    public boolean wasTriggered() { return wasTriggered; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractTrap)) return false;
        AbstractTrap that = (AbstractTrap) o;
        return damagesDone == that.damagesDone;
    }

}
