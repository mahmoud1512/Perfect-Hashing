package org.example;

import java.util.*;

public class TarjanStronglyConnectedComponent {

    private Map<Vertex<Integer>, Integer> visitedTime;
    private Map<Vertex<Integer>, Integer> lowTime;
    private Set<Vertex<Integer>> onStack;
    private Deque<Vertex<Integer>> stack;
    private Set<Vertex<Integer>> visited;
    private List<Set<Vertex<Integer>>> result;
    private int time;

    public List<Set<Vertex<Integer>>> scc(Graph<Integer> graph) {

        //keeps the time when every vertex is visited
        time = 0;
        //keeps map of vertex to time it was visited
        visitedTime = new HashMap<>();

        //keeps map of vertex and time of first vertex visited in current DFS
        lowTime = new HashMap<>();

        //tells if a vertex is in stack or not
        onStack = new HashSet<>();

        //stack of visited vertices
        stack = new LinkedList<>();

        //tells if vertex has ever been visited or not. This is for DFS purpose.
        visited = new HashSet<>();

        //stores the strongly connected components result;
        result = new ArrayList<>();

        //start from any vertex in the graph.
        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            if (visited.contains(vertex)) {
                continue;
            }
            sccUtil(vertex);
        }

        return result;
    }

    private void sccUtil(Vertex<Integer> vertex) {

        visited.add(vertex);
        visitedTime.put(vertex, time);
        lowTime.put(vertex, time);
        time++;
        stack.addFirst(vertex);
        onStack.add(vertex);

        for (Vertex child : vertex.getAdjacentVertexes()) {
            //if child is not visited then visit it and see if it has link back to vertex's ancestor. In that case update
            //low time to ancestor's visit time
            if (!visited.contains(child)) {
                sccUtil(child);
                //sets lowTime[vertex] = min(lowTime[vertex], lowTime[child]);
                lowTime.compute(vertex, (v, low) ->
                        Math.min(low, lowTime.get(child))
                );
            } //if child is on stack then see if it was visited before vertex's low time. If yes then update vertex's low time to that.
            else if (onStack.contains(child)) {
                //sets lowTime[vertex] = min(lowTime[vertex], visitedTime[child]);
                lowTime.compute(vertex, (v, low) -> Math.min(low, visitedTime.get(child))
                );
            }
        }

        //if vertex low time is same as visited time then this is start vertex for strongly connected component.
        //keep popping vertices out of stack still you find current vertex. They are all part of one strongly
        //connected component.
        if (Objects.equals(visitedTime.get(vertex), lowTime.get(vertex))) {
            Set<Vertex<Integer>> stronglyConnectedComponent = new HashSet<>();
            Vertex v;
            do {
                v = stack.pollFirst();
                onStack.remove(v);
                stronglyConnectedComponent.add(v);
            } while (!vertex.equals(v));
            result.add(stronglyConnectedComponent);
        }
    }
}
