public class Thingy {
    private String name;
    private final String id;
    private static final int TWO = 2;

    public Thingy(String n, String id) {
        name = n;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void sayHello1() {
        System.out.println("Hello!");
    }

    public void sayHello2() {
        System.out.println("Hello!");
    }
}
