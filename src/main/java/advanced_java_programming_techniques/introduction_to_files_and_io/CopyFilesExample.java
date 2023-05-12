package advanced_java_programming_techniques.introduction_to_files_and_io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyFilesExample {
    public static void main(String[] args) throws IOException {
        //using streams
        InputStream io = Files.newInputStream(Path.of(args[0]));
        OutputStream os = Files.newOutputStream(Path.of(args[1]));

        byte[] data = new byte[10];
        while(io.read(data) != -1){
            os.write(data);
        }
        io.close();
        os.close();

        //using transferTo method
        io.transferTo(os);
        io.close();
        os.close();

        //using Files API
        Files.copy(Path.of(args[0]), Path.of(args[1]));
    }
}
