package zadanie1;

import static org.junit.Assert.*;
import org.junit.Test;

public class Zadanie1Test {
    
    @Test
    public void testExporter() {
        String textToBeExported = "Ala ma kota";
        Exporter exporter = new TextExporter(textToBeExported);
        Data exportedData = exporter.getExportData();
        String exportedText = ((TextData) exportedData).getText();
        assertEquals(textToBeExported, exportedText);
        exportedData = exporter.getExportData();
        exportedText = ((TextData) exportedData).getText();
        assertEquals(textToBeExported, exportedText);
    }

    @Test
    public void testImporter()
    {
        String textToBeImported = "Ala zgubila dolara";
        Data dataToSendToImporter = new TextData(textToBeImported);
        Importer importer = new TextImporter();
        importer.setImportedData(dataToSendToImporter);
        String dataSavedInImporter = ((TextImporter) importer).getImportedText();
        assertEquals(textToBeImported, dataSavedInImporter);
    }

    @Test
    public void testFactory()
    {
        final String textForFactory = "Ali kot zjadl dolara";
        DistributedModuleFactory factory = new DistributedModuleTextFactory(textForFactory);
        Data dataFromFactory = factory.createData();
        String textFromModule = ((TextData) dataFromFactory).getText();
        assertEquals(textForFactory, textFromModule);
        Exporter exporter = factory.createExporter();
        textFromModule = ((TextData) ((TextExporter) exporter).getExportData()).getText();
        assertEquals(textForFactory, textFromModule);
        Importer importer = factory.createImporter();
        assertTrue(importer instanceof TextImporter);
    }
    
}
