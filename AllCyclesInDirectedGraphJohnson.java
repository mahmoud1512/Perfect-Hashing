package org.example;

import java.util.*;
import java.util.List;

public class AllCyclesInDirectedGraphJohnson {
    Set<Vertex<Integer>> blockedSet;
    Map<Vertex<Integer>, Set<Vertex<Integer>>> blockedMap;
    Deque<Vertex<Integer>> stack;
    List<List<Vertex<Integer>>> allCycles;

    public List<List<Vertex<Integer>>> simpleCycles(Graph<Integer> graph) {

        blockedSet = new HashSet<>();
        blockedMap = new HashMap<>();
        stack = new LinkedList<>();
        allCycles = new ArrayList<>();
        long startIndex = 1;
        TarjanStronglyConnectedComponent tarjan = new TarjanStronglyConnectedComponent();
        while(startIndex <= graph.getAllVertex().size()) {
            Graph<Integer> subGraph = createSubGraph(startIndex, graph);
            List<Set<Vertex<Integer>>> sccs = tarjan.scc(subGraph);

            Optional<Vertex<Integer>> maybeLeastVertex = leastIndexSCC(sccs, subGraph);
            if(maybeLeastVertex.isPresent()) {
                Vertex<Integer> leastVertex = maybeLeastVertex.get();
                blockedSet.clear();
                blockedMap.clear();
                findCyclesInSCG(leastVertex, leastVertex);
                startIndex = leastVertex.getId() + 1;
            } else {
                break;
            }
        }
        return allCycles;
    }

    private Optional<Vertex<Integer>> leastIndexSCC(List<Set<Vertex<Integer>>> sccs, Graph<Integer> subGraph) {
        long min = Integer.MAX_VALUE;
        Vertex<Integer> minVertex = null;
        Set<Vertex<Integer>> minScc = null;
        for(Set<Vertex<Integer>> scc : sccs) {
            if(scc.size() == 1) {
                continue;
            }
            for(Vertex<Integer> vertex : scc) {
                if(vertex.getId() < min) {
                    min = vertex.getId();
                    minVertex = vertex;
                    minScc = scc;
                }
            }
        }

        if(minVertex == null) {
            return Optional.empty();
        }
        Graph<Integer> graphScc = new Graph<>(true);
        for(Edge<Integer> edge : subGraph.getAllEdges()) {
            if(minScc.contains(edge.getVertex1()) && minScc.contains(edge.getVertex2())) {
                graphScc.addEdge(edge.getVertex1().getId(), edge.getVertex2().getId());
            }
        }
        return Optional.of(graphScc.getVertex(minVertex.getId()));
    }

    private void unblock(Vertex<Integer> u) {
        blockedSet.remove(u);
        if(blockedMap.get(u) != null) {
            blockedMap.get(u).forEach( v -> {
                if(blockedSet.contains(v)) {
                    unblock(v);
                }
            });
            blockedMap.remove(u);
        }
    }
    private boolean findCyclesInSCG(
            Vertex<Integer> startVertex,
            Vertex<Integer> currentVertex) {
        boolean foundCycle = false;
        stack.push(currentVertex);
        blockedSet.add(currentVertex);

        for (Edge<Integer> e : currentVertex.getEdges()) {
            Vertex<Integer> neighbor = e.getVertex2();

            if (neighbor == startVertex) {
                List<Vertex<Integer>> cycle = new ArrayList<>();
                stack.push(startVertex);
                cycle.addAll(stack);
                Collections.reverse(cycle);
                stack.pop();
                allCycles.add(cycle);
                foundCycle = true;
            } //explore this neighbor only if it is not in blockedSet.
            else if (!blockedSet.contains(neighbor)) {
                boolean gotCycle =
                        findCyclesInSCG(startVertex, neighbor);
                foundCycle = foundCycle || gotCycle;
            }
        }
        //if cycle is found with current vertex then recursively unblock vertex and all vertices which are dependent on this vertex.
        if (foundCycle) {
            //remove from blockedSet  and then remove all the other vertices dependent on this vertex from blockedSet
            unblock(currentVertex);
        } else {
            //if no cycle is found with current vertex then don't unblock it. But find all its neighbors and add this
            //vertex to their blockedMap. If any of those neighbors ever get unblocked then unblock current vertex as well.
            for (Edge<Integer> e : currentVertex.getEdges()) {
                Vertex<Integer> w = e.getVertex2();
                Set<Vertex<Integer>> bSet = getBSet(w);
                bSet.add(currentVertex);
            }
        }
        //remove vertex from the stack.
        stack.pop();
        return foundCycle;
    }

    private Set<Vertex<Integer>> getBSet(Vertex<Integer> v) {
        return blockedMap.computeIfAbsent(v, (key) ->
                new HashSet<>() );
    }

    private Graph createSubGraph(long startVertex, Graph<Integer> graph) {
        Graph<Integer> subGraph = new Graph<>(true);
        for(Edge<Integer> edge : graph.getAllEdges()) {
            if(edge.getVertex1().getId() >= startVertex && edge.getVertex2().getId() >= startVertex) {
                subGraph.addEdge(edge.getVertex1().getId(), edge.getVertex2().getId());
            }
        }
        return subGraph;
    }

    public static void main(String[] args) {
        AllCyclesInDirectedGraphJohnson johnson = new AllCyclesInDirectedGraphJohnson();
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1,2 );
        graph.addEdge(2,3 );
        graph.addEdge(3,2 );
        graph.addEdge(3,4 );
        graph.addEdge(4,5 );
        graph.addEdge(5,4 );
        graph.addEdge(5,6 );
        graph.addEdge(5,6 );
        graph.addEdge(6,4 );
        graph.addEdge(6,7 );

        Edge<Integer> edge1 = new Edge<>(new Vertex<>(1),new Vertex<>(2),true, 1);
        Edge<Integer> edge2 = new Edge<>(new Vertex<>(2),new Vertex<>(3),true, 2);
        Edge<Integer> edge3 = new Edge<>(new Vertex<>(3),new Vertex<>(2),true, 3);
        Edge<Integer> edge4 = new Edge<>(new Vertex<>(3),new Vertex<>(4),true, 4);
        Edge<Integer> edge5 = new Edge<>(new Vertex<>(4),new Vertex<>(5),true, 5);
        Edge<Integer> edge6 = new Edge<>(new Vertex<>(5),new Vertex<>(4),true, 6);
        Edge<Integer> edge7 = new Edge<>(new Vertex<>(5),new Vertex<>(6),true, 7);
        Edge<Integer> edge8 = new Edge<>(new Vertex<>(5),new Vertex<>(6),true, 8);
        Edge<Integer> edge9 = new Edge<>(new Vertex<>(6),new Vertex<>(4),true, 9);
        Edge<Integer> edge10 = new Edge<>(new Vertex<>(6),new Vertex<>(7),true, 10);

        List<Edge<Integer>> edgeList = new ArrayList<>();
        edgeList.add(edge1);
        edgeList.add(edge2);
        edgeList.add(edge3);
        edgeList.add(edge4);
        edgeList.add(edge5);
        edgeList.add(edge6);
        edgeList.add(edge7);
        edgeList.add(edge8);
        edgeList.add(edge9);
        edgeList.add(edge10);

        Map<Edge<Integer>, List<Integer>>map = new HashMap<>();
        for(int i = 0; i < 10; i++){
            List<Integer> list;
            if(!map.containsKey(edgeList.get(i))) {
                list = new ArrayList<>();
            }else{
                list = map.get(edgeList.get(i));
            }
            list.add(edgeList.get(i).getWeight());
            map.put(edgeList.get(i), list);
        }

        List<List<Vertex<Integer>>> allCycles = johnson.simpleCycles(graph);
        HashSet<List<Vertex<Integer>>>distinctPaths = new HashSet<>(allCycles);
        List<Integer>cyclesGains = new ArrayList<>();

        for(List<Vertex<Integer>> vertexList : distinctPaths){
            int n = vertexList.size();
            List<Integer>tempList = new ArrayList<>();
            for(int i = 0; i < n - 1; i++){
                Edge<Integer> edge = new Edge<>(vertexList.get(i), vertexList.get(i+1));
                List<Integer>edgeWeights = map.get(edge);
                if(tempList.size() == 0)
                    tempList = edgeWeights;
                else {
                    List<Integer> temp2List = new ArrayList<>();
                    for (Integer weight : tempList) {
                        for (Integer weight2 : edgeWeights) {
                            temp2List.add(weight * weight2);
                        }
                    }
                    tempList = temp2List;
                }
            }
            cyclesGains.addAll(tempList);
        }

        for (Integer weight: cyclesGains)
            System.out.print(weight + " ");
        System.out.println();

        for(List<Vertex<Integer>> vv: distinctPaths){
            for(Vertex<Integer>v: vv)
                System.out.print(v + " ");
            System.out.println();
        }
    }
}