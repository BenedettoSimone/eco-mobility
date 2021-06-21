package com.example.eco_mobility.DAO;

import com.example.eco_mobility.DTO.SpostamentiDTO;
import com.example.eco_mobility.DTO.UtentiDTO;
import com.example.eco_mobility.Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SpostamentiDAO {
    static Connection con = DatabaseConnection.getConnection();
    private static final String TABLE_NAME = "Spostamenti";

    public synchronized void doSaveSpostamento(SpostamentiDTO spostamento) throws SQLException{
        PreparedStatement ps = null;

        String query="INSERT INTO "+ SpostamentiDAO.TABLE_NAME+" ( dat, kmPercorsi, tipoMezzo, idUtenti) VALUES (?,?,?,?);";
        ps=con.prepareStatement(query);

        ps.setDate(1,spostamento.getData());
        ps.setInt(2,spostamento.getKmPercorsi());
        ps.setBoolean(3,spostamento.isTipoMezzo());
        ps.setInt(4,spostamento.getIdUtenti());

        ps.executeUpdate();

    }


}
