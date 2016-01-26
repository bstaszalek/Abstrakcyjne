package zadaniegraf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class NeighbourhoodMapGraph<NodeLabelType, EdgeLabelType> implements EditableGraph<NodeLabelType, EdgeLabelType>{

    LinkedHashMap<LabeledVertex<NodeLabelType>, List <LabeledEdge<EdgeLabelType>>> neighbourhoodMap = new LinkedHashMap<>();
    int edgesCounter;
    int vertexCounter;
    public NeighbourhoodMapGraph(){
    }
    
    public NeighbourhoodMapGraph(List<?> list){
        list.forEach(label -> addVertex((NodeLabelType) label));
        edgesCounter = 0;
        vertexCounter = 0;
    }

    @Override
    public LabeledVertex<NodeLabelType> addVertex(NodeLabelType label) {
        LabeledVertex<NodeLabelType> vertex = new Vertex<>(label);
        neighbourhoodMap.put(vertex, new ArrayList<>());
        vertexCounter += 1;
        return vertex;
    }

    @Override
    public LabeledEdge<EdgeLabelType> addEdge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to, EdgeLabelType label) {
        LabeledEdge<EdgeLabelType> edge = new Edge<>(from, to);
        edge.setLabel(label);
        neighbourhoodMap.get(from).add(edge);
        edgesCounter += 1;
        return edge;
    }

    @Override
    public LabeledEdge<EdgeLabelType> removeEdge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to) {
        LabeledEdge<EdgeLabelType> edgeForRemoval = null;
        for(LabeledEdge<EdgeLabelType> edge : neighbourhoodMap.get(from)){
            if (edge.getTo() == to){
                edgeForRemoval = edge;
                break;
            }
        }
        neighbourhoodMap.get(from).remove(edgeForRemoval);
        edgesCounter -= 1;
        return edgeForRemoval;
    }

    @Override
    public int getVertexCount(){
        return vertexCounter;
    }
    
    @Override
    public int getEdgesCount(){
        return edgesCounter;
    }
    
    @Override
    public Iterator<? extends LabeledVertex<NodeLabelType>> vertexIterator() {
        return neighbourhoodMap.keySet().iterator();
    }

    @Override
    public Iterator<? extends LabeledEdge<EdgeLabelType>> edgeIterator(LabeledVertex<NodeLabelType> vertex) {
        return neighbourhoodMap.get(vertex).iterator();
    }

    @Override
    public LabeledEdge<EdgeLabelType> getEdge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to) {
        for(LabeledEdge<EdgeLabelType> edge : neighbourhoodMap.get(from)){
            if (edge.getTo() == to){
                return edge;
            }
        }
        return null;
    }

    public Set<LabeledVertex<NodeLabelType>> getVertexs(){
        return neighbourhoodMap.keySet();
    }

    public List<LabeledEdge<EdgeLabelType>> getEdges(LabeledVertex<NodeLabelType> vertex){
        return neighbourhoodMap.get(vertex);
    }

    @Override
    public void removeVertex(LabeledVertex<NodeLabelType> vertex) {
        neighbourhoodMap.remove(vertex);
        vertexCounter -= 1;
    }
}
