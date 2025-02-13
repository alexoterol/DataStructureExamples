# Data Structures

Data structures are fundamental components of computer science that organize, manage, and store data efficiently for various operations. Choosing the right data structure impacts performance, memory usage, and algorithm complexity.
This repository has two main sections. The first one is opened with Meaven, where you can use an example of a graph. Inside the folder DataStructureExamples you can view the different data structures you could create but it's made with VSCode.

---

## 📌 Types of Data Structures

### 🔹 1. Primitive Data Structures
Basic building blocks that store simple data values.
- **Integer (`int`)** – Stores whole numbers.
- **Floating-point (`float`)** – Stores decimal numbers.
- **Character (`char`)** – Stores single characters.
- **Boolean (`bool`)** – Stores `true` or `false` values.

### 🔹 2. Linear Data Structures
Elements are arranged sequentially, making traversal straightforward.

#### 📍 Arrays
A fixed-size collection of elements of the same type, stored in contiguous memory locations.
**Operations:**
- **Access (`O(1)`)** – Direct index-based access.
- **Search (`O(n)`)** – Linear search for an element.
- **Insertion/Deletion (`O(n)`)** – Requires shifting elements.

#### 📍 Linked Lists
A collection of nodes where each node contains data and a reference (or link) to the next node.
**Types:**
- **Singly Linked List** – Each node points to the next one.
- **Doubly Linked List** – Each node points to both the previous and next nodes.
- **Circular Linked List** – The last node points back to the first node.

**Operations:**
- **Insertion (`O(1)`)** – At head or tail.
- **Deletion (`O(1)`)** – If reference is available.
- **Search (`O(n)`)** – Linear traversal.

#### 📍 Stacks
A Last-In-First-Out (LIFO) structure where the last inserted element is accessed first.
**Operations:**
- **Push (`O(1)`)** – Add element to the top.
- **Pop (`O(1)`)** – Remove the top element.
- **Peek (`O(1)`)** – Access the top element without removing it.

#### 📍 Queues
A First-In-First-Out (FIFO) structure where the first inserted element is accessed first.
**Types:**
- **Simple Queue** – Elements are added at the rear and removed from the front.
- **Circular Queue** – Overcomes linear queue limitations by wrapping around.
- **Priority Queue** – Elements are dequeued based on priority rather than order.
- **Deque (Double-ended Queue)** – Insertion and deletion allowed from both ends.

**Operations:**
- **Enqueue (`O(1)`)** – Add an element.
- **Dequeue (`O(1)`)** – Remove an element.
- **Front (`O(1)`)** – Access the first element.
- **Rear (`O(1)`)** – Access the last element.

---

## 🌳 Non-Linear Data Structures
Data elements are not arranged sequentially; they have hierarchical or graph-based relationships.

### 🔹 Trees
A hierarchical structure consisting of nodes connected by edges. The top node is called the root.

#### 📍 Binary Trees
Each node has at most two children (left and right).
- **Full Binary Tree** – Every node has 0 or 2 children.
- **Complete Binary Tree** – All levels are completely filled except possibly the last.
- **Perfect Binary Tree** – All internal nodes have two children and all leaves are at the same level.
- **Balanced Binary Tree** – The height difference between left and right subtrees is minimal.

#### 📍 Binary Search Tree (BST)
A binary tree where:
- Left subtree contains nodes with smaller values.
- Right subtree contains nodes with larger values.

**Operations:**
- **Insertion (`O(log n)`)**
- **Deletion (`O(log n)`)**
- **Search (`O(log n)`)**

#### 📍 Heap
A complete binary tree satisfying the heap property:
- **Min Heap** – Parent nodes are smaller than child nodes.
- **Max Heap** – Parent nodes are larger than child nodes.

**Uses:** Priority queues, scheduling systems.

### 🔹 Graphs
A set of vertices (nodes) connected by edges.

**Types:**
- **Directed Graph (Digraph)** – Edges have a direction.
- **Undirected Graph** – Edges have no direction.
- **Weighted Graph** – Edges have weights.

**Representations:**
- **Adjacency Matrix (`O(V^2)`)** – 2D array representation.
- **Adjacency List (`O(V + E)`)** – List representation with linked nodes.

**Graph Algorithms:**
- **Breadth-First Search (BFS) (`O(V + E)`)** – Explores level by level.
- **Depth-First Search (DFS) (`O(V + E)`)** – Explores as deep as possible.
- **Dijkstra's Algorithm (`O(E + V log V)`)** – Shortest path algorithm.

---

## 🔥 Advanced Data Structures
For optimized operations and specialized use cases.

### 🔹 Hash Table
A data structure that stores key-value pairs using a hash function.

**Operations:**
- **Insertion (`O(1)`)**
- **Search (`O(1)`)**
- **Deletion (`O(1)`)**

**Uses:**
- Caching, database indexing, symbol tables.

### 🔹 Trie (Prefix Tree)
A tree-like structure used for searching words in a dictionary.
**Operations:**
- **Insertion (`O(n)`)**
- **Search (`O(n)`)**
- **Deletion (`O(n)`)**

### 🔹 Segment Tree
Used for range queries and updates.
**Operations:**
- **Build (`O(n)`)**
- **Query (`O(log n)`)**
- **Update (`O(log n)`)**

### 🔹 B-Trees
A self-balancing search tree used in databases and file systems.

---

## 🎯 Choosing the Right Data Structure
| **Requirement** | **Recommended Data Structure** |
|---------------|-------------------------------|
| Fast lookup | Hash Table, Binary Search Tree |
| LIFO operations | Stack |
| FIFO operations | Queue, Deque |
| Hierarchical data | Tree |
| Graph-based modeling | Graph (Adjacency List) |
| Range queries | Segment Tree |

---

## 📌 Conclusion
Understanding data structures is crucial for writing efficient algorithms and solving complex problems. Mastering them enhances problem-solving skills and optimizes software performance.

🚀 *Choose wisely, and write efficient code!*

