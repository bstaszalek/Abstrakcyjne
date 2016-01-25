package zadaniegraf;

public interface GrowingGraph<NodeLabelType, EdgeLabelType> extends LabeledGraph<NodeLabelType, EdgeLabelType>{

    LabeledVertex<NodeLabelType> addVertex(NodeLabelType label);
    LabeledEdge<EdgeLabelType> addEdge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to, EdgeLabelType label);
    LabeledEdge<EdgeLabelType> removeEdge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to);
}
