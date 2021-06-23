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

    public synchronized UtentiDTO doRetrivebyEmail(String email) throws SQLException {
        PreparedStatement ps = null;

        UtentiDTO ut = new UtentiDTO();

        String query="SELECT * FROM "+ UtentiDAO.TABLE_NAME + " WHERE email = ?";
        ps=con.prepareStatement(query);

        ps.setString(1,email);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            ut.setIdUtenti(rs.getInt("idUtenti"));
            ut.setNome(rs.getString("nome"));
            ut.setCognome(rs.getString("cognome"));
            ut.setEmail(rs.getString("email"));
            ut.setPassword(rs.getString("password"));
        }

        return ut;

    }


}
