import org.improving.tag.Game;
import org.improving.tag.SpringContext;
import org.improving.tag.commands.SetNameCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SetNameCommandTests {

    // Escape method scope
    SetNameCommand target;
    TestInputOutput io;
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(SpringContext.class);

    Game game = context.getBean(Game.class);

    @BeforeEach
    public void arrange() {
        // Arrange
        target = new SetNameCommand();
    }

    @Test
    public void execute_should_set_name() {
        // Act
        target.execute("@set name=Ethan", game);

        // Assert
        assertEquals("Ethan",  game.getPlayer().getName());
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
        var result = target.isValid("@Set name=Ethan", null);

        // Assert
        assertTrue(result);
    }

}
