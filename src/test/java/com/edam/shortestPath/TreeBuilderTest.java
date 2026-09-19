package com.edam.shortestPath;

import com.edam.shortestPath.tree.TreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TreeBuilderTest {

    @Test
    void shouldThrowExceptionWhenStartNodeIsMissing() {
        char[][] grid = {{'*', '*', 'd'}};

        assertThrows(IllegalArgumentException.class, () -> new TreeBuilder(grid));
    }

    @Test
    void shouldThrowExceptionWhenDestinationNodeIsMissing() {
        char[][] grid = {{'s', '*', '*'}};

        assertThrows(IllegalArgumentException.class, () -> new TreeBuilder(grid));
    }
}
