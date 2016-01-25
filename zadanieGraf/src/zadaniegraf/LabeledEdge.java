package zadaniegraf;

public interface LabeledEdge<LabelType>{

    LabeledVertex<?> getFrom();
    LabeledVertex<?> getTo();
    LabelType getLabel();
    void setLabel(LabelType label);
}
