package hw_5;

public enum Singleton3 {
    INSTANCE;

    public static Singleton3 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton3 singleton1 = Singleton3.getInstance();
        Singleton3 singleton2 = Singleton3.getInstance();

        System.out.println(singleton1 == singleton2);
    }
}
