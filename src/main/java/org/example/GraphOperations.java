package org.example;

import java.util.*;

public class GraphOperations {

    private void addToCycles(int v, Stack<Integer>ST,  List<List<Integer>>allCycle){
        List<Integer>cycle = new ArrayList<>();
        Stack<Integer> tempST = new Stack<>();

        cycle.add(v);
        while (ST.peek() != v){
            cycle.add(ST.peek());

            tempST.push(ST.peek());

            ST.pop();
        }
        cycle.add(v);

        Collections.reverse(cycle);
        allCycle.add(cycle);

        while (!tempST.empty()){
            ST.push(tempST.peek());
            tempST.pop();
        }
    }
    private void cycleDFS(int V, Map<Integer, List<Pair>> adj, boolean[] visited, Stack<Integer>ST, TreeSet<Integer>TS,  List<List<Integer>>allCycle){
        visited[V] = true;
        ST.push(V);
        TS.add(V);


        for(Pair v: adj.get(V)){
            if(TS.contains(v.destination)){
               addToCycles(v.destination, ST, allCycle);
            }
            if(!visited[v.destination]){
                cycleDFS(v.destination, adj, visited, ST, TS, allCycle );
            }
        }

        int element = ST.peek();
        TS.remove(element);
        ST.pop();
    }
    public List<List<Integer>> findAllCycles( Map<Integer, List<Pair>> adj){
        int N = adj.size();
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);
        Stack<Integer>ST = new Stack<>();
        TreeSet<Integer> TS = new TreeSet<>();
        List<List<Integer>>allCycle = new ArrayList<>();

        for(int i = 0; i < N; i++){
            if(!visited[i])
                cycleDFS(i, adj, visited, ST, TS, allCycle);
        }

        return allCycle;
    }

    private void pathsDFS(int V, int destination, Map<Integer, List<Pair>> adj, boolean[] visited, List<Integer> path, List<List<Integer>> allPaths){
        visited[V] = true;
        path.add(V);

        if(V == destination){
            allPaths.add(new ArrayList<>(path));

            visited[V] = false;
            path.remove(path.size()-1);
            return;
        }

        for(Pair v: adj.get(V)){
            if(!visited[v.destination])
                pathsDFS(v.destination, destination, adj, visited, path, allPaths);
        }

        visited[V] =false;
        path.remove(path.size()-1);
    }
    public List<List<Integer>> findAllPaths(Map<Integer, List<Pair>> adj, int source, int destination){
        List<List<Integer>>allPaths = new ArrayList<>();

        int N = adj.size();
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);

        List<Integer>path = new ArrayList<>();

        pathsDFS(source, destination, adj, visited, path, allPaths);

        return allPaths;
    }
}
