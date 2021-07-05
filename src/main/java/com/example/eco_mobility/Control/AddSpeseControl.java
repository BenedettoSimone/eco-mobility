package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.ObiettivoDAO;
import com.example.eco_mobility.DAO.SpeseCarburanteDAO;
import com.example.eco_mobility.DTO.ObiettiviDTO;
import com.example.eco_mobility.DTO.SpeseCarburanteDTO;
import com.example.eco_mobility.DTO.UtentiDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AddSpeseControl extends HttpServlet {
    SpeseCarburanteDAO dao= new SpeseCarburanteDAO();
    public AddSpeseControl(){ super();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        String data = req.getParameter("data");
        int euro =Integer.parseInt(req.getParameter("euro"));

        UtentiDTO utente= (UtentiDTO) req.getSession().getAttribute("utente");
        int idUtente=utente.getIdUtenti();

        ObiettivoDAO ob = new ObiettivoDAO();
        ObiettiviDTO obiettivo = new ObiettiviDTO();
        try {
            obiettivo=ob.obiettiviPerFiltroInCorso("Riduzione Spesa",idUtente);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        SpeseCarburanteDTO spesa= new SpeseCarburanteDTO();

        spesa.setData(data);
        spesa.setEuroSpesi(euro);
        spesa.setIdUtenti(idUtente);


        try {
            dao.doSaveSpeseCarburante(spesa);
            req.setAttribute("addSpesa","successo");

            ob.UpdateProgresso(obiettivo.getProgresso()+euro, obiettivo.getIdObiettivi());



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            req.setAttribute("addSpesa","fallito");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RetriveSpeseControl");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
