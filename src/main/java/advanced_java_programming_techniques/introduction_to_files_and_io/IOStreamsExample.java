package advanced_java_programming_techniques.introduction_to_files_and_io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class IOStreamsExample {
    public static void main(String[] args) {
        //read file low level
        InputStream in = null;
        try {
            in = Files.newInputStream(Path.of("C:\\Users\\Shadow\\github-repos\\dojnd-lessons\\build.gradle"), StandardOpenOption.READ);

            byte[] data = new byte[10];
            int reads = 0;
            while (in.read(data) != -1) {
                System.out.println(reads+ ": " + data);
                reads++;
            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //write file low level
        try {
            OutputStream out = Files.newOutputStream(Path.of("test"));
            out.write("Hello".getBytes());
            out.close();
            Files.delete(Path.of("test"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
