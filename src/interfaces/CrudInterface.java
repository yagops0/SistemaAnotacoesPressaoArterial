package interfaces;

import entity.PressaoArterial;

import java.time.LocalDate;
import java.util.List;

public interface CrudInterface {
    public void cadastrarPressaoArterial(PressaoArterial pressaoArterial);

    public void atualizarPressaoArterial(PressaoArterial pressaoArterial);

    public PressaoArterial buscarPressaoArterial(int id);

   // public void filtrarPorData(LocalDate data);

    public void deletarPressaoArterial(int id);

    /*public List<PressaoArterial> filtrarMaior();

    public List<PressaoArterial> filtrarMenor(float pressao);

    public List<PressaoArterial> listarPressaoArterial();*/

    


}
