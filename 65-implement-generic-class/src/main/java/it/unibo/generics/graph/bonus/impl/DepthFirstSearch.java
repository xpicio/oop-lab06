package it.unibo.generics.graph.bonus.impl;

import java.util.ArrayList;
import java.util.List;

import it.unibo.generics.graph.bonus.api.Graph;
import it.unibo.generics.graph.bonus.api.GraphSearchAlgorithm;

public class DepthFirstSearch<N> implements GraphSearchAlgorithm<N> {
    private final List<N> graphPath;
    private Graph<N> graph;

    public DepthFirstSearch() {
        this.graphPath = new ArrayList<>();
    }

    private void depthFirstSearch(final N node, final N target) {
        this.graphPath.add(node);

        if (node == target) {
            return;
        }

        for (N n : this.graph.linkedNodes(node)) {
            if (!this.graphPath.contains(n) && !this.graphPath.contains(target)) {
                depthFirstSearch(n, target);
            }
        }
    }

    @Override
    public List<N> getPath(final Graph<N> graph, final N source, final N target) {
        this.graph = graph;
        this.graphPath.clear();

        this.depthFirstSearch(source, target);

        return this.graphPath;
    }
}
