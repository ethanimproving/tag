import org.improving.tag.Game;
import org.improving.tag.Player;
import org.improving.tag.SpringContext;
import org.improving.tag.commands.SetNameCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class SetNameCommandTests {

    // Escape method scope
    SetNameCommand target;
    TestInputOutput io;
    Game game;

    @BeforeEach
    public void arrange() {
        // Arrange
        io = new TestInputOutput();
        target = new SetNameCommand(io);
        game = mock(Game.class);

        Player player = new Player();
        player.setName("@set name=Ethan");
        player.setHitPoints(50);

        when(game.getPlayer()).thenReturn(player);
    }

    @Test
    public void execute_should_set_name() {
        // Act
        target.execute("@set name=Ethan", game);


        // Assert
        verify(game, times(2)).getPlayer();
        assertEquals("Your name is now Ethan.",  io.lastText);
    }

    @Test
    public void isValid_should_be_true_when_input_is_set() {

        // Act
        var result = target.isValid("@set name=Ethan", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar() {

        // Act
        var result = target.isValid("foobar", null);

        // Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_null() {

        // Act
        var result = target.isValid(null, null);

        // Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_set_with_caps() {

        // Act
        var result = target.isValid("@Set Name=Ethan", null);

        // Assert
        assertTrue(result);
    }

}
