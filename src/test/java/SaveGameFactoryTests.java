import org.improving.tag.FileSystemAdapter;
import org.improving.tag.Game;
import org.improving.tag.SaveGameFactory;
import org.improving.tag.WorldBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SaveGameFactoryTests {

    // Extrapolate scope for setup.
    private TestInputOutput testInputOutput;
    private FileSystemAdapter fsa;
    private SaveGameFactory target;
    private Game g;
    private WorldBuilder worldBuilder;

    public SaveGameFactoryTests(WorldBuilder worldBuilder) {
        this.worldBuilder = worldBuilder;
    }

    @BeforeEach
    public void setup() {
        var io = new TestInputOutput();
        FileSystemAdapter fsa = mock(FileSystemAdapter.class);
        var target = new SaveGameFactory(fsa, io);
        var g = new Game(null, io, target, worldBuilder);
    }


    @Test
    public void save_should_preserve_location_name() throws IOException {
        // Arrange
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

    @Test
    public void load_should_load_save_file() throws IOException {
        // Arrange
        String path = "thisisafakepath";

        when(fsa.loadFile(path)).thenReturn(Map.of("location", "The Amazon"));

        // Act
        target.load(path, g);

        // Assert
        assertEquals("The Amazon", g.getPlayer().getLocation().getName());
    }
}
