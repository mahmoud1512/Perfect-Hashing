package com.Signalflowgraphs.Signalflowgraphs.Moduels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignalFlowGraph {
    private Map<Integer, List<Pair>>adj;

    public void graphInitialize(List<SourceDestinations> graph){
        for(SourceDestinations entry: graph){
            adj.put(entry.getSource(), entry.getDestinations());
        }
    }

    public Map<Integer, List<Pair>> getGraph() {
        return adj;
    }
}
