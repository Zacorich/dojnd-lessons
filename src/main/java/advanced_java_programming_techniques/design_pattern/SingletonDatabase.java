package advanced_java_programming_techniques.design_pattern;

import java.util.Objects;

public final class SingletonDatabase {

    public enum SingletonEnum{
        JOHN,
        ANGEL,
        SAM;
        String value;
        public String getValue(){
            return this.value;
        }
        public void setValue(String value){
            this.value = value;
        }
    }
    private static SingletonDatabase database;

    private SingletonDatabase() {}

    public static SingletonDatabase getInstance() {
        if (database == null) {
            database = new SingletonDatabase();
            database.connect("/usr/local/data/users.db");
        }
        return database;
    }

    // Connects to the remote database.
    private void connect(String url) {
        Objects.requireNonNull(url);
    }

    public static void main(String[] args) {
        SingletonDatabase a = SingletonDatabase.getInstance();
        SingletonDatabase b = SingletonDatabase.getInstance();

        //enums are singletons; any class properties defined in enum won't be serialised but can used as singletons
        SingletonEnum.JOHN.setValue("test string");


        System.out.println(a == b);
    }
}