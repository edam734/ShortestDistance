package com.edam.shortestPath.tree;

import com.edam.shortestPath.strategy.SearchStrategy;

/**
 * Represents a search operation over a previously built tree.
 * <p>
 * The actual traversal algorithm is delegated to a {@link SearchStrategy},
 * allowing different search algorithms to be used without changing this class.
 *
 * @author edam
 */
public class SearchShortestTree {

	private final Node root;
	private SearchStrategy strategy;

	/**
	 * Creates a search tree wrapper for the specified root node.
	 *
	 * @param root the root node of the tree to search
	 */
	public SearchShortestTree(Node root) {
		this.root = root;
	}

	/**
	 * Sets the search strategy used to calculate the minimum distance.
	 *
	 * @param strategy the search strategy to use
	 */
	public void setStrategy(SearchStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Calculates the minimum distance from the root node to the destination
	 * using the currently configured search strategy.
	 *
	 * @return the minimum distance to the destination, or {@code -1}
	 *         if no path exists
	 */
	public int minDistance() {
		return this.strategy.minDistance(this.root);
	}

}