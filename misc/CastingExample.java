class Animal {
    void makeSound() {
        System.out.println("Generic animal sound");
    }
}
class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark! Bark!");
    }
    void fetch() {
        System.out.println("Fetching the ball!");
    }
}
public class CastingExample1 {
    public static void main(String[] args) {
        Dog animal = new Dog();

        /*
        animal.makeSound(); // Calls Dog's makeSound() method
        // Downcasting (Animal to Dog)
        Dog dog = (Dog) animal;
        dog.makeSound(); // Calls Dog's makeSound() method
        dog.fetch();     // Calls Dog's fetch() method
        */
    }
}
