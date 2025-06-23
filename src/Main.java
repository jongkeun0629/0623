@FunctionalInterface
interface Greeting {
    void sayHello(String name);

//    void anotherMethod();
}

public class Main {
    public static void main(String[] args) {
        Greeting greeting = (name) -> System.out.println("Hello, " + name + "!");
        greeting.sayHello("Alice");
    }
}