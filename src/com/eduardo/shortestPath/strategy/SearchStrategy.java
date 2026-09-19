package com.eduardo.shortestPath.strategy;

import com.eduardo.shortestPath.tree.Node;

public interface SearchStrategy {

    /**
     * Finds the minimum distance from the root node to a destination node
     *
     * @param root the root node of the search tree
     * @return the minimum distance to a destination node, or -1 if no path exists
     */
    int minDistance(Node root);

}
