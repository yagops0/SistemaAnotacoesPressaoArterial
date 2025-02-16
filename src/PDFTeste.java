import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.PressaoArterialDAO;
import entity.PressaoArterial;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;

public class PDFTeste {

    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PressaoArterialDAO pad = new PressaoArterialDAO();

        PdfWriter.getInstance(document, new FileOutputStream("RelatorioPDF.pdf"));

        document.open();
        LocalDate dataAgora = LocalDate.now();
        document.add(new Paragraph(dataAgora.toString()));
        document.add(new Paragraph("TESTANDO O ITEXT PDF"));
        document.add(new Paragraph(" "));
        PdfPTable tabela = new PdfPTable(3);
        /*PdfPCell col1 = new PdfPCell(new Paragraph("id"));
        tabela.addCell(col1);*/
        PdfPCell col2 = new PdfPCell(new Paragraph("valor pressao"));
        tabela.addCell(col2);
        PdfPCell col3 = new PdfPCell(new Paragraph("data"));
        tabela.addCell(col3);
        PdfPCell col4 = new PdfPCell(new Paragraph("hora"));
        tabela.addCell(col4);
        for (PressaoArterial pa : pad.filtrarPorData(LocalDate.parse("2025-03-14"))){
            tabela.addCell(Double.toString(pa.getValorPressao()));
            tabela.addCell(pa.getData().toString());
            tabela.addCell(pa.getHora().toString());
        }
        document.add(tabela);
        document.close();

        try {
            // ABRE O ARQUIVO PDF NO LEITOR PADRÃO DO DISPOSITIVO
            Desktop.getDesktop().open(new File("RelatorioPDF.pdf"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
