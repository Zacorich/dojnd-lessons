package advanced_java_programming_techniques.introduction_to_files_and_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class BufferedReaderAndBufferedWriterExamples {
    public static void main(String[] args) throws IOException {
        BufferedReader br = Files.newBufferedReader(Path.of("build.gradle"), StandardCharsets.UTF_8);
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();

        BufferedWriter bw = Files.newBufferedWriter(Path.of("test"), StandardCharsets.UTF_8);
        bw.write("Hello\n");
        bw.write("Hello\n");
        bw.flush();
        bw.close();
        Files.delete(Path.of("test"));

    }
}
