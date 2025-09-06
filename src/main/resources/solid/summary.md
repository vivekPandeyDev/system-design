# SOLID Design Principles | Complete Guide with Code Examples

---

## 📚 Key Principles

### 1. Single Responsibility Principle (SRP)
- **Definition**: A class should have only one reason to change.
- **Benefit**: Easier to maintain and understand.
- **Example**: Splitting a large class into focused, responsibility-specific classes.

### 2. Open/Closed Principle (OCP)
- **Definition**: Classes should be **open for extension** but **closed for modification**.
- **Benefit**: Add new features without breaking existing code.
- **Example**: Use inheritance or interfaces to extend behavior.

### 3. Liskov Substitution Principle (LSP)
- **Definition**: Subtypes must be substitutable for their base types.
- **Benefit**: Ensures reliable inheritance and polymorphism.
- **Example**: Subclasses should not break functionality when used in place of a base class.

*(Video mainly focuses on SRP, OCP, and LSP. Remaining two explained below for completeness.)*

### 4. Interface Segregation Principle (ISP)
- **Definition**: Clients should not be forced to depend on methods they do not use.
- **Benefit**: Promotes modular, decoupled interfaces.

### 5. Dependency Inversion Principle (DIP)
- **Definition**: Depend on **abstractions** rather than concrete implementations.
- **Benefit**: Improves flexibility, scalability, and testability.

---

## 🔑 Why SOLID Matters
- **Scalability & Maintenance**: Minimizes ripple effects from changes.
- **Code Quality**: Cleaner, modular, and easier to read.
- **Testability & Collaboration**: Easier to test and maintain in team projects.

---

## 📊 Summary Table

| Principle | Meaning | Benefit |
|-----------|---------|---------|
| **SRP** | One class, one reason to change | Easier maintenance & clarity |
| **OCP** | Extend behavior without modifying code | Stability & adaptability |
| **LSP** | Subclass interchangeable with base class | Reliable inheritance |
| **ISP** | Avoid forcing unused methods | Modular & decoupled design |
| **DIP** | Depend on abstractions | Flexible & testable architecture |
