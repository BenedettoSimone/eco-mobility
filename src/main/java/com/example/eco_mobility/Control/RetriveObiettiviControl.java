package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.ObiettivoDAO;
import com.example.eco_mobility.DTO.ObiettiviDTO;
import com.example.eco_mobility.DTO.UtentiDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RetriveObiettiviControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObiettivoDAO obDAO = new ObiettivoDAO();
        UtentiDTO ut = (UtentiDTO) request.getSession().getAttribute("utente");

        try {
            request.getSession().setAttribute("obiettivi",obDAO.doRetriveObiettivi(ut.getIdUtenti()));

            //avanzamento km per obiettivi in corso
            request.getSession().setAttribute("progressKm",obDAO.doRetriveProgressKm(ut.getIdUtenti()));

            //avanzamento utilizzo mezzo eco
            request.getSession().setAttribute("progressMezzo",obDAO.doRetriveProgressMezzoEco(ut.getIdUtenti()));

            //avanzamento spese carburante
            request.getSession().setAttribute("progressEuro",obDAO.doRetriveProgressCarburante(ut.getIdUtenti()));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/obiettivi.jsp");

        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
