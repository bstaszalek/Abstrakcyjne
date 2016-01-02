package zadanie3;

import org.junit.Test;
import static org.junit.Assert.*;


public class Zadanie3Test {
        
    @Test
    public void testEmptyListCreation(){
        TripleList<Integer> tripleList = new TripleList<>();
        assertEquals(0, tripleList.getCount());
        assertNull(tripleList.getNext());
        assertNull(tripleList.getPrev());
        assertNull(tripleList.getMiddle());
    }
        
    @Test
    public void testAddingSingleElement(){
        TripleList<Integer> tripleList = new TripleList<>();
        final int value = 4;
        tripleList.add(value);
        assertEquals(1, tripleList.getCount());
        assertEquals(value, (int)tripleList.getValue());
        assertNull(tripleList.getPrev());
        assertNull(tripleList.getMiddle());
        assertNull(tripleList.getNext());
    }
        
    @Test  
    public void testAddingTwoElements(){
        
        TripleList<Integer> tripleList = new TripleList<>();
        int value1 = 4;
        int value2 = -9;
        tripleList.add(value1);
        tripleList.add(value2);
        assertEquals(2, tripleList.getCount());
        // checking values
        assertEquals(value1, (int)tripleList.getValue());
        assertEquals(value2, (int)tripleList.getMiddle().getValue());
        assertEquals(tripleList.getValue(), tripleList.getMiddle().getMiddle().getValue());
        // checking neighbour Nodes of first element
        assertNull(tripleList.getPrev());
        assertNotNull(tripleList.getMiddle());
        assertNull(tripleList.getNext());
        // checking neighbour Nodes of second element
        assertNull(tripleList.getMiddle().getPrev());
        assertNull(tripleList.getMiddle().getNext());
    }
        
    @Test
    public void testAddingTreeElements(){
        TripleList<Integer> tripleList = new TripleList<>();
        int value1 = 4;
        int value2 = -9;
        int value3 = 47;
        tripleList.add(value1);
        tripleList.add(value2);
        tripleList.add(value3);
        assertEquals(3, (int)tripleList.getCount());
        // checking values
        assertEquals(value1, (int)tripleList.getValue());
        assertEquals(value2, (int)tripleList.getMiddle().getValue());
        assertEquals(value3, (int)tripleList.getNext().getValue());
        // checking neighbour Nodes of first element
        assertNull(tripleList.getPrev());
        assertNotNull(tripleList.getMiddle());
        assertNotNull(tripleList.getNext());
        // checking neighbour Nodes of second element
        assertNull(tripleList.getMiddle().getPrev());
        assertNotNull(tripleList.getMiddle().getMiddle());
        assertNull(tripleList.getMiddle().getNext());
        // checking neighbour Nodes of third/last element
        assertNotNull(tripleList.getNext().getPrev());
        assertNull(tripleList.getNext().getMiddle());
        assertNull(tripleList.getNext().getNext());
        // checking values
        assertEquals(value1, (int)tripleList.getValue());
        assertEquals(value2, (int)tripleList.getMiddle().getValue());
        assertEquals(value3, (int)tripleList.getNext().getValue());
    }
 
    @Test
    public void testAddingFiveElements(){
    
        TripleList<Integer> tripleList = new TripleList<>();
        int value1 = 1;
        int value2 = 2;
        int value3 = 3;
        int value4 = 4;
        int value5 = 5;
        tripleList.add(value1);
        tripleList.add(value2);
        tripleList.add(value3);
        tripleList.add(value4);
        tripleList.add(value5);
        assertEquals(5, (int)tripleList.getCount());
        // checking values
        assertEquals(value1, (int)tripleList.getValue());
        assertEquals(value2, (int)tripleList.getMiddle().getValue());
        assertEquals(value3,(int) tripleList.getNext().getValue());
        assertEquals(value4, (int)tripleList.getNext().getMiddle().getValue());
        assertEquals(value5,(int) tripleList.getNext().getNext().getValue());
    }

    @Test
    public void testListsEnumerator(){
        double[] values = { 1.1, 3.14, 6.13, 9.99999, 99.001 };
        TripleList<Double> tripleList = new TripleList<>();
        int i;
        for (i = 0; i < values.length; ++i){
            tripleList.add(values[i]);
        }
        i = 0;
        for(TripleList<Double> d : tripleList){
            if(values[i++]==d.getValue()){
                assertTrue(true);
            }else{
                assertTrue(false);
            }
                
        }
    }
    @Test
    public void testIfNoCycle(){
        /** Initialization of the TripleList **/
        final int NUMBER_OF_ELEMENTS = 100;
        TripleList<Integer> tripleList = new TripleList<>();
        for (int i = 0; i < NUMBER_OF_ELEMENTS; ++i){
            tripleList.add(i);
        }
        /** Created 2 TripleLists, first jumps every single element,
        another every two elements, in out case every two elements means every NextElement**/
        TripleList<Integer> tripleListEverySingleNode = tripleList;
        TripleList<Integer> tripleListEveryTwoNodes = tripleList.getNext();
        for (int i = 0; i < NUMBER_OF_ELEMENTS * NUMBER_OF_ELEMENTS; ++i){
            assertNotSame(tripleListEverySingleNode, tripleListEveryTwoNodes);
            //JumpToNextElement(ref tripleListEverySingleNode);
            if (null == tripleListEveryTwoNodes.getNext()){
                // if list has end means there are no cycles
                break;
            }
            else{
                tripleListEveryTwoNodes = tripleListEveryTwoNodes.getNext();
            }
        }
    }
    
}
