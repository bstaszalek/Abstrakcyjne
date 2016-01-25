package zadaniegraf;

import org.junit.Test;
import static org.junit.Assert.*;

public class ZadanieGrafTest {
    
    @Test
    public void test(){
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
        assertEquals(g.getEdge(vs[0], vs[1]).getLabel().toString(), "25.0");
        assertEquals(g.getEdge(vs[0], vs[3]).getLabel().toString(), "16.1");
        assertEquals(g.getEdge(vs[1], vs[2]).getLabel().toString(), "17.9");
        assertEquals(g.getEdge(vs[3], vs[2]).getLabel().toString(), "-5.3");
        assertEquals(g.getEdge(vs[3], vs[0]).getLabel().toString(), "148.0");
        assertEquals(g.getEdge(vs[2], vs[0]).getLabel().toString(), "6.5");
        
        LabeledGraphDescriptor graph = new LabeledGraphDescriptor<>(g, "\n");
        System.out.println(graph);
        
        vs[2].setLabel("changed");
        g.getEdge(vs[2], vs[0]).setLabel(84.0);
        g.removeEdge(vs[3], vs[0]);
        g.removeVertex(vs[1]);
        
        assertEquals(g.getEdge(vs[2], vs[0]).getLabel().toString(), "84.0");
        assertNull(g.getEdge(vs[3], vs[0]));
        
        graph = new LabeledGraphDescriptor<>(g, "\n");
        System.out.println(graph);
    }
}
