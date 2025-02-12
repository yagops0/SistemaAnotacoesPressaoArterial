package interfaces;

import entity.PressaoArterial;

import java.time.LocalDate;
import java.util.List;

public interface CrudInterface {
    public void cadastrarPressaoArterial(PressaoArterial pressaoArterial);

    public PressaoArterial buscarPressaoArterial(int id);

    public void atualizarPressaoArterial(PressaoArterial pressaoArterial);

    public void deletarPressaoArterial(int id);

    public List<PressaoArterial> listarPressaoArterial();

    public List<PressaoArterial> filtrarPorData(LocalDate data);

    /*public List<PressaoArterial> filtrarMaior(double pressaa);

    public List<PressaoArterial> filtrarMenor(double pressao);*/


}
