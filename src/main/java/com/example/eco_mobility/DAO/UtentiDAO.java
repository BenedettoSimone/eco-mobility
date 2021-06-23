package com.example.eco_mobility.DAO;

import com.example.eco_mobility.DTO.UtentiDTO;
import com.example.eco_mobility.Model.DatabaseConnection;
import java.sql.*;


public class UtentiDAO {
    static Connection con = DatabaseConnection.getConnection();
    private static final String TABLE_NAME = "Utenti";

    public synchronized int doSaveUtente(UtentiDTO utente) throws SQLException{
        PreparedStatement ps = null;

        String query="INSERT INTO "+UtentiDAO.TABLE_NAME+" (email, password, nome, cognome) VALUES (?,?,?,?);";
        ps=con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1,utente.getEmail());
        ps.setString(2,utente.getPassword());
        ps.setString(3,utente.getNome());
        ps.setString(4,utente.getCognome());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int key= rs.getInt(1);

        return key;

    }


}
