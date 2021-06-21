package com.example.eco_mobility.DAO;

import com.example.eco_mobility.DTO.PremiDTO;
import com.example.eco_mobility.DTO.UtentiDTO;
import com.example.eco_mobility.Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PremiDAO {
    static Connection con = DatabaseConnection.getConnection();
    private static final String TABLE_NAME = "Premi";

    public synchronized void doSaveUtente(PremiDTO premio) throws SQLException{
        PreparedStatement ps = null;

        String query="INSERT INTO "+ PremiDAO.TABLE_NAME+" (status, idUtenti) VALUES (?,?);";
        ps=con.prepareStatement(query);

        ps.setBoolean(1, premio.isStatus());
        ps.setInt(2,premio.getIdUtenti());

        ps.executeUpdate();

    }


}
