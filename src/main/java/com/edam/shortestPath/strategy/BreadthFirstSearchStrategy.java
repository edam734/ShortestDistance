package com.edam.shortestPath.strategy;

import java.util.ArrayDeque;
import java.util.Queue;

import com.edam.shortestPath.tree.Node;
import com.edam.shortestPath.tree.TreeBuilder;

/**
 * Implements the shortest-distance search using breadth-first search.
 * <p>
 * Nodes are explored level by level, which guarantees that the first
 * destination reached corresponds to the shortest path in the tree.
 *
 * @author edam
 */
public class BreadthFirstSearchStrategy implements SearchStrategy {

	private record NodeDepth(Node node, int depth) {
	}

	/**
	 * Finds the minimum distance to the destination using breadth-first search.
	 * Nodes are explored level by level, ensuring that the first destination
	 * found corresponds to the shortest path.
	 *
	 * @param root the root node of the search tree
	 * @return the minimum distance to the destination, or -1 if no path exists
	 */
	@Override
	public int minDistance(Node root) {
		Queue<NodeDepth> queue = new ArrayDeque<>();
		queue.add(new NodeDepth(root, 0));

		while (!queue.isEmpty()) {
			NodeDepth current = queue.remove();

			if (current.node().getValue() == TreeBuilder.DESTINY_CHAR) {
				return current.depth();
			}

			for (Node child : current.node().getChildren()) {
				queue.add(new NodeDepth(child, current.depth() + 1));
			}
		}

		return -1;
	}
}