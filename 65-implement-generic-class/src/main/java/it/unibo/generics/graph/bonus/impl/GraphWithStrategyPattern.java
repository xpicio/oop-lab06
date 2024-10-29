package it.unibo.generics.graph.bonus.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import it.unibo.generics.graph.bonus.api.Graph;
import it.unibo.generics.graph.bonus.api.GraphSearchAlgorithm;

public class GraphWithStrategyPattern<N> implements Graph<N> {
    private final Map<N, Set<N>> graph;
    private final GraphSearchAlgorithm<N> searchStrategy;

    public GraphWithStrategyPattern(final GraphSearchAlgorithm<N> searchStrategy) {
        if (searchStrategy == null) {
            throw new IllegalArgumentException("searchStrategy parameter can not be null or empty !");
        }

        this.graph = new TreeMap<>();
        this.searchStrategy = searchStrategy;
    }

    @Override
    public void addNode(final N node) {
        if (node == null) {
            return;
        }

        this.graph.put(node, new HashSet<>());
    }

    @Override
    public void addEdge(final N source, final N target) {
        Set<N> targets = this.graph.get(source);
        targets.add(target);

        this.graph.put(source, targets);
    }

    @Override
    public Set<N> nodeSet() {
        return Collections.unmodifiableSet(this.graph.keySet());
    }

    @Override
    public Set<N> linkedNodes(final N node) {
        Set<N> linkedNodes = Collections.unmodifiableSet(this.graph.get(node));

        return linkedNodes == null ? Collections.emptySet() : linkedNodes;
    }

    @Override
    public List<N> getPath(final N source, final N target) {
        return this.searchStrategy.getPath(this, source, target);
    }
}
