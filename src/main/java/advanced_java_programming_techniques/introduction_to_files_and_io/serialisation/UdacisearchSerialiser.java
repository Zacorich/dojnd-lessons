package advanced_java_programming_techniques.introduction_to_files_and_io.serialisation;

import advanced_java_programming_techniques.functional_programming.client_store.UdacisearchClient;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

public class UdacisearchSerialiser {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: Main [file path]");
            return;
        }

        UdacisearchClient client =
                new UdacisearchClient(
                        "CatFacts LLC",
                        17,
                        8000,
                        5,
                        Instant.now(),
                        Duration.ofDays(180),
                        List.of(ZoneId.of("America/Los_Angeles")),
                        "555 Meowmers Ln, Riverside, CA 92501");

        Path outputPath = Path.of(args[0]);

        // TODO: Write the "client" variable to the "outputPath", using a ObjectOutputStream. Then,
        //       read it back and deserialize it using a ObjectInputStream.
        UdacisearchClient deserialized = client;
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(outputPath))) {
            oos.writeObject(client);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(outputPath))) {
            deserialized = (UdacisearchClient)ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(deserialized);


        //serialise and read to/from JSON file
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        try {
            om.writeValue(outputPath.toFile(), client);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            deserialized = om.readValue(outputPath.toFile(), UdacisearchClient.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(deserialized);

    }
}
