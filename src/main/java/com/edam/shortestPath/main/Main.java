package com.edam.shortestPath.main;

import com.edam.shortestPath.strategy.BreadthFirstSearchStrategy;
import com.edam.shortestPath.strategy.DepthFirstSearchStrategy;
import com.edam.shortestPath.tree.Node;
import com.edam.shortestPath.tree.SearchShortestTree;
import com.edam.shortestPath.tree.TreeBuilder;

public class Main {

    public static void main(String[] args) {
        char[][] grid = {
                {'s', '*', '*', '*'},
                {'0', '0', '*', '0'},
                {'*', '*', '*', '*'},
                {'*', '0', '0', 'd'}
        };

        Node root = new TreeBuilder(grid).build();
        SearchShortestTree searchTree = new SearchShortestTree(root);

        searchTree.setStrategy(new BreadthFirstSearchStrategy());
        System.out.println("BFS distance: " + searchTree.minDistance());

        searchTree.setStrategy(new DepthFirstSearchStrategy());
        System.out.println("DFS distance: " + searchTree.minDistance());
    }
}
