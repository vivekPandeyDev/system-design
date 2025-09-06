## Liskov Substitution Principle (LSP)

**Definition:** Subtypes must be substitutable for their base types without affecting program correctness.
- A subclass should be able to replace its parent class without altering the expected behavior.

**Example:**

```java
// Base class
class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

// Subclass that respects LSP
class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow flying...");
    }
}

// Subclass that violates LSP
class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly!");
    }
}

public class LSPDemo {
    public static void makeBirdFly(Bird bird) {
        bird.fly(); // Should work for all Birds
    }

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird ostrich = new Ostrich();

        makeBirdFly(sparrow);   // Works fine
        makeBirdFly(ostrich);   // Violates LSP: throws exception
    }
}
