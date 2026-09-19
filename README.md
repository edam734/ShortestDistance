# Shortest Distance

<br>

Java implementation of the **shortest distance between two cells in a matrix or grid**, based on the problem described by GeeksforGeeks.

Given an `N x M` grid, the goal is to find the shortest distance from a source cell to a destination cell. Movement is allowed only **up, down, left and right**, and only through traversable cells.

The project was also developed as a learning exercise to explore tree traversal, Breadth-First Search (BFS), Depth-First Search (DFS), the Strategy design pattern, Maven and automated testing with JUnit.

<br>

## Grid representation

* `s` — source
* `d` — destination
* `*` — traversable cell
* `0` — obstacle

The grid contains a single source and a single destination.

Example:

```text
Input:
{'0', '*', '0', 's'},
{'*', '0', '*', '*'},
{'0', '*', '*', '*'},
{'d', '*', '*', '*'}

Output: 6
```

If the destination cannot be reached:

```text
Input:
{'0', '*', '0', 's'},
{'*', '0', '*', '*'},
{'0', '*', '*', '*'},
{'d', '0', '0', '0'}

Output: -1
```

<br>

## How it works

`TreeBuilder` converts the valid paths in the grid into a search tree.

`SearchShortestTree` applies a `SearchStrategy` to that tree. Two strategies are currently implemented:

* `BreadthFirstSearchStrategy`
* `DepthFirstSearchStrategy`

This allows the traversal algorithm to be changed without modifying the search context itself.

```java
Node root = new TreeBuilder(grid).build();

SearchShortestTree searchTree = new SearchShortestTree(root);

searchTree.setStrategy(new BreadthFirstSearchStrategy());
System.out.println("BFS distance: " + searchTree.minDistance());

searchTree.setStrategy(new DepthFirstSearchStrategy());
System.out.println("DFS distance: " + searchTree.minDistance());
```

<br>

## Project structure

```text
src/
├── main/
│   └── java/
└── test/
    └── java/
```

The project uses **Maven** and **JUnit 5**.

To compile:

```bash
mvn clean compile
```

To run the tests:

```bash
mvn test
```

The `Main` class can also be run directly from an IDE.

<br>

## Design note

The tree-based implementation is intentionally more elaborate than a direct BFS over the grid. It was kept as a learning exercise to explore tree construction, parent-child relationships, recursion, DFS, BFS and the Strategy pattern.

For large and open grids, a BFS performed directly on the grid with a queue and a visited structure would be considerably more memory-efficient.

<br>
