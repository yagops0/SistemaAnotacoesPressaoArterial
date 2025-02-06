package dao;

import conexao.Conexao;
import entity.PressaoArterial;
import interfaces.CrudInterface;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class PressaoArterialDAO implements CrudInterface {

    @Override
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

    @Override
    public void buscarPressaoArterial(int id) {
            String sql = "SELECT * FROM dadosPresaoArterial WHERE id = ?";

            PreparedStatement ps = null;

            try{
                ps = Conexao.getConexao().prepareStatement(sql);
                ps.setInt(1, id);

            }catch (SQLException e){
                e.printStackTrace();

            }
    }
}
