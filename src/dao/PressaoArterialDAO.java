package dao;

import conexao.Conexao;
import entity.PressaoArterial;
import interfaces.CrudInterface;

import java.sql.*;
import java.time.LocalDate;

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
    public PressaoArterial buscarPressaoArterial(int id){
        String sql = "SELECT * FROM dadosPressaoArterial WHERE id = ?";

        PreparedStatement ps = null;
        ResultSet rst = null;

        PressaoArterial pa = new PressaoArterial();

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            rst = ps.executeQuery();

            if (rst.next()){
                pa.setId(rst.getInt("id"));
                pa.setValorPressao(rst.getDouble("valorPressao"));
                pa.setData(rst.getDate("data").toLocalDate());
                pa.setHora(rst.getTime("hora").toLocalTime());

                return pa;
            }else{
                return null;
            }


        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void atualizarPressaoArterial(PressaoArterial pressaoArterial) {
        String sql = "UPDATE dadosPressaoArterial SET valorPressao = ?, data = ?, hora = ? " +
                "WHERE id = ?";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setDouble(1, pressaoArterial.getValorPressao());
            ps.setDate(2, Date.valueOf(pressaoArterial.getData()));
            ps.setTime(3, Time.valueOf(pressaoArterial.getHora()));

            ps.setInt(4, pressaoArterial.getId());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletarPressaoArterial(int id) {
        String sql = "DELETE FROM dadosPressaoArterial WHERE id = ?";

        PreparedStatement ps = null;
        try {
            Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
