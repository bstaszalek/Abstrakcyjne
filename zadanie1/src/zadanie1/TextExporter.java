package zadanie1;

public class TextExporter extends Exporter {
    
    public TextExporter(String textToBeExported){
        this.exportedData = new TextData(textToBeExported);
    }
}
