package model.dungeon.rooms.traps;

public class DangerousTrap extends AbstractTrap {
    private static final int DAMAGES_DONE = 10;

    public DangerousTrap() {
        super(DAMAGES_DONE);
    }
}
