package advanced_java_programming_techniques.introduction_to_files_and_io;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderAndWriterExamples {
    public static void main(String[] args) throws IOException {
        //read file
        char[] data = new char[120];
        Reader reader = Files.newBufferedReader(Path.of("build.gradle"), StandardCharsets.UTF_8);
        while(reader.read(data) != -1){
            System.out.println(data);
        }
        reader.close();

        //write file
        Writer writer = Files.newBufferedWriter(Path.of("test"), StandardCharsets.UTF_8);
        writer.write("Hello");
        writer.close();

        Files.delete(Path.of("test"));
    }
}
