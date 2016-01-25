package zadaniegraf;

public class Edge <NodeLabelType, EdgeLabelType> implements LabeledEdge<EdgeLabelType>{

    private EdgeLabelType edgeLabelType;
    private LabeledVertex<NodeLabelType> from;
    private LabeledVertex<NodeLabelType> to;
    
    public Edge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to){
        this.from = from;
        this.to = to;
    }
    
    @Override
    public LabeledVertex<NodeLabelType> getFrom(){
        return from;
    }

    @Override
    public LabeledVertex<NodeLabelType> getTo(){
        return to;
    }
    
    @Override
    public EdgeLabelType getLabel(){
        return edgeLabelType;
    }
    
    @Override
    public void setLabel(EdgeLabelType label){
        this.edgeLabelType = label;
    }
}