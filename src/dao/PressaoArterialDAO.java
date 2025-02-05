package dao;

import conexao.Conexao;
import entity.PressaoArterial;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class PressaoArterialDAO {

    public void cadastrarPressaoArterial(PressaoArterial pressaoArterial){
        String sql = "INSERT INTO dadosPressaoArterial (valorPressao, data, hora) VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setDouble(1, pressaoArterial.getValorPressao());
            ps.setDate(2, Date.valueOf(pressaoArterial.getData()));
            ps.setTime(3, Time.valueOf(pressaoArterial.getHora()));

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
