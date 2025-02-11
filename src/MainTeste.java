import dao.PressaoArterialDAO;
import entity.PressaoArterial;

import java.time.LocalDate;
import java.time.LocalTime;

public class MainTeste {
    public static void main(String[] args) {
        PressaoArterialDAO pad = new PressaoArterialDAO();
        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.now();

        PressaoArterial pa1 = new PressaoArterial(13.2, data, hora);

        //new PressaoArterialDAO().cadastrarPressaoArterial(pa1);

        System.out.println("Id: " + pad.buscarPressaoArterial(11).getId());
        System.out.println("valor pressao: " + pad.buscarPressaoArterial(11).getValorPressao());
        System.out.println("data: " + pad.buscarPressaoArterial(11).getData());
        System.out.println("hora: " + pad.buscarPressaoArterial(11).getHora());
    }
}
