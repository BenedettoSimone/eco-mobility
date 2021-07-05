package com.example.eco_mobility.DAO;

import com.example.eco_mobility.DTO.ObiettiviDTO;
import com.example.eco_mobility.DTO.UtentiDTO;
import com.example.eco_mobility.Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ObiettivoDAO {
    static Connection con = DatabaseConnection.getConnection();
    private static final String TABLE_NAME = "Obiettivi";

    public synchronized void doSaveObiettivi(ObiettiviDTO obiettivo) throws SQLException{
        PreparedStatement ps = null;

        String query="INSERT INTO "+ ObiettivoDAO.TABLE_NAME+" (tipoObiettivi, obiettivo, status, scadenza, idUtenti, progresso) VALUES (?,?,?,?,?,?);";
        ps=con.prepareStatement(query);

        ps.setString(1,obiettivo.getTipoObiettivo());
        ps.setInt(2,obiettivo.getObiettivo());
        ps.setString(3,obiettivo.getStatus());
        ps.setDate(4,obiettivo.getScadenza());
        ps.setInt(5,obiettivo.getIdUtenti());
        ps.setInt(6,obiettivo.getProgresso());


        ps.executeUpdate();

    }

    public synchronized List<ObiettiviDTO> doRetriveObiettivi(int utente) throws SQLException {
        List<ObiettiviDTO> obiettivi = new ArrayList<ObiettiviDTO>();
        PreparedStatement ps = null;

        String query="SELECT * FROM "+ ObiettivoDAO.TABLE_NAME+" WHERE idUtenti= ? ";

        ps=con.prepareStatement(query);

        ps.setInt(1,utente);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            ObiettiviDTO ob = new ObiettiviDTO();
            ob.setIdObiettivi((rs.getInt("idObiettivi")));
            ob.setTipoObiettivo(rs.getString("tipoObiettivi"));
            ob.setObiettivo(rs.getInt("obiettivo"));
            ob.setScadenza(rs.getDate("scadenza"));
            ob.setIdUtenti(rs.getInt("idUtenti"));
            ob.setStatus(rs.getString("status"));
            ob.setProgresso(rs.getInt("progresso"));

            obiettivi.add(ob);
        }
        return obiettivi;
    }

    public synchronized List<ObiettiviDTO> doRetriveObiettiviInCorso(int utente) throws SQLException {
        List<ObiettiviDTO> obiettivi = new ArrayList<ObiettiviDTO>();
        PreparedStatement ps = null;

        String query="SELECT * FROM "+ ObiettivoDAO.TABLE_NAME+" WHERE idUtenti= ? and current_date()<=scadenza ";

        ps=con.prepareStatement(query);

        ps.setInt(1,utente);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            ObiettiviDTO ob = new ObiettiviDTO();
            ob.setIdObiettivi((rs.getInt("idObiettivi")));
            ob.setTipoObiettivo(rs.getString("tipoObiettivi"));
            ob.setObiettivo(rs.getInt("obiettivo"));
            ob.setScadenza(rs.getDate("scadenza"));
            ob.setIdUtenti(rs.getInt("idUtenti"));
            ob.setStatus(rs.getString("status"));
            ob.setProgresso(rs.getInt("progresso"));

            obiettivi.add(ob);
        }
        return obiettivi;
    }

    public synchronized int doRetriveProgressKm(int utente) throws SQLException {
        PreparedStatement ps = null;

        String query="SELECT sum(kmPercorsi) FROM ecomobility.Spostamenti where current_date()<=data+7 and idUtente= ?  ";

        ps=con.prepareStatement(query);

        ps.setInt(1,utente);

        ResultSet rs = ps.executeQuery();

        int km=0;

        while(rs.next()){
            km=rs.getInt("sum(kmPercorsi)");
        }

        return km;
    }

    public synchronized int doRetriveProgressMezzoEco(int utente) throws SQLException {
        PreparedStatement ps = null;

        String query="SELECT count(*) as mezzo FROM ecomobility.Spostamenti where current_date()<=data+7 and tipoMezzo='1' and idUtente=?";

        ps=con.prepareStatement(query);

        ps.setInt(1,utente);

        ResultSet rs = ps.executeQuery();

        int eco=0;

        while(rs.next()){
            eco=rs.getInt("mezzo");
        }

        return eco;
    }

    public synchronized int doRetriveProgressCarburante(int utente) throws SQLException {
        PreparedStatement ps = null;

        String query="SELECT sum(euroSpesi) FROM ecomobility.SpeseCarburante where current_date()<=data+7 and idUtenti=?";

        ps=con.prepareStatement(query);

        ps.setInt(1,utente);

        ResultSet rs = ps.executeQuery();

        int euro=0;

        while(rs.next()){
            euro=rs.getInt("sum(euroSpesi)");
        }

        return euro;
    }

    public synchronized List<ObiettiviDTO> obiettiviPerFiltro(String fil, int ut) throws SQLException {
        PreparedStatement ps=null;
        List<ObiettiviDTO> obiettivi =  new ArrayList<ObiettiviDTO>();

        String query="SELECT * FROM ecomobility.Obiettivi where tipoObiettivi like \"%"+fil+"%\" and idUtenti=?;";

        ps=con.prepareStatement(query);

        ps.setInt(1,ut);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            ObiettiviDTO ob = new ObiettiviDTO();
            ob.setIdObiettivi((rs.getInt("idObiettivi")));
            ob.setTipoObiettivo(rs.getString("tipoObiettivi"));
            ob.setObiettivo(rs.getInt("obiettivo"));
            ob.setScadenza(rs.getDate("scadenza"));
            ob.setIdUtenti(rs.getInt("idUtenti"));
            ob.setStatus(rs.getString("status"));
            ob.setProgresso(rs.getInt("progresso"));

            obiettivi.add(ob);
        }

        return obiettivi;
    }

    public synchronized ObiettiviDTO obiettiviPerFiltroInCorso(String fil, int ut) throws SQLException {
        PreparedStatement ps=null;

        String query="SELECT * FROM ecomobility.Obiettivi where tipoObiettivi like \"%"+fil+"%\" and idUtenti=? and status='in corso';";

        ps=con.prepareStatement(query);

        ps.setInt(1,ut);

        ResultSet rs = ps.executeQuery();

        ObiettiviDTO ob = new ObiettiviDTO();

        while(rs.next()){

            ob.setIdObiettivi((rs.getInt("idObiettivi")));
            ob.setTipoObiettivo(rs.getString("tipoObiettivi"));
            ob.setObiettivo(rs.getInt("obiettivo"));
            ob.setScadenza(rs.getDate("scadenza"));
            ob.setIdUtenti(rs.getInt("idUtenti"));
            ob.setStatus(rs.getString("status"));
            ob.setProgresso(rs.getInt("progresso"));
        }

        return ob;
    }

    public synchronized List<ObiettiviDTO> RetriveObiettiviScaduti(int utente) throws SQLException {
        PreparedStatement ps = null;
        List<ObiettiviDTO> obiettivi =  new ArrayList<ObiettiviDTO>();

        String query="SELECT * FROM ecomobility.Obiettivi WHERE scadenza < (curdate() - interval dayofweek(curdate())+6 day) and idUtenti=? and status=\"in corso\"";

        ps=con.prepareStatement(query);

        ps.setInt(1,utente);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            ObiettiviDTO ob = new ObiettiviDTO();
            ob.setIdObiettivi((rs.getInt("idObiettivi")));
            ob.setTipoObiettivo(rs.getString("tipoObiettivi"));
            ob.setObiettivo(rs.getInt("obiettivo"));
            ob.setScadenza(rs.getDate("scadenza"));
            ob.setIdUtenti(rs.getInt("idUtenti"));
            ob.setStatus(rs.getString("status"));
            ob.setProgresso(rs.getInt("progresso"));

            obiettivi.add(ob);
        }

        return obiettivi;
    }

    public synchronized void UpdateStatus(String status, int obiettivo) throws SQLException {
        PreparedStatement ps=null;

        String query="UPDATE `ecomobility`.`Obiettivi` SET `status` = ? WHERE (`idObiettivi` = ?)";

        ps=con.prepareStatement(query);

        ps.setString(1,status);
        ps.setInt(2,obiettivo);

        ps.executeUpdate();
    }

    public synchronized  void UpdateProgresso(int tot, int obieettivo) throws SQLException {
        PreparedStatement ps=null;

        String query="UPDATE `ecomobility`.`Obiettivi` SET `progresso` = ? WHERE (`idObiettivi` = ?)";

        ps=con.prepareStatement(query);

        ps.setInt(1,tot);
        ps.setInt(2,obieettivo);

        ps.executeUpdate();

    }

}
