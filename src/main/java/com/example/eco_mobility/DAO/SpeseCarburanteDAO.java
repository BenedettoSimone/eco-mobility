package com.example.eco_mobility.DAO;

import com.example.eco_mobility.DTO.SpeseCarburanteDTO;
import com.example.eco_mobility.DTO.UtentiDTO;
import com.example.eco_mobility.Model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SpeseCarburanteDAO {
    static Connection con = DatabaseConnection.getConnection();
    private static final String TABLE_NAME = "Spesecarburante";

    public synchronized void doSaveSpeseCarburante(SpeseCarburanteDTO spesa) throws SQLException{
        PreparedStatement ps = null;

        String query="INSERT INTO "+ SpeseCarburanteDAO.TABLE_NAME+" (data, euroSpesi, idUtenti) VALUES (?,?,?)";
        ps=con.prepareStatement(query);

        ps.setString(1,spesa.getData());
        ps.setInt(2, spesa.getEuroSpesi());
        ps.setInt(3,spesa.getIdUtenti());

        ps.executeUpdate();

    }

    public synchronized ArrayList<SpeseCarburanteDTO> doRetriveByUser(int idUtente)throws SQLException{
        PreparedStatement ps = null;

        String query="SELECT * FROM "+ SpeseCarburanteDAO.TABLE_NAME+" where idUtenti=?";
        ps=con.prepareStatement(query);

        ps.setInt(1,idUtente);

        ResultSet rs=ps.executeQuery();

        ArrayList <SpeseCarburanteDTO> spese= new ArrayList<>();

        while (rs.next()){
            SpeseCarburanteDTO spesa= new SpeseCarburanteDTO();

            spesa.setEuroSpesi(rs.getInt("euroSpesi"));
            spesa.setData(rs.getString("data"));

            spese.add(spesa);
        }

        return spese;

    }

}
