package zadaniegraf;

import java.util.Iterator;

public interface LabeledGraph <NodeLabelType, EdgeLabelType>{

    Iterator<? extends LabeledVertex<NodeLabelType> > vertexIterator();
    Iterator<? extends LabeledEdge<EdgeLabelType> > edgeIterator(LabeledVertex<NodeLabelType> vertex);
    LabeledEdge<? extends EdgeLabelType> getEdge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to);
}
