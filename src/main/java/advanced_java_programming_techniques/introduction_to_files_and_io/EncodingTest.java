package advanced_java_programming_techniques.introduction_to_files_and_io;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class EncodingTest {
    public static void main(String[] args) throws IOException {
        //should create 12 bytes file
        try (Writer writer = Files.newBufferedWriter(Path.of("test_utf8.txt"),
                StandardCharsets.UTF_8)) {
            writer.write("hello, world");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //should create 26 bytes files
        try (Writer writer = Files.newBufferedWriter(Path.of("test_utf16.txt"),
                StandardCharsets.UTF_16)) {
            writer.write("hello, world");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Files.delete(Path.of("test_utf8.txt"));
        Files.delete(Path.of("test_utf16.txt"));

        //further read on Unicode:
        //https://www.unicode.org/versions/Unicode15.0.0/
    }
}
