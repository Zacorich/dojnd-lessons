package advanced_java_programming_techniques.introduction_to_files_and_io.words_merging;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class MakeShards {
    private static final int SHARD_SIZE = 100;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: MakeShards [input file] [output folder]");
            return;
        }

        Path input = Path.of(args[0]);
        Path outputFolder = input.resolve("..").resolve(args[1]).normalize();
        deleteShardsFolderWithFiles(outputFolder);
        Files.createDirectory(outputFolder);


        // TODO: Read the unsorted words from the "input" Path, line by line. Write the input words to
        //       many shard files. Each shard file should contain at most SHARD_SIZE words, in sorted
        //       order. All the words should be accounted for in the output shard files; you should not
        //       skip any words. Write the shard files in the newly created "outputFolder", using the
        //       getOutputFileName(int) method to name the individual shard files.

        BufferedReader br = Files.newBufferedReader(input, StandardCharsets.UTF_8);
        String line = null;
        List<String> singleShardWordsCollection = new LinkedList<>();
        int currentShardId = 0;
        while((line = br.readLine()) != null){
            System.out.println(line);
            singleShardWordsCollection.add(line);
            if(singleShardWordsCollection.size() == SHARD_SIZE){
                //sort words in current shard and write to file using buffered writer
                Path currentShardPath = outputFolder.resolve(getOutputFileName(currentShardId)).normalize();
                BufferedWriter bw =
                        Files.newBufferedWriter(currentShardPath,
                                StandardCharsets.UTF_8);
                int[] index = { 0 };
                singleShardWordsCollection.stream().sorted().collect(Collectors.toList()).forEach(l -> {
                    try {
                        //capture array with one element to store and increment current line index
                        index[0]++;
                        bw.write(l);
                        //write new line after all words except for the the last word
                        if(index[0] < SHARD_SIZE) {
                            bw.newLine();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                bw.close();

                //clear the set to be used for the next shard
                singleShardWordsCollection.clear();
                currentShardId++;
            }
        }
        deleteShardsFolderWithFiles(outputFolder);
    }

    private static void deleteShardsFolderWithFiles(Path outputFolder){
        try {
            Files.walk(outputFolder).forEach(f -> {
                try {
                    if(!Files.isDirectory(f)) {
                        Files.deleteIfExists(f);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            Files.delete(outputFolder);

        } catch (IOException e) {
            //throw new RuntimeException(e);
        }
    }

    private static String getOutputFileName(int shardNum) {
        return String.format("shard%02d.txt", shardNum);
    }
}
