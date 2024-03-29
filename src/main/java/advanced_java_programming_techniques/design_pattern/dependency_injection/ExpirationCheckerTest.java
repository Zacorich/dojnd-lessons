package advanced_java_programming_techniques.design_pattern.dependency_injection;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.nio.file.Path;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExpirationCheckerTest extends AbstractModule {

    public static void main(String[] args) {

        FakeClock fakeClock = new FakeClock();
        Map<Path, Instant> fakeModifiedTimes = new HashMap<>();
        FakeMetadataFetcher fakeMetadataFetcher = new FakeMetadataFetcher(fakeModifiedTimes);

        Path expired = Path.of("/test/expired");
        Path notExpired = Path.of("/test/not-expired");
        fakeModifiedTimes.put(expired, fakeClock.instant().minus(Duration.ofDays(31)));
        fakeModifiedTimes.put(notExpired, fakeClock.instant().minus(Duration.ofDays(27)));

        // TODO: Change this code to create an ExpirationChecker using the FakeClock and
        //       FakeMetadataFetcher.
        Injector injector = Guice.createInjector(
                b -> b.bind(Clock.class).toInstance(fakeClock),
                b -> b.bind(MetadataFetcher.class).toInstance(fakeMetadataFetcher));
        ExpirationChecker checker = injector.getInstance(ExpirationChecker.class);

        List<Path> expiredFiles =
                checker.getExpiredFiles(List.of(expired, notExpired), Duration.ofDays(30));

        assert expiredFiles.equals(List.of(expired));
    }
}

