package advanced_java_programming_techniques.introduction_to_files_and_io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExamples {
    public static void main(String[] args) {
        Path p = Path.of(".");
        System.out.println("Path: " + p.toAbsolutePath());
        System.out.println("Path: " + p.toAbsolutePath().normalize());
        System.out.println("Path: " + p.toAbsolutePath().resolve("..").normalize());
        System.out.println("Path: " + p.toAbsolutePath().resolve("..").normalize().toUri());
        System.out.println("Path: " + p.toAbsolutePath().resolve("hello").normalize());
        System.out.println(Paths.get(p.toUri()).equals( p.toAbsolutePath()));
        //read following java docs:
        //https://docs.oracle.com/javase/10/docs/api/java/nio/file/Files.html
        //https://docs.oracle.com/javase/10/docs/api/java/nio/file/Path.html#resolve(java.lang.String)
        //https://docs.oracle.com/javase/10/docs/api/java/nio/file/Paths.html
        //https://docs.oracle.com/javase/10/docs/api/java/nio/file/StandardOpenOption.html
    }
}
