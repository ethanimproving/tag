import org.improving.tag.FileSystemAdapter;
import org.improving.tag.Game;
import org.improving.tag.SaveGameFactory;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SaveGameFactoryTests {



    @Test
    public void save_should_preserve_location_name() throws IOException {
        // Arrange
        var io = new TestInputOutput();
        FileSystemAdapter fsa = mock(FileSystemAdapter.class);
        var target = new SaveGameFactory(fsa, io);
        var g = new Game(null, io, target);
        Class<Map<String, String>> dictClass =
            (Class<Map<String, String>>)(Class)Map.class;
        ArgumentCaptor<Map<String, String>> contentsCaptor =
                ArgumentCaptor.forClass(dictClass);
        when(fsa.saveToFile(any())).thenReturn("This is dumb");

        // Act
        String path = target.save(g);

        // Assert
        verify(fsa).saveToFile(contentsCaptor.capture());
        var loc = contentsCaptor.getValue().get("location");
        assertEquals("The Deathly Hallows", loc);

        assertNotNull(path);
        assertNotEquals("", path);
    }
}
