package com.edam.shortestPath.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

    private final char value;
    private final int line;
    private final int column;
    private final List<Node> children;

    private Node parent;

    public Node(char value, int line, int column) {
        super();
        this.value = value;
        this.line = line;
        this.column = column;
        this.children = new ArrayList<>();
    }

    public char getValue() {
        return value;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public List<Node> getChildren() {
        return children;
    }

    public boolean isLeaf() {
        return getChildren().isEmpty();
    }

    public void addChildren(Node node) {
        node.addParent(this);
        children.add(node);
    }

    private void addParent(Node node) {
        this.parent = node;
    }

    public boolean isAlreadyInTree(Node leaf) {
        if (leaf == null) { // could be root's parent
            return false;
        }
        if (!this.equals(leaf)) {
            return this.isAlreadyInTree(leaf.parent);
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return line == node.line && column == node.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, column);
    }

    @Override
    public String toString() {
        return "Node{" + ", value=" + value + ", line=" + line + ", column=" + column + '}';
    }
}
