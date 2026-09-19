package com.edam.shortestPath;

import com.edam.shortestPath.strategy.BreadthFirstSearchStrategy;
import com.edam.shortestPath.strategy.DepthFirstSearchStrategy;
import com.edam.shortestPath.tree.Node;
import com.edam.shortestPath.tree.SearchShortestTree;
import com.edam.shortestPath.tree.TreeBuilder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @Test
    void shouldHandleCoordinatesWithTwoDigits() {
        char[][] grid = new char[12][12];

        for (char[] chars : grid) {
            Arrays.fill(chars, '0');
        }

        for (int column = 1; column <= 11; column++) {
            grid[1][column] = '*';
        }

        for (int line = 1; line <= 11; line++) {
            grid[line][11] = '*';
        }

        grid[1][1] = 's';
        grid[11][11] = 'd';

        Node root = new TreeBuilder(grid).build();
        SearchShortestTree searchTree = new SearchShortestTree(root);

        searchTree.setStrategy(new BreadthFirstSearchStrategy());
        assertEquals(20, searchTree.minDistance());

        searchTree.setStrategy(new DepthFirstSearchStrategy());
        assertEquals(20, searchTree.minDistance());
    }
}