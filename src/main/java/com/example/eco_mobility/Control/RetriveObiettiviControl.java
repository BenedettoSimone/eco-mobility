package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.ObiettivoDAO;
import com.example.eco_mobility.DAO.SpostamentiDAO;
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
        SpostamentiDAO spDAO = new SpostamentiDAO();

        request.getSession().setAttribute("page","ob");

        try {
            request.setAttribute("obiettivi",obDAO.doRetriveObiettivi(ut.getIdUtenti()));

            request.getSession().setAttribute("countMezzo",spDAO.doRetriveNumEco(ut.getIdUtenti()));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ObiettiviScadutiControl");

        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
