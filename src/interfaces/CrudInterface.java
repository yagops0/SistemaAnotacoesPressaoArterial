package interfaces;

import entity.PressaoArterial;

import java.time.LocalDate;

public interface CrudInterface {
    public void cadastrarPressaoArterial(PressaoArterial pressaoArterial);

    public void atualizarPressaoArterial(int id);

    public void buscarPressaoArterial(int id);

    public void filtrarPorData(LocalDate data);

    public void deletarPressaoArterial(int id);

    public void filtrarMaior(float pressao);

    public void filtrarMenor(float pressao);


}
