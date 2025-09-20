# Document Editor – Design Overview

This project is a **scalable document editor** that currently supports **text** and **image** elements and is built to accommodate richer features such as **tables**, **videos**, **new-line**, **tab space**, and **code blocks** in the future.

---

## ✨ Features

- **Text & Image Support (Current)**
    - Add, remove, and render text and images in a document.

- **Planned Extensions**
    - **Table**: Represent structured tabular data.
    - **Video**: Embed playable video content.
    - **New-line & Tab Space**: Precise formatting controls.
    - **Code Blocks**: Syntax-highlighted code snippets.

The architecture follows **SOLID** principles, allowing new element types to be introduced without modifying existing core classes.

---

## 🏗️ Design Approaches

Two high-level approaches can guide the system design:

### 1. Top-Down Approach
- **Definition**: Start with the **highest-level object** and refine into smaller components.
- **Process**:
    1. Model the `Document` as the primary aggregate.
    2. Identify high-level operations such as editing, rendering, and persistence.
    3. Decompose into supporting classes (elements, strategies, persistence layers).
- **When Useful**:  
  When the final product or user requirements are well-known and you want to drive design from user workflows.

### 2. Bottom-Up Approach
- **Definition**: Begin with the **root-level objects** and compose larger structures from these primitives.
- **Process**:
    1. Design individual building blocks such as `DocumentElement` (e.g., `TextElement`, `ImageElement`).
    2. Compose them into a `Document` and higher-level managers.
    3. Add strategies for rendering and persistence.
- **When Useful**:  
  When the problem domain is well understood in terms of reusable primitives and flexibility is a priority.

> **General Recommendation**:  
> For a scalable, component-based editor, a **bottom-up approach is usually preferred**.  
> It allows small, testable units (elements, renderers, persistence) to be created and combined into complex documents.

---

## 🔑 Key Architectural Concepts

- **DocumentElement Interface**  
  Each element (text, image, future table/video/code) implements a `render()` method.

- **Document (Composite)**  
  Holds a collection of `DocumentElement` objects and coordinates their rendering.

- **RenderStrategy (Strategy Pattern)**  
  Supports different output formats such as plain text, HTML, or Markdown.

- **Persistence (Abstraction)**  
  Enables saving rendered output to various backends (database, file system, cloud).

- **DocumentManager**  
  High-level coordinator for adding elements, rendering, and saving documents.  
  Depends only on abstractions (`DocumentEditor`, `Persistence`, `RenderStrategy`) for maximum flexibility.

---

## 🚀 Scalability

Adding a new element type such as a `TableElement` or `VideoElement` only requires:

1. Implementing the `DocumentElement` interface.
2. Optionally registering creation logic in a factory or service.

No modifications are needed in core classes, ensuring the system is **open for extension and closed for modification**.

---

## ✅ Summary

- **Current Capabilities**: Text and image editing with pluggable rendering and persistence.
- **Future Ready**: Tables, video, code blocks, and more can be added seamlessly.
- **Preferred Design Flow**: **Bottom-up**, starting from small building blocks to assemble the complete editor.
