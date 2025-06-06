import com.itextpdf.text.DocumentException;
import controllers.PressaoArterialController;
import controllers.RelatorioPressaoArterialPDFController;
import dao.PressaoArterialDAO;
import entity.PressaoArterial;


import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;

public class MainTeste {

    public static void main(String[] args) throws DocumentException, FileNotFoundException {
        PressaoArterialDAO pad = new PressaoArterialDAO();
        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.now();

        System.out.println();

        //PressaoArterial pa1 = new PressaoArterial(13.2, data, hora);

        //new PressaoArterialDAO().cadastrarPressaoArterial(pa1);

        /*System.out.println("Id: " + pad.buscarPressaoArterial(5).getId());
        System.out.println("valor pressao: " + pad.buscarPressaoArterial(5).getValorPressao());
        System.out.println("data: " + pad.buscarPressaoArterial(5).getData());
        System.out.println("hora: " + pad.buscarPressaoArterial(5).getHora());

        PressaoArterial pa1U = new PressaoArterial(5, 14.3, data, hora);

        pad.atualizarPressaoArterial(pa1U);

        System.out.println("Id: " + pad.buscarPressaoArterial(5).getId());
        System.out.println("valor pressao: " + pad.buscarPressaoArterial(5).getValorPressao());
        System.out.println("data: " + pad.buscarPressaoArterial(5).getData());
        System.out.println("hora: " + pad.buscarPressaoArterial(5).getHora());

        //pad.deletarPressaoArterial(11);
        System.out.println("==================================================");
        for (PressaoArterial pa : pad.listarPressaoArterial()){
            System.out.println("ID: " + pa.getId());
            System.out.println("Valor pressao: " + pa.getValorPressao());
            System.out.println("Data: " + pa.getData());
            System.out.println("Hora: " + pa.getHora());
            System.out.println("==================================================");
        }*/

//        System.out.println("=== FILTRAR POR DATAS");
//        System.out.println("==================================================");
//        for (PressaoArterial pa : pad.filtrarPorData(LocalDate.parse("2025-03-14"))){
//            System.out.println("ID: " + pa.getId());
//            System.out.println("Valor pressao: " + pa.getValorPressao());
//            System.out.println("Data: " + pa.getData());
//            System.out.println("Hora: " + pa.getHora());
//            System.out.println("==================================================");
//        }
//
//        System.out.println("== FILTRAR MAIOR");
//        System.out.println("==================================================");
//        for (PressaoArterial pa : pad.filtrarMaior()){
//            System.out.println("ID: " + pa.getId());
//            System.out.println("VALOR PRESSAP: " + pa.getValorPressao());
//            System.out.println("DATA: " + pa.getData());
//            System.out.println("HORA: " + pa.getHora());
//            System.out.println("==================================================");
//        }
//        System.out.println("== FILTRAR MENOR");
//        System.out.println("==================================================");
//        for (PressaoArterial pa : pad.filtrarMenor()){
//            System.out.println("ID: " + pa.getId());
//            System.out.println("VALOR PRESSAP: " + pa.getValorPressao());
//            System.out.println("DATA: " + pa.getData());
//            System.out.println("HORA: " + pa.getHora());
//            System.out.println("==================================================");
//        }
//
//        RelatorioPressaoArterialPDFController.gerarRelatorioPDFCompleto();


//        trp.open();

        PressaoArterialController pac = new PressaoArterialController();

        for (PressaoArterial pas : pac.findAll()){
            System.out.println(pas.toString());
        }

    }
}
