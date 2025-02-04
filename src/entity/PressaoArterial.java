package entity;


import java.time.LocalDateTime;

public class PressaoArterial {

    private int id;
    private float valorPressao;
    private LocalDateTime data;
    private LocalDateTime hora;

    public PressaoArterial(){

    }

    public PressaoArterial(int id, float valorPressao, LocalDateTime data, LocalDateTime hora) {
        this.id = id;
        this.valorPressao = valorPressao;
        this.data = data;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public float getValorPressao() {
        return valorPressao;
    }

    public void setValorPressao(float valorPressao) {
        this.valorPressao = valorPressao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
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
