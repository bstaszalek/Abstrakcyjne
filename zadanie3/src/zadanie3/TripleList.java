package zadanie3;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TripleList<T> implements Iterable<TripleList<T>> {
    

    private T value;
    private TripleList<T> nextElement;
    private TripleList<T> previousElement;
    private TripleList<T> middleElement;
    
    
    public TripleList(){
        this.nextElement = null;
        this.middleElement = null;
        this.previousElement = null;
        this.value = null;
    }
    
    public TripleList(T value) {
        
        this.nextElement = null;
        this.middleElement = null;
        this.previousElement = null;
        this.value = value;
    }
    
    public int getCount(){
        int counter = 0;
        
        TripleList<T> tempList = this;
        
        while(tempList != null){
            
            if(tempList.value != null){
                counter++;
            }
            if(tempList.middleElement != null){
                counter++;
            }
            tempList = tempList.nextElement;
        }
        
        return counter;
    }
    
    public TripleList<T> getNext(){
        return this.nextElement;
    }
    
    public TripleList<T> getPrev(){
        return this.previousElement;
        
    }
    
    public TripleList<T> getMiddle(){
        return this.middleElement;
    }
    
    public T getValue(){
        return this.value;
    }
    
    public void add(T addedValue){
        
        TripleList tempList = new TripleList<T>(addedValue);
        if(this.value == null){
            this.value = addedValue;
        }else if(this.middleElement == null){
            tempList.middleElement = this;
            this.middleElement = tempList;
        }else{
            TripleList<T> tempList2 = this;
            while(tempList2.nextElement != null) {
                tempList2 = tempList2.nextElement;
            }
            if(tempList2.middleElement == null) {
                tempList.middleElement = tempList2;
                tempList2.middleElement = tempList;
            }
            else {
                tempList.previousElement = tempList2;
                tempList2.nextElement = tempList;
            }
        }
    }    
    
    @Override
    public Iterator<TripleList<T>> iterator() {
        return new TripleListIterator();
    }
    
    private class TripleListIterator implements Iterator{
        
        private TripleList<T> currentList;
        private int iteratorCounter;
        
        public TripleListIterator() {
            this.iteratorCounter = 0;
        }
        
        @Override
        public boolean hasNext() {
            return this.iteratorCounter < TripleList.this.getCount();
        }
        
        @Override
        public TripleList<T> next(){
            if(this.hasNext()){
                currentList = TripleList.this;
                for(int i = 0; i < iteratorCounter; i++){
                    if (i % 2 == 0) {
                        currentList = currentList.middleElement;
                    }else{
                        currentList = currentList.middleElement.nextElement;
                    }
                }
                iteratorCounter++;
                return currentList;
            }
            throw new NoSuchElementException();
        }
        
    }
}
