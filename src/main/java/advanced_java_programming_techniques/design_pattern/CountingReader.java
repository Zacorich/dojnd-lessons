package advanced_java_programming_techniques.design_pattern;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class CountingReader extends Reader {
    private int count = 0;

    private final Reader delegate;

    CountingReader(Reader deletate){
        this.delegate = Objects.requireNonNull(deletate);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        count++;
        return delegate.read(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        delegate.close();
    }


    public int getCount() {
        return count;
    }

    static String filePath = "C:\\Users\\Shadow\\github-repos\\dojnd-lessons" +
            "\\src\\main\\java\\advanced_java_programming_techniques" +
            "\\introduction_to_files_and_io\\words_merging\\unsorted.txt";

    public static void main(String[] args) throws Exception {
        try (CountingReader unbufferedReader = new CountingReader(new FileReader(filePath));
             CountingReader bufferedReader = new CountingReader(Files.newBufferedReader(Path.of(filePath)))
        ) {
            char[] data = new char[1];
            while (unbufferedReader.read(data) != -1);

            data = new char[100];
            while (bufferedReader.read(data) != -1);

            System.out.println("Calls to BufferedReader.read(): " + bufferedReader.getCount());
            System.out.println("Calls to FileReader.read(): " + unbufferedReader.getCount());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
