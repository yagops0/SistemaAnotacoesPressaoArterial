package controllers;

import dao.PressaoArterialDAO;
import entity.PressaoArterial;

public class PressaoArterialController {
    PressaoArterialDAO pad = new PressaoArterialDAO();

    public boolean cadastro(PressaoArterial pressaoArterial){
        try {
            pad.cadastrarPressaoArterial(pressaoArterial);
            return true;
        }catch (Exception e1){
            System.out.println("Erro" + e1);
            return false;
        }
    }
}
