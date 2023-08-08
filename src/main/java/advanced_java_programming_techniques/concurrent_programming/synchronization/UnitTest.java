package advanced_java_programming_techniques.concurrent_programming.synchronization;

public interface UnitTest {
    default void beforeEachTest() {}
    default void afterEachTest() {}
}
