# 🏙️ Assignment 3 — Minimum Spanning Tree (Prim & Kruskal)

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![Maven](https://img.shields.io/badge/Maven-Build-orange?logo=apache-maven)
![Algorithms](https://img.shields.io/badge/Algorithms-MST-success)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

**Student:** Ibyrkhanov Zhanibek  
**University:** Astana IT University  
**Course:** Algorithms and Data Structures  
**Date:** October 2025

---

## 📘 Project Overview
This project implements **Prim’s** and **Kruskal’s** algorithms for finding the **Minimum Spanning Tree (MST)** of weighted graphs.  
It simulates optimizing a **city transportation network** by minimizing road construction costs while keeping all points connected.

---

## 🌼 Project Structure
**src/main/java/mst/** → Java source code  
**data/** → Input graph datasets (JSON)  
**results/** → Output results (JSON + CSV)  
**Assignment3_Report.pdf** → Final report  
**pom.xml** → Maven configuration file  

---

## ⚙️ How to Run
1. Open the project in **IntelliJ IDEA** (as a Maven project)
2. Run the class:
   mst.Main
3. The program will generate:
- `results/output.json` — detailed results
- `results/summary.csv` — summary table

---

## 📊 Experimental Results

| Graph | Algorithm | Total Cost | Time (ms) | Operations |
|--------|------------|-------------|------------|-------------|
| smallGraph1 | Prim | 8 | 8 | 11 |
| smallGraph1 | Kruskal | 8 | 2 | 33 |
| mediumGraph1 | Prim | 43 | 0 | 30 |
| mediumGraph1 | Kruskal | 43 | 0 | 114 |
| largeGraph1 | Prim | 104 | 0 | 54 |
| largeGraph1 | Kruskal | 104 | 0 | 252 |

---

## 🧠 Analysis
- Both algorithms yield the **same MST total cost** → correctness confirmed ✅
- **Prim’s algorithm** performs slightly faster on dense graphs.
- **Kruskal’s algorithm** performs better on sparse graphs, though with more edge comparisons.

**Complexities:**
- Prim — `O(V²)`
- Kruskal — `O(E log E)`

---

## 📄 Final Report
📘 [Download Assignment3_Report.pdf](./Assignment3_Report.pdf)
<img width="799" height="569" alt="image" src="https://github.com/user-attachments/assets/3094a03d-1814-4919-bd3b-90b55fe1d9cb" />
<img width="794" height="569" alt="image" src="https://github.com/user-attachments/assets/b3fe3371-623b-43f8-8371-1853523e4350" />




---

## 🧾 References
- GeeksForGeeks — *Minimum Spanning Tree Algorithms*
- Cormen et al., *Introduction to Algorithms (CLRS, 3rd Edition)*
- Astana IT University course materials

---

---

## 🧩 Bonus Section — Designed Graph in Java

As an extra implementation, a **custom graph** was created directly in Java code  
and tested using both **Prim’s** and **Kruskal’s** algorithms to verify correctness.

**File:** `src/main/java/mst/DesignedGraphDemo.java`  
**Description:** Demonstrates how both algorithms produce the same MST cost for a manually constructed graph.

**Example output:**

```text
--- BONUS SECTION: Graph Designed in Java ---
Graph edges:
0 - 1 (3)
0 - 2 (1)
1 - 3 (4)
2 - 3 (2)
3 - 4 (5)

=== Designed Graph Results ===
Prim total cost: 10.0
Kruskal total cost: 10.0
✅ Both algorithms produced identical MST costs.
📘 This confirms both algorithms perform correctly on manually designed graphs in Java.




