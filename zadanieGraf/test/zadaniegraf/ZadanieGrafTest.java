package zadaniegraf;

import org.junit.Test;
import static org.junit.Assert.*;

public class ZadanieGrafTest {
    
    @Test
    public void testCreatingGraph(){
        NeighbourhoodMapGraph<String, Double> g = new NeighbourhoodMapGraph<>();
        LabeledVertex<String>[] vs = new LabeledVertex[]{

            g.addVertex("first"),
            g.addVertex("next"),
            g.addVertex("secondNext"),
            g.addVertex("last")
        };
        
        g.addEdge(vs[0], vs[1], 25.0);
        g.addEdge(vs[0], vs[3], 16.1);
        g.addEdge(vs[1], vs[2], 17.9);
        g.addEdge(vs[3], vs[2], -5.3);
        g.addEdge(vs[3], vs[0], 148.0);
        g.addEdge(vs[2], vs[0], 6.5);
        assertEquals(g.getEdgesCount(), 6);
        assertEquals(g.getVertexCount(), 4);
        assertEquals(g.getEdge(vs[0], vs[1]).getLabel().toString(), "25.0");
        assertEquals(g.getEdge(vs[0], vs[3]).getLabel().toString(), "16.1");
        assertEquals(g.getEdge(vs[1], vs[2]).getLabel().toString(), "17.9");
        assertEquals(g.getEdge(vs[3], vs[2]).getLabel().toString(), "-5.3");
        assertEquals(g.getEdge(vs[3], vs[0]).getLabel().toString(), "148.0");
        assertEquals(g.getEdge(vs[2], vs[0]).getLabel().toString(), "6.5");
    }
    
    @Test
    public void testEditingGraph(){
    
        NeighbourhoodMapGraph<String, Integer> g = new NeighbourhoodMapGraph<>();
        LabeledVertex<String>[] vs = new LabeledVertex[]{

            g.addVertex("first"),
            g.addVertex("next"),
            g.addVertex("secondNext"),
            g.addVertex("last")
        };
        
        g.addEdge(vs[0], vs[1], 2);
        g.addEdge(vs[0], vs[3], 5);
        g.addEdge(vs[1], vs[2], 15);
        g.addEdge(vs[3], vs[2], 14);
        g.addEdge(vs[3], vs[0], 8);
        g.addEdge(vs[2], vs[0], 7);
        
        vs[2].setLabel("changed");
        g.getEdge(vs[2], vs[0]).setLabel(75);
        g.removeEdge(vs[3], vs[0]);
        g.removeVertex(vs[1]);
        
        assertEquals(g.getEdge(vs[2], vs[0]).getLabel().toString(), "75");
        assertNull(g.getEdge(vs[3], vs[0]));
        assertEquals(g.getEdgesCount(), 5);
        assertEquals(g.getVertexCount(), 3);
    }
    
    @Test
    public void testGraphDescriptor(){
        
        NeighbourhoodMapGraph<String, Integer> g = new NeighbourhoodMapGraph<>();
        LabeledVertex<String>[] vs = new LabeledVertex[]{

            g.addVertex("a"),
            g.addVertex("b"),
            g.addVertex("c"),
            g.addVertex("d")
        };
        
        g.addEdge(vs[0], vs[1], 2);
        g.addEdge(vs[0], vs[3], 5);
        g.addEdge(vs[1], vs[2], 9);
        g.addEdge(vs[3], vs[2], 14);
        g.addEdge(vs[3], vs[0], 8);
        g.addEdge(vs[2], vs[0], 7);
        
        LabeledGraphDescriptor graphDescriptor = new LabeledGraphDescriptor<>(g, "");
        String goodDescriptor = "a : 2 -> b, 5 -> d, b : 9 -> c, c : 7 -> a, d : 14 -> c, 8 -> a, ";
        assertEquals(graphDescriptor.toString(), goodDescriptor);
    }
}
