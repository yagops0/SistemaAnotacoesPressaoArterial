package conrollers;

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

public class RelatorioPressaoArterialPDFController {
    static Document document = new Document();
    static LocalDate dataAgora = LocalDate.now();
    static PressaoArterialDAO pad = new PressaoArterialDAO();


    public static void gerarRelatorioPDFCompleto() throws FileNotFoundException, DocumentException {

        PdfWriter.getInstance(document, new FileOutputStream("RelatorioPressaoArterial.pdf"));

        document.open();

        document.add(new Paragraph(dataAgora.toString()));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("RELATÓRIO COMPLETO PRESSÃO ARTERIAL"));

        document.add(new Paragraph(" "));
        PdfPTable tabela = new PdfPTable(3);
        PdfPCell col1 = new PdfPCell(new Paragraph("Pressão Arterial"));
        tabela.addCell(col1);
        PdfPCell col2 = new PdfPCell(new Paragraph("Data"));
        tabela.addCell(col2);
        PdfPCell col3 = new PdfPCell(new Paragraph("Hora"));
        tabela.addCell(col3);
        for (PressaoArterial pa : pad.listarPressaoArterial()){
            tabela.addCell(Double.toString(pa.getValorPressao()));
            tabela.addCell(pa.getData().toString());
            tabela.addCell(pa.getHora().toString());
        }
        document.add(tabela);
        document.close();

        try {
            Desktop.getDesktop().open(new File("RelatorioPressaoArterial.pdf"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void gerarRelatorioPDFData(LocalDate data) throws FileNotFoundException, DocumentException {

        PdfWriter.getInstance(document, new FileOutputStream("RelatorioPressaoArterial.pdf"));

        document.open();

        document.add(new Paragraph(dataAgora.toString()));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("RELATÓRIO POR DATA - PRESSÃO ARTERIAL"));

        document.add(new Paragraph(" "));
        PdfPTable tabela = new PdfPTable(3);
        PdfPCell col1 = new PdfPCell(new Paragraph("Pressão Arterial"));
        tabela.addCell(col1);
        PdfPCell col2 = new PdfPCell(new Paragraph("Data"));
        tabela.addCell(col2);
        PdfPCell col3 = new PdfPCell(new Paragraph("Hora"));
        tabela.addCell(col3);
        for (PressaoArterial pa : pad.filtrarPorData(data)){
            tabela.addCell(Double.toString(pa.getValorPressao()));
            tabela.addCell(pa.getData().toString());
            tabela.addCell(pa.getHora().toString());
        }
        document.add(tabela);
        document.close();

        try {
            Desktop.getDesktop().open(new File("RelatorioPressaoArterial.pdf"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void gerarRelatorioPDFAlta() throws FileNotFoundException, DocumentException {

        PdfWriter.getInstance(document, new FileOutputStream("RelatorioPressaoArterial.pdf"));

        document.open();

        document.add(new Paragraph(dataAgora.toString()));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("RELATÓRIO PRESSÃO ARTERIAL ACIMA DO NORMAL"));

        document.add(new Paragraph(" "));
        PdfPTable tabela = new PdfPTable(3);
        PdfPCell col1 = new PdfPCell(new Paragraph("Pressão Arterial"));
        tabela.addCell(col1);
        PdfPCell col2 = new PdfPCell(new Paragraph("Data"));
        tabela.addCell(col2);
        PdfPCell col3 = new PdfPCell(new Paragraph("Hora"));
        tabela.addCell(col3);
        for (PressaoArterial pa : pad.filtrarMaior()){
            tabela.addCell(Double.toString(pa.getValorPressao()));
            tabela.addCell(pa.getData().toString());
            tabela.addCell(pa.getHora().toString());
        }
        document.add(tabela);
        document.close();

        try {
            Desktop.getDesktop().open(new File("RelatorioPressaoArterial.pdf"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void gerarRelatorioPDFBaixa() throws FileNotFoundException, DocumentException {

        PdfWriter.getInstance(document, new FileOutputStream("RelatorioPressaoArterial.pdf"));

        document.open();

        document.add(new Paragraph(dataAgora.toString()));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("RELATÓRIO PRESSÃO ARTERIAL ABAIXO DO NORMAL"));

        document.add(new Paragraph(" "));
        PdfPTable tabela = new PdfPTable(3);
        PdfPCell col1 = new PdfPCell(new Paragraph("Pressão Arterial"));
        tabela.addCell(col1);
        PdfPCell col2 = new PdfPCell(new Paragraph("Data"));
        tabela.addCell(col2);
        PdfPCell col3 = new PdfPCell(new Paragraph("Hora"));
        tabela.addCell(col3);
        for (PressaoArterial pa : pad.filtrarMenor()){
            tabela.addCell(Double.toString(pa.getValorPressao()));
            tabela.addCell(pa.getData().toString());
            tabela.addCell(pa.getHora().toString());
        }
        document.add(tabela);
        document.close();

        try {
            Desktop.getDesktop().open(new File("RelatorioPressaoArterial.pdf"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
