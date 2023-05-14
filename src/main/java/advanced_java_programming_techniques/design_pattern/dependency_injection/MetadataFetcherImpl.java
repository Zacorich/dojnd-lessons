package advanced_java_programming_techniques.design_pattern.dependency_injection;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;

final class MetadataFetcherImpl implements MetadataFetcher {
    @Override
    public Instant getLastModifiedTime(Path path) throws IOException {
        BasicFileAttributes attributes =
                Files.readAttributes(path, BasicFileAttributes.class);
        return attributes.lastModifiedTime().toInstant();
    }
}

