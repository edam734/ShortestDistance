package com.eduardo.shortestPath.tree;

import com.eduardo.shortestPath.strategy.SearchStrategy;

public class SearchShortestTree {

	Node root;
	private SearchStrategy strategy;

	public SearchShortestTree(Node root) {
		this.root = root;
	}

	public void setStrategy(SearchStrategy strategy) {
		this.strategy = strategy;
	}

	public int minDistance() {
		return this.strategy.minDistance(this.root);
	}

}
