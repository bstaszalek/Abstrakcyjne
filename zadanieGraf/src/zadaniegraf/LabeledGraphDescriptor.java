package zadaniegraf;

import java.util.List;
import java.util.Set;

public class LabeledGraphDescriptor<NodeLabelType, EdgeLabelType>{

    private NeighbourhoodMapGraph<NodeLabelType, EdgeLabelType> graph;
    String end;
    
    public LabeledGraphDescriptor(NeighbourhoodMapGraph<NodeLabelType, EdgeLabelType> g, String s) {
        this.graph = g;
        end = s;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Set<LabeledVertex<NodeLabelType>> keys = graph.getVertexs();
        keys.forEach(key -> {
            stringBuilder.append(key.getLabel()).append(" : ");
            List<LabeledEdge<EdgeLabelType>> list = graph.getEdges(key);
            list.forEach(edge -> stringBuilder.append(edge.getLabel()).append(" -> ")
                    .append(edge.getTo().getLabel()).append(", "));
            stringBuilder.append(end);
        });
        return stringBuilder.toString();
    }
}
