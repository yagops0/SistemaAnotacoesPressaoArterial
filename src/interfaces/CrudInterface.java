package interfaces;

import entity.PressaoArterial;

import java.time.LocalDate;
import java.util.List;

public interface CrudInterface {
    public void cadastrarPressaoArterial(PressaoArterial pressaoArterial);

    public PressaoArterial buscarPressaoArterial(int id);

    public void atualizarPressaoArterial(PressaoArterial pressaoArterial);

    public void deletarPressaoArterial(int id);

    public void deletarTudo();

    public List<PressaoArterial> listarPressaoArterial();

    public List<PressaoArterial> filtrarPorData(LocalDate data);

    // RETORNAR VALORES ACIMA DE 13
    public List<PressaoArterial> filtrarMaior();

    // RETORNAR VALORES ABAIXO DE 11
    public List<PressaoArterial> filtrarMenor();

    public List<PressaoArterial> filtrarMaiorEmenor();


}
