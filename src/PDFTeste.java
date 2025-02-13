import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDFTeste {

    public static final String RESULT = "C:\\Users\\yagos\\OneDrive\\Área de Trabalho\\testeJava.pdf";

    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream(RESULT));

        document.open();
        document.add(new Paragraph("TESTANDO O ITEXT PDF"));
        document.close();
    }
}
