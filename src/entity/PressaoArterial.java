package entity;


import java.time.LocalDate;
import java.time.LocalTime;

public class PressaoArterial {

    private int id;
    private double valorPressao;
    private LocalDate data;
    private LocalTime hora;

    public PressaoArterial(){

    }

    public PressaoArterial(int id, double valorPressao, LocalDate data, LocalTime hora) {
        this.id = id;
        this.valorPressao = valorPressao;
        this.data = data;
        this.hora = hora;
    }

    public PressaoArterial(double valorPressao, LocalDate data, LocalTime hora) {
        this.valorPressao = valorPressao;
        this.data = data;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public double getValorPressao() {
        return valorPressao;
    }

    public void setValorPressao(double valorPressao) {
        this.valorPressao = valorPressao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString(){
        return "id - " + this.id +
                "\nPresao Arterial - " + this.valorPressao +
                "\nData - " + this.data +
                "\nHora - " + this.hora;
    }
}
