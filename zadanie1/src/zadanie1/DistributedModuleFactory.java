package zadanie1;

public interface DistributedModuleFactory {
   
    public Data createData();

    public Exporter createExporter();

    public Importer createImporter();
}
