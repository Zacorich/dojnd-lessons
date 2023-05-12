package advanced_java_programming_techniques.introduction_to_files_and_io.words_merging;

import advanced_java_programming_techniques.design_pattern.MultiFileReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public final class MergeShards {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: MergeShards [input folder] [output file]");
            return;
        }

        List<Path> inputs = Files.walk(Path.of(args[0]), 1).skip(1).collect(Collectors.toList());
        if(inputs.size() == 0){
            return;
        }
        Path outputPath = Path.of(args[0]).resolve("..").resolve(args[1]).normalize();

        // TODO: Inside a try-finally block, create the List of BufferedReaders: one for each "input"
        //       Path. Without modifying the shard files, merge them together into a single text file
        //       whose location is specified by the "outputPath".
        //
        //       To do this, you should put words in a PriorityQueue<WordEntry>, but make sure the
        //       priority queue never contains more entries than there are input files. The whole point
        //       of doing a distributed merge sort is that there are too many words to fit into memory!
        //
        //       In the "finally" part of the try-finally block, make sure to close all the
        //       BufferedReaders.

        // TODO: Replace this try-finally with a try-with-resources. The "try" statement should create
        //       a MultiFileReader that is used in the "try" block to read from the files.

        try(MultiFileReader multiFileReader = new MultiFileReader(inputs)){
            PriorityQueue<WordEntry> words = new PriorityQueue<>();
            for (BufferedReader reader : multiFileReader.getReaders()) {
                String word = reader.readLine();
                if (word != null) {
                    words.add(new WordEntry(word, reader));
                }
            }

            try (Writer writer = Files.newBufferedWriter(outputPath)) {
                while (!words.isEmpty()) {
                    //poll() uses implicitly compareTo between WordEntry(s) to get next alphabetically sorted word
                    //from the queue
                    WordEntry entry = words.poll();
                    //write result of the current column of BufferedReader(s) comparison result into output file
                    writer.write(entry.word);
                    writer.write(System.lineSeparator());
                    //increment to next word in the BufferedReader
                    String word = entry.reader.readLine();
                    if (word != null) {
                        words.add(new WordEntry(word, entry.reader));
                    }
                }
            }
        }
    }

    private static final class WordEntry implements Comparable<WordEntry> {
        private final String word;
        private final BufferedReader reader;

        private WordEntry(String word, BufferedReader reader) {
            this.word = Objects.requireNonNull(word);
            this.reader = Objects.requireNonNull(reader);
        }

        @Override
        public int compareTo(WordEntry other) {
            return word.compareTo(other.word);
        }
    }
}

