import org.improving.tag.commands.CountCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountCommandTests {

    // Escape method scope
    CountCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {
        // Arrange
        io = new TestInputOutput();
        target = new CountCommand(io);
    }

    @Test
    public void execute_should_return_count() {
        // Act
        target.execute(null, null);

        // Assert
        assertEquals("You have called the count command 1 time", io.lastText );
    }

    @Test
    public void execute_should_return_multiple_counts() {
        // Act
        target.execute(null, null);
        target.execute(null, null);
        target.execute(null, null);

        // Assert
        assertEquals("You have called the count command 3 times", io.lastText );
    }

    @Test
    public void isValid_should_be_true_when_input_is_count() {

        // Act
        var result = target.isValid("count", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_count_with_spaces() {

        // Act
        var result = target.isValid("   count   ", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_count_with_caps() {

        // Act
        var result = target.isValid("Count", null);

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