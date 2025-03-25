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
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setDate(1,Date.valueOf(data));

            rs = ps.executeQuery();

            while (rs.next()){
                PressaoArterial pa = new PressaoArterial();
                pa.setId(rs.getInt("id"));
                pa.setValorPressao(rs.getDouble("valorPressao"));
                pa.setData(rs.getDate("data").toLocalDate());
                pa.setHora(rs.getTime("hora").toLocalTime());

                filtrarPAsData.add(pa);

            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

        return filtrarPAsData;
    }

    @Override
    public List<PressaoArterial> filtrarMaior() {
        String sql = "SELECT * FROM dadosPressaoArterial WHERE valorPressao > 13.9";

        List<PressaoArterial> listaPressaoMaior = new ArrayList<>();

        PreparedStatement ps =  null;

        ResultSet rs = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()){
                PressaoArterial pa = new PressaoArterial();
                pa.setId(rs.getInt("id"));
                pa.setValorPressao(rs.getDouble("valorPressao"));
                pa.setData(rs.getDate("data").toLocalDate());
                pa.setHora(rs.getTime("hora").toLocalTime());

                listaPressaoMaior.add(pa);
            }

            return listaPressaoMaior;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PressaoArterial> filtrarMenor() {
        String sql = "SELECT * FROM dadosPressaoArterial WHERE valorPressao < 11";

        List<PressaoArterial> listaPressaoMenor = new ArrayList<>();

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                PressaoArterial pa = new PressaoArterial();

                pa.setId(rs.getInt("id"));
                pa.setValorPressao(rs.getDouble("valorPressao"));
                pa.setData(rs.getDate("data").toLocalDate());
                pa.setHora(rs.getTime("hora").toLocalTime());

                listaPressaoMenor.add(pa);
            }
            return listaPressaoMenor;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PressaoArterial> filtrarMaiorEmenor(){
        String sql = "SELECT * FROM dadospressaoarterial WHERE valorPressao < 11.0 OR valorPressao > 13.9";

        List<PressaoArterial> listaMenorMaior = new ArrayList<>();

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                PressaoArterial pa = new PressaoArterial();

                pa.setId(rs.getInt("id"));
                pa.setValorPressao(rs.getDouble("valorPressao"));
                pa.setData(rs.getDate("data").toLocalDate());
                pa.setHora(rs.getTime("hora").toLocalTime());

                listaMenorMaior.add(pa);
            }
            return listaMenorMaior;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
