package org.improving.tag;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FileSystemAdapter {

    public String saveToFile(Map<String, String> contents) throws IOException {
        var file = File.createTempFile("saveGame", "");

        try(var writer = new FileWriter(file)) {
            for (var pair : contents.entrySet()) {
                writer.append(pair.getKey() + "|" + pair.getValue());
            }
        }

        return file.getAbsolutePath();
    }

    public Map<String, String> loadFile(String path) throws IOException {
        // Create an empty hash map to store our save data.
        Map<String, String> properties = new HashMap<>();

        // Read all lines from the save file.
        List<String> contents =  Files.readAllLines(Path.of(path));

        // For each line in save file, store the left side of the key and the right side as the value.
        for (String line : contents) {
            String[] temp = line.split("\\|");
            properties.put(temp[0], temp[1]);
        }

        return properties;
    }
}
