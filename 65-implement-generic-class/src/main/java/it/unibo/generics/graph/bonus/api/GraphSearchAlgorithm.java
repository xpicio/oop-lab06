package it.unibo.generics.graph.bonus.api;

import java.util.List;

public interface GraphSearchAlgorithm<N> {

    List<N> getPath(Graph<N> graph, N source, N target);

}
