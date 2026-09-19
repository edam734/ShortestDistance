package com.edam.shortestPath.tree;

/**
 * Builds a tree representation of all valid paths that can be explored
 * from the start position of a character grid.
 * <p>
 * Obstacles are ignored and cycles within the current path are prevented.
 * Tree expansion stops when the destination node is reached.
 *
 * @author edam
 */
public class TreeBuilder {

    char[][] grid;
    Node root;
    Node destiny;

    public final static char START_CHAR = 's';
    public final static char DESTINY_CHAR = 'd';

    public TreeBuilder(char[][] grid) {
        this.grid = grid;
        this.root = getFirstNodeByValue(START_CHAR);
        this.destiny = getFirstNodeByValue(DESTINY_CHAR);

        if (this.root == null) {
            throw new IllegalArgumentException("Grid does not contain a start node.");
        }
        if (this.destiny == null) {
            throw new IllegalArgumentException("Grid does not contain a destination node.");
        }
    }

    /**
     * Builds the search tree starting from the grid's start node.
     *
     * @return the root node of the generated search tree
     */
    public Node build() {
        addNeighborNode(null, this.root, this.root.getLine(), this.root.getColumn());

        return this.root;
    }

    private Node getFirstNodeByValue(char value) {
        for (int line = 0; line < this.grid.length; line++) {
            for (int column = 0; column < this.grid[line].length; column++) {
                if (this.grid[line][column] == value) {
                    return new Node(value, line, column);
                }
            }
        }

        return null;
    }

    private void addNeighborNode(Node previous, Node current, int line, int column) {
        if (current == null) {
            return;
        }

        if (previous != null) {
            previous.addChildren(current);
        }

        if (!current.equals(this.destiny)) {
            goToNeighborNode(current, line - 1, column);
            goToNeighborNode(current, line, column - 1);
            goToNeighborNode(current, line + 1, column);
            goToNeighborNode(current, line, column + 1);
        }
    }

    private void goToNeighborNode(Node current, int line, int column) {
        Node adjacentNode = getNeighborNode(line, column);

        if (adjacentNode != null && !adjacentNode.isAlreadyInTree(current)) {
            addNeighborNode(current, adjacentNode, line, column);
        }
    }

    private Node getNeighborNode(int line, int column) {
        if (!isInsideGrid(line, column) || isObstacle(line, column)) {
            return null;
        }

        return new Node(this.grid[line][column], line, column);
    }

    private boolean isInsideGrid(int line, int column) {
        return line >= 0 &&
                line < this.grid.length &&
                column >= 0 &&
                column < this.grid[line].length;
    }

    private boolean isObstacle(int line, int column) {
        return this.grid[line][column] == '0';
    }

}