package narrakos.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

public class ResourceReader {

    public static List<String> getLines(String resourceFilePath) {
        URL resource = ResourceReader.class.getClassLoader().getResource(resourceFilePath);
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(resource.getFile()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return reader.lines().toList();
    }
}
