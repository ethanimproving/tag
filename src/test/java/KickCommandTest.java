import org.improving.tag.commands.KickCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KickCommandTest {
    // Escape method scope
    KickCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {
        // Arrange
        io = new TestInputOutput();
        target = new KickCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {
        // Act
        target.execute(null, null);

        // Assert
        assertEquals("You have been ninja kicked! FATALITY.", io.lastText );
    }

    @Test
    public void isValid_should_be_true_when_input_is_kick() {

        // Act
        var result = target.isValid("kick", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_kick_with_spaces() {

        // Act
        var result = target.isValid("   kick   ", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_kick_with_caps() {

        // Act
        var result = target.isValid("KICK", null);

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
}