package model.items;

import model.characters.Character;
import model.characters.playables.PersonalizedPlayer;
import model.exceptions.NotAUsableItemException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.items.questobjects.RareMedallion;
import org.junit.jupiter.api.Test;

public class QuestObjectTest {

    @Test
    public void testUseOn() {
        Character user = new PersonalizedPlayer("test", 10, 10);
        Item medallion = new RareMedallion();

        Exception exception = assertThrows(NotAUsableItemException.class, () -> medallion.useOn(user));
        assertEquals("This is a quest item.", exception.getMessage());
    }
}
