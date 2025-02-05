import dao.PressaoArterialDAO;
import entity.PressaoArterial;

import java.time.LocalDate;
import java.time.LocalTime;

public class MainTeste {
    public static void main(String[] args) {

        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.now();

        PressaoArterial pa1 = new PressaoArterial(13.2, data, hora);

        new PressaoArterialDAO().cadastrarPressaoArterial(pa1);
    }
}
