# 🧩 Threaded Resource Manager – Java

A multithreaded resource allocation system built for the **SLIIT OOP (Object-Oriented Programming)** module to demonstrate **thread synchronization** and **resource sharing** concepts.

---

## 📚 Project Overview

This Java program simulates a **Resource Manager** that manages a limited pool of resources among multiple users (threads).

- The **ResourceManager** controls the allocation and release of resources.
- The **UserThread** class simulates multiple users requesting and freeing resources concurrently.
- The **Main** class initializes the manager and user threads, displaying real-time allocation logs.

---

## 🧱 Class Structure

### **1️⃣ ResourceManager.java**
Manages the pool of resources.
- **Methods:**
  - `requestResource(int userId)`: Allocates a resource if available; otherwise, waits until one is free.
  - `releaseResource(int userId, int resourceId)`: Releases a resource and notifies waiting threads.

### **2️⃣ UserThread.java**
Simulates a user as a separate thread.
- **Behavior:**
  - Requests a resource from the manager.
  - Sleeps for `1000 ms` (simulating usage).
  - Releases the resource back to the manager.

### **3️⃣ Main.java**
The driver class that runs the simulation.
- Initializes a `ResourceManager` with **3 resources**.
- Spawns **5 user threads**.
- Prints log messages for acquiring and releasing resources.

---

## ⚙️ How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/Threaded-Resource-Manager-Java.git
   cd Threaded-Resource-Manager-Java

## 🧮 Sample Output

User 1 acquires Resource 0
User 5 acquires Resource 1
User 4 acquires Resource 2
User 3 is waiting for a resource.
User 2 is waiting for a resource.
User 4 releases Resource 2
User 2 acquires Resource 2
User 3 is waiting for a resource.
User 1 releases Resource 0
User 3 acquires Resource 0

🧠 Concepts Demonstrated

Multithreading (Thread class)
Synchronization (synchronized keyword)
Thread communication (wait() and notifyAll())
Resource allocation problem simulation
Object-oriented design
