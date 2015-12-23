package zadanie1;

public class TextData implements Data {
    
    private String text;
    
    public TextData(String data) {
        this.text = data;
    }
    
    
    public String getText(){
    
        return this.text;
    }
    
}
