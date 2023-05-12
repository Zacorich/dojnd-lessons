package advanced_java_programming_techniques.design_pattern;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MultiFileReader implements Closeable {

    private List<BufferedReader> readers;

    public MultiFileReader(List<Path> paths) {
        readers = new ArrayList<>(paths.size());
        for (Path input : paths) {
            try {
                readers.add(Files.newBufferedReader(input));
            } catch (IOException e) {
                try {
                    this.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                throw new RuntimeException(e);
            }
        }
    }

    public List<BufferedReader> getReaders() {
        return readers;
    }

    @Override
    public void close() throws IOException {
        readers.forEach(r -> {
            try {
                r.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
