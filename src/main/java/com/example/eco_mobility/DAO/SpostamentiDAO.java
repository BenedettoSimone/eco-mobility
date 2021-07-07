package com.example.eco_mobility.DAO;

import com.example.eco_mobility.DTO.SpostamentiDTO;
import com.example.eco_mobility.DTO.UtentiDTO;
import com.example.eco_mobility.Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SpostamentiDAO {
    static Connection con = DatabaseConnection.getConnection();
    private static final String TABLE_NAME = "Spostamenti";

    public synchronized void doSaveSpostamento(SpostamentiDTO spostamento) throws SQLException{
        PreparedStatement ps = null;

        String query="INSERT INTO "+ SpostamentiDAO.TABLE_NAME+" (data, kmPercorsi, tipoMezzo, idUtente) VALUES (?,?,?,?);";
        ps=con.prepareStatement(query);

        ps.setDate(1,spostamento.getData());
        ps.setInt(2,spostamento.getKmPercorsi());
        ps.setBoolean(3,spostamento.isTipoMezzo());
        ps.setInt(4,spostamento.getIdUtenti());

        ps.executeUpdate();

    }

    public synchronized List<SpostamentiDTO> doRetiveDate(int idUtente) throws SQLException {
        List<SpostamentiDTO> sp = new ArrayList<SpostamentiDTO>();

        PreparedStatement ps = null;

        String query="SELECT DISTINCT data, sum(kmPercorsi) FROM ecomobility.Spostamenti " +
                "WHERE data between (curdate() - INTERVAL DAYOFWEEK(curdate())+6 DAY) AND (curdate()) AND idUtente= ? GROUP BY data order by data desc";

        ps=con.prepareStatement(query);

        ps.setInt(1,idUtente);

        ResultSet rs=ps.executeQuery();

        while(rs.next()){
            SpostamentiDTO spostamenti = new SpostamentiDTO();
            spostamenti.setData(rs.getDate("data"));
            spostamenti.setKmPercorsi(rs.getInt("sum(kmPercorsi)"));

            sp.add(spostamenti);
        }

        return sp;

    }

    public synchronized int doRetriveKMByData(String data, int idUtente) throws SQLException {
        PreparedStatement ps = null;

        String query="SELECT sum(kmPercorsi) FROM ecomobility.Spostamenti WHERE data = ? AND idUtente = ?";

        ps=con.prepareStatement(query);

        ps.setString(1,data);
        ps.setInt(2,idUtente);

        ResultSet rs = ps.executeQuery();

        int km = 0;

        while (rs.next()){
            km=rs.getInt("sum(kmPercorsi)");
        }

        return km;

    }

    public synchronized int doRetriveKmOb(int utente, String dateDa, String dateA) throws SQLException {
        PreparedStatement ps= null;

        String query="SELECT sum(kmPercorsi) FROM ecomobility.Spostamenti where idUtente=? and data between ? and ?;";

        ps=con.prepareStatement(query);

        ps.setInt(1,utente);
        ps.setString(2,dateDa);
        ps.setString(3,dateA);

        ResultSet rs = ps.executeQuery();

        int km=0;

        while(rs.next()){
            km=rs.getInt("sum(kmPercorsi)");
        }

        return km;
    }

    public synchronized  int UtilizzoEcoProgressData(int utente, String dateDa, String dateA) throws SQLException {
        PreparedStatement ps=null;

        String query="SELECT count(tipoMezzo) FROM ecomobility.Spostamenti where tipoMezzo=1 and idUtente=? and data between ? and ?";

        ps=con.prepareStatement(query);

        ps.setInt(1,utente);
        ps.setString(2,dateDa);
        ps.setString(3,dateA);

        ResultSet rs = ps.executeQuery();

        int mezzo=0;
        while(rs.next()){
            mezzo=rs.getInt("count(tipoMezzo)");
        }

        return mezzo;
    }

    public synchronized ArrayList<SpostamentiDTO> doRetriveSpostamenti(int idUtente) throws SQLException {
        PreparedStatement ps=null;

        String query="SELECT * FROM ecomobility.Spostamenti WHERE idUtente=? order by data desc";

        ps=con.prepareStatement(query);

        ps.setInt(1,idUtente);

        ResultSet rs = ps.executeQuery();

        ArrayList<SpostamentiDTO> spostamenti = new ArrayList<>();

        while(rs.next()){
            SpostamentiDTO spostamento = new SpostamentiDTO();

            spostamento.setTipoMezzo(rs.getBoolean("tipoMezzo"));
            spostamento.setData(rs.getDate("data"));
            spostamento.setKmPercorsi(rs.getInt("kmPercorsi"));

            spostamenti.add(spostamento);
        }

        return spostamenti;
    }

    public synchronized ArrayList<SpostamentiDTO> spostamentiByData (String data, int idUtente) throws SQLException {
        PreparedStatement ps=null;


        String query="SELECT * FROM ecomobility.Spostamenti where idUtente="+idUtente+" AND data=\'"+data+"\'";

        ps=con.prepareStatement(query);

        //ps.setString(1,data);
        //ps.setInt(2,idUtente);

        System.out.println(ps);

        ResultSet rs= ps.executeQuery(query);

        ArrayList<SpostamentiDTO> spostamenti = new ArrayList<>();

        while(rs.next()){
            SpostamentiDTO spostamento = new SpostamentiDTO();

            spostamento.setTipoMezzo(rs.getBoolean("tipoMezzo"));
            spostamento.setData(rs.getDate("data"));
            spostamento.setKmPercorsi(rs.getInt("kmPercorsi"));

            spostamenti.add(spostamento);
        }

        return spostamenti;
    }

    public synchronized int doRetriveNumEco(int utente) throws SQLException {
        PreparedStatement ps= null;

        String query="SELECT DISTINCT count(tipoMezzo) " +
                "FROM ecomobility.Spostamenti " +
                "WHERE data between (curdate() - INTERVAL DAYOFWEEK(curdate())+6 DAY) AND (curdate()) AND idUtente= ? and tipoMezzo=1 ;";

        ps=con.prepareStatement(query);

        ps.setInt(1,utente);

        ResultSet rs=ps.executeQuery();

        int count=0;
        while(rs.next()){
            count=rs.getInt("count(tipoMezzo)");
        }

        return count;

    }

}
