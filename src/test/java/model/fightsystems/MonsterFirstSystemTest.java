package model.fightsystems;

import model.characters.enemies.PersonalizedEnemy;
import model.characters.playables.PersonalizedPlayer;
import org.junit.jupiter.api.Test;
import model.characters.Character;

import static org.junit.Assert.*;

public class MonsterFirstSystemTest {

    @Test
    public void testFight() {
        Character player = new PersonalizedPlayer("", 20, 5);
        Character enemy = new PersonalizedEnemy("", 20, 5);
        FightSystem fightSystem = new MonsterFirstSystem();

        assertFalse(fightSystem.fight(player, enemy));
        assertEquals(5, enemy.getLife());
        assertEquals(0, player.getLife());
        assertTrue(player.isDead());
        assertFalse(enemy.isDead());


        player.updateLife(20);
        enemy.updateLife(10); //set the enemy life at 15;

        assertTrue(fightSystem.fight(player, enemy));
        assertEquals(5, player.getLife());
        assertTrue(enemy.isDead());
        assertFalse(player.isDead());
    }

}
