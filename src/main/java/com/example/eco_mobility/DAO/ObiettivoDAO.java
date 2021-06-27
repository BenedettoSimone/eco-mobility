package com.example.eco_mobility.DAO;

import com.example.eco_mobility.DTO.ObiettiviDTO;
import com.example.eco_mobility.DTO.UtentiDTO;
import com.example.eco_mobility.Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ObiettivoDAO {
    static Connection con = DatabaseConnection.getConnection();
    private static final String TABLE_NAME = "Obiettivi";

    public synchronized void doSaveObiettivi(ObiettiviDTO obiettivo) throws SQLException{
        PreparedStatement ps = null;

        String query="INSERT INTO "+ ObiettivoDAO.TABLE_NAME+" (tipoObiettivi, obiettivo, status, scadenza, idUtenti) VALUES (?,?,?,?,?);";
        ps=con.prepareStatement(query);

        ps.setString(1,obiettivo.getTipoObiettivo());
        ps.setInt(2,obiettivo.getObiettivo());
        ps.setBoolean(3,obiettivo.isStatus());
        ps.setDate(4,obiettivo.getScadenza());
        ps.setInt(5,obiettivo.getIdUtenti());


        ps.executeUpdate();

    }


}
