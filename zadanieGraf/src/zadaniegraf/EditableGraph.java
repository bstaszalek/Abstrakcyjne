package zadaniegraf;

public interface EditableGraph<NodeLabelType, EdgeLabelType> extends GrowingGraph<NodeLabelType, EdgeLabelType>{

    void removeVertex(LabeledVertex<NodeLabelType> vertex);
}
