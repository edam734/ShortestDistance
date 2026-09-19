package com.edam.shortestPath.strategy;

import java.util.List;

import com.edam.shortestPath.tree.Node;
import com.edam.shortestPath.tree.TreeBuilder;

/**
 *
 * @author Eduardo
 *
 */
public class DepthFirstSearchStrategy implements SearchStrategy {

    @Override
    public int minDistance(Node root) {
        int result = depthFirstSearch(root, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * The DFS is not the best strategy for this type of search (for shortest path),
     * as we have to go through all the nodes to make sure we have found the
     * shortest destination node.
     *
     * @param node  The current node
     * @param depth The current depth of the {@code SearchShortedTree}
     */
    private int depthFirstSearch(Node node, int depth) {
        List<Node> children = node.getChildren();

        // base case
        if (node.getValue() == TreeBuilder.DESTINY_CHAR) { // it's a destiny node
            return depth;
        } else if (node.isLeaf()) { // it's a useless leaf
            return Integer.MAX_VALUE; // to discard value
        } else { // not the base case
            return children.stream()
                    .map(child -> depthFirstSearch(child, depth + 1))
                    .min(Integer::compare)
                    .orElse(Integer.MAX_VALUE);
        }

    }
}