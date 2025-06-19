package factories;

import documents.PdfDocument;
import documents.Document;

public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}