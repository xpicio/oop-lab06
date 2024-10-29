package it.unibo.generics.graph.bonus.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import it.unibo.generics.graph.bonus.api.Graph;
import it.unibo.generics.graph.bonus.api.GraphSearchAlgorithm;

public class BreadthFirstSearch<N> implements GraphSearchAlgorithm<N> {
    private Graph<N> graph;

    @Override
    public List<N> getPath(final Graph<N> graph, final N source, final N target) {
        this.graph = graph;
        List<N> graphPath = new ArrayList<>();
        Queue<N> currentNodes = new LinkedList<>();

        currentNodes.add(source);
        graphPath.add(source);

        while (!currentNodes.isEmpty()) {
            N node = currentNodes.poll();

            if (node == target) {
                break;
            }

            // For testing purpose add shuffle to linkeNodes list, to test multiple
            // available path
            List<N> shuffledLinkedNodes = new ArrayList<N>(this.graph.linkedNodes(node));
            Collections.shuffle(shuffledLinkedNodes);

            for (N n : shuffledLinkedNodes) {
                if (!graphPath.contains(n) && !graphPath.contains(target)) {
                    graphPath.add(n);
                    currentNodes.add(n);
                    break;
                }
            }
        }

        return graphPath;
    }
}
