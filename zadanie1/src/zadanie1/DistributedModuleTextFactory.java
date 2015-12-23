package zadanie1;

public class DistributedModuleTextFactory implements DistributedModuleFactory{
    
    String factoryText;
    
    public DistributedModuleTextFactory(String textForFactory){
        this.factoryText = textForFactory;
    }
    
    public Data createData(){
        return new TextData(factoryText);
    }
    
    public Exporter createExporter(){
        return new TextExporter(factoryText);
    }

    public Importer createImporter(){
        return new TextImporter();
    }
}
