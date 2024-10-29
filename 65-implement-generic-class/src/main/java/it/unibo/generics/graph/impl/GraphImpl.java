package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
    private final Map<N, Set<N>> graph;
    private List<N> graphPath;

    public GraphImpl() {
        this.graph = new TreeMap<>();
    }

    private void depthFirstSearch(final N node, final N target) {
        this.graphPath.add(node);

        if (node == target) {
            return;
        }

        for (N n : this.linkedNodes(node)) {
            if (!this.graphPath.contains(n) && !this.graphPath.contains(target)) {
                depthFirstSearch(n, target);
            }
        }
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
        this.graphPath = new ArrayList<N>();

        this.depthFirstSearch(source, target);

        return this.graphPath;
    }

}
