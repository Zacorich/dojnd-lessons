package advanced_java_programming_techniques.reflection.custom_classloader;

public interface UnitTest {
    default void beforeEachTest() {}
    default void afterEachTest() {}
}
