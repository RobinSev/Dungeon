package model.dungeon.rooms.traps;

import model.characters.playables.PersonalizedPlayer;
import org.junit.jupiter.api.Test;
import model.characters.Character;

import static org.junit.Assert.*;

public class TrapTest {

    @Test
    public void testTriggeredBy() {
        Trap trap = new PersonalizedTrap(10);
        Character target = new PersonalizedPlayer("", 15, 15);

        trap.triggeredBy(target);
        assertEquals(5, target.getLife());
    }
}
