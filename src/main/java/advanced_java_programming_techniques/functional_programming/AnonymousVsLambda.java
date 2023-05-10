package advanced_java_programming_techniques.functional_programming;

public final class AnonymousVsLambda {
    private final Runnable withLambda = () -> System.out.println("From lambda: " + this.getClass());
    private final Runnable withAnonymous = new Runnable() {
        @Override
        public void run() {
            System.out.println("From subclass: " + this.getClass());
        }
    };

    public static void main(String[] args) {
        AnonymousVsLambda example = new AnonymousVsLambda();
        example.withLambda.run();
        example.withAnonymous.run();

//        Runnable r = () -> System.out.println(this.getClass());
//        r.run();
    }
}
