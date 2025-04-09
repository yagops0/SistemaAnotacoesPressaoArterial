package controllers;

import dao.PressaoArterialDAO;
import entity.PressaoArterial;

import java.time.LocalDate;

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

    public boolean edicao(PressaoArterial pa){
        try {
            pad.atualizarPressaoArterial(pa);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean exclusao(int id){
        try {
            pad.deletarPressaoArterial(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean busca(int id){
        if(pad.buscarPressaoArterial(id) != null){
            return true;
        }else {
            return false;
        }
    }

}
