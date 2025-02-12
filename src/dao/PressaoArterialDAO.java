package dao;

import conexao.Conexao;
import entity.PressaoArterial;
import interfaces.CrudInterface;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<PressaoArterial> listarPressaoArterial(){
        String sql = "SELECT *  FROM dadosPressaoArterial";

        PreparedStatement ps = null;

        ResultSet rs = null;

        List<PressaoArterial> pressaoArterials = new ArrayList<>();

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                PressaoArterial pa = new PressaoArterial();

                pa.setId(rs.getInt("id"));
                pa.setValorPressao(rs.getDouble("valorPressao"));
                pa.setData(rs.getDate("data").toLocalDate());
                pa.setHora(rs.getTime("hora").toLocalTime());

                pressaoArterials.add(pa);

            }

            if (rs != null){
                rs.close();
            }

            if (ps != null){
                ps.close();
            }


        }catch (SQLException e){
            e.printStackTrace();
            return  null;
        }

        return pressaoArterials;
    }

    @Override
    public List<PressaoArterial> filtrarPorData(LocalDate data) {
        String sql = "SELECT * FROM dadosPressaoArterial WHERE data = ?";

        List<PressaoArterial> filtrarPAsData = new ArrayList<>();

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            PressaoArterial pa = new PressaoArterial();
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setDate(1,Date.valueOf(data));

            rs = ps.executeQuery();

            while (rs.next()){
                pa.setId(rs.getInt("id"));
                pa.setValorPressao(rs.getDouble("valorPressao"));
                pa.setData(rs.getDate("data").toLocalDate());
                pa.setHora(rs.getTime("hora").toLocalTime());

                filtrarPAsData.add(pa);

                if (ps != null){
                    ps.close();
                }

                if (rs != null){
                    rs.close();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

        return filtrarPAsData;
    }
}
