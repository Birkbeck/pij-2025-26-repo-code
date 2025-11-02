public class ThingySolution {
    private String name; // name: instance variable
    private final String id; // id: instance variable
    private static final int TWO = 2; // TWO: not an instance variable (it's static, so a class variable)

    // ThingySolution: not an instance method, but a constructor
    public ThingySolution(String n, String id) { // n, id: not instance variables (but constructor parameter variables)
        name = n;
        this.id = id;
    }

    // setName: instance method
    public void setName(String name) { // name: not an instance variable (it's a method parameter variable)
        this.name = name;
    }

    // sayHello1: not an instance method, but a class method (it's static)
    public static void sayHello1() {
        System.out.println("Hello!");
    }

    // sayHello2: instance method
    public void sayHello2() {
        System.out.println("Hello!");
    }
}
