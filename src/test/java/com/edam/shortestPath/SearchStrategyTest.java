package com.edam.shortestPath;

import com.edam.shortestPath.strategy.BreadthFirstSearchStrategy;
import com.edam.shortestPath.strategy.DepthFirstSearchStrategy;
import com.edam.shortestPath.tree.Node;
import com.edam.shortestPath.tree.SearchShortestTree;
import com.edam.shortestPath.tree.TreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchStrategyTest {

    @Test
    void shouldFindShortestDistanceUsingBreadthFirstSearch() {
        char[][] grid = {
                {'s', '*', '*'},
                {'0', '0', '*'},
                {'*', '*', 'd'}
        };

        Node root = new TreeBuilder(grid).build();
        SearchShortestTree searchTree = new SearchShortestTree(root);

        searchTree.setStrategy(new BreadthFirstSearchStrategy());

        assertEquals(4, searchTree.minDistance());
    }

    @Test
    void shouldFindShortestDistanceUsingDepthFirstSearch() {
        char[][] grid = {
                {'s', '*', '*'},
                {'0', '0', '*'},
                {'*', '*', 'd'}
        };

        Node root = new TreeBuilder(grid).build();
        SearchShortestTree searchTree = new SearchShortestTree(root);

        searchTree.setStrategy(new DepthFirstSearchStrategy());

        assertEquals(4, searchTree.minDistance());
    }

    @Test
    void shouldReturnMinusOneWhenNoPathExists() {
        char[][] grid = {
                {'s', '0', 'd'}
        };

        Node root = new TreeBuilder(grid).build();
        SearchShortestTree searchTree = new SearchShortestTree(root);

        searchTree.setStrategy(new BreadthFirstSearchStrategy());
        assertEquals(-1, searchTree.minDistance());

        searchTree.setStrategy(new DepthFirstSearchStrategy());
        assertEquals(-1, searchTree.minDistance());
    }

    @Test
    void shouldReturnOneWhenDestinationIsAdjacent() {
        char[][] grid = {
                {'s', 'd'}
        };

        Node root = new TreeBuilder(grid).build();
        SearchShortestTree searchTree = new SearchShortestTree(root);

        searchTree.setStrategy(new BreadthFirstSearchStrategy());
        assertEquals(1, searchTree.minDistance());

        searchTree.setStrategy(new DepthFirstSearchStrategy());
        assertEquals(1, searchTree.minDistance());
    }
}