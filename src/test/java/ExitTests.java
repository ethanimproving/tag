import org.improving.tag.Exit;
import org.improving.tag.Location;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExitTests {

    @Test
    public void toString_should_include_name() {
        // Arrange
        var target = new Exit("Door", new Location());

        // Act
        var result = target.toString();

        // Assert
        assertTrue(result.contains("Door"));

    }



    @Test
    public void equals_should_be_true_when_name_and_destination_match() {
        // Arrange
        var destination = new Location();
        var exit1 = new Exit("Door", destination);
        var exit2 = new Exit("Door", destination, "this", "is");
        // Act
        var result = exit1.equals(exit2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void equals_should_be_true_when_name_and_destination_match_of_course() {
        // Arrange
        var exit1 = new Exit("Door", new Location());
        var exit2 = new Exit("Door", new Location(), "this", "is");
        // Act
        var result = exit1.equals(exit2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void equals_should_be_false_when_compared_to_non_exit() {
        // Arrange
        var destination = new Location();
        var exit1 = new Exit("Door", destination);

        // Act
        var result = exit1.equals("Door");

        // Assert
        assertFalse(result);
    }




}
