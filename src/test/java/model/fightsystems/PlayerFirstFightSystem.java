package model.fightsystems;

import model.characters.Character;
import model.characters.enemies.PersonalizedEnemy;
import model.characters.playables.PersonalizedPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class PlayerFirstFightSystem {

    @Test
    public void testFight() {
        Character player = new PersonalizedPlayer("", 20, 5);
        Character enemy = new PersonalizedEnemy("", 20, 5);
        FightSystem fightSystem = new PlayerFirstSystem();

        assertTrue(fightSystem.fight(player, enemy));
        assertEquals(5, player.getLife());
        assertEquals(0, enemy.getLife());
        assertTrue(enemy.isDead());
        assertFalse(player.isDead());


        enemy.updateLife(20);
        player.updateLife(10); //set the player life at 15;

        assertFalse(fightSystem.fight(player, enemy));
        assertEquals(5, enemy.getLife());
        assertTrue(player.isDead());
        assertFalse(enemy.isDead());
    }
}
