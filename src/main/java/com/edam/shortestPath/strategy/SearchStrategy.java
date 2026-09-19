package com.edam.shortestPath.strategy;

import com.edam.shortestPath.tree.Node;

/**
 * Defines a strategy for finding the minimum distance from the root
 * of a search tree to a destination node.
 *
 * @author edam
 */
public interface SearchStrategy {

    /**
     * Finds the minimum distance from the root node to a destination node
     *
     * @param root the root node of the search tree
     * @return the minimum distance to a destination node, or -1 if no path exists
     */
    int minDistance(Node root);

}