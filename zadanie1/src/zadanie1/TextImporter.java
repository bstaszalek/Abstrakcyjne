package zadanie1;

public class TextImporter extends Importer {
    
    public void setImportedData(TextData textData){
        
        importedData = textData;
    }
    
    public String getImportedText(){
        
        return importedData.getText();
    }
}
