# SOLID Design Principles | Complete Guide with Code Examples


---

---

## 1. Single Responsibility Principle (SRP)

**Definition**: A class should have only one reason to change.

❌ **Bad Example** – One class doing too much:
```java
class Invoice {
    void calculateTotal() { /* logic */ }
    void printInvoice() { /* printing logic */ }
    void saveToDatabase() { /* persistence logic */ }
}
```

✅ **Good Example** – Split responsibilities:
```java
class Invoice {
    void calculateTotal() { /* logic */ }
}

class InvoicePrinter {
    void print(Invoice invoice) { /* printing logic */ }
}

class InvoiceRepository {
    void save(Invoice invoice) { /* persistence logic */ }
}
```

**Single Responsibility Principle (SRP):** A class should have only one reason to change; it can have multiple methods, but all must serve a single responsibility.

**Delegation:** Classes implement their own functionality and delegate unrelated tasks.

**Example Responsibilities:**
- `Product` → holds product data.
- `ShoppingCart` → manages products / calculate total 
- `ShoppingCartPrinter` → prints the invoice.
- `ShoppingCartStorage` → saves cart details to DB/log.

**Benefits:** Clear structure, easier testing, maintainability, and flexible code.
---

## 2. Open/Closed Principle (OCP)

**Definition**: Classes should be open for extension but closed for modification.

❌ **Bad Example** – Modifying code whenever a new type is added:
```java
class PaymentProcessor {
    void process(String type) {
        if (type.equals("CreditCard")) { /* logic */ }
        else if (type.equals("Paypal")) { /* logic */ }
    }
}
```

✅ **Good Example** – Use abstraction:
```java
interface Payment {
    void pay();
}

class CreditCardPayment implements Payment {
    public void pay() { System.out.println("Paying with Credit Card"); }
}

class PaypalPayment implements Payment {
    public void pay() { System.out.println("Paying with Paypal"); }
}

class PaymentProcessor {
    void process(Payment payment) {
        payment.pay();
    }
}
```

---

## 3. Liskov Substitution Principle (LSP)

**Definition**: Subtypes must be substitutable for their base types.

❌ **Bad Example** – Violating LSP:
```java
class Bird {
    void fly() {}
}

class Ostrich extends Bird {
    @Override
    void fly() { throw new UnsupportedOperationException("Ostriches can't fly!"); }
}
```

✅ **Good Example** – Correct hierarchy:
```java
interface Bird {}
interface FlyingBird extends Bird { void fly(); }
interface NonFlyingBird extends Bird {}

class Sparrow implements FlyingBird {
    public void fly() { System.out.println("Sparrow is flying"); }
}

class Ostrich implements NonFlyingBird {
    // No fly() method -> no broken expectations
}
```

---

## 4. Interface Segregation Principle (ISP)

**Definition**: Clients should not be forced to depend on methods they do not use.

❌ **Bad Example** – Fat interface:
```java
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() {}
    public void eat() { /* meaningless for robot */ }
}
```

✅ **Good Example** – Split interfaces:
```java
interface Workable { void work(); }
interface Eatable { void eat(); }

class Human implements Workable, Eatable {
    public void work() {}
    public void eat() {}
}

class Robot implements Workable {
    public void work() {}
}
```

---

## 5. Dependency Inversion Principle (DIP)

**Definition**: High-level modules should not depend on low-level modules, but on abstractions.

❌ **Bad Example** – Tight coupling:
```java
class MySQLDatabase {
    void connect() {}
}

class UserRepository {
    private MySQLDatabase db = new MySQLDatabase(); // direct dependency
}
```

✅ **Good Example** – Depend on abstraction:
```java
interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    public void connect() { System.out.println("MySQL connected"); }
}

class UserRepository {
    private Database db;
    public UserRepository(Database db) {
        this.db = db;
    }
}
```

---

## 📊 Summary Table

| Principle | Meaning | Benefit |
|-----------|---------|---------|
| **SRP** | One class, one reason to change | Easier maintenance & clarity |
| **OCP** | Extend behavior without modifying code | Stability & adaptability |
| **LSP** | Subclass interchangeable with base class | Reliable inheritance |
| **ISP** | Avoid forcing unused methods | Modular & decoupled design |
| **DIP** | Depend on abstractions | Flexible & testable architecture |