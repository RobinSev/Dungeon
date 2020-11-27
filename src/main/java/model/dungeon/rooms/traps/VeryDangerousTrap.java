package model.dungeon.rooms.traps;

public class VeryDangerousTrap extends AbstractTrap {
    private static final int DAMAGES_DONE = 20;

    public VeryDangerousTrap() {
        super(DAMAGES_DONE);
    }
}
