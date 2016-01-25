package zadaniegraf;

public class Vertex<LabelType> implements LabeledVertex<LabelType>{

    private LabelType label;

    public Vertex(LabelType label){
        this.label = label;
    }

    @Override
    public LabelType getLabel(){
        return label;
    }

    @Override
    public void setLabel(LabelType label){
        this.label = label;
    }
}
