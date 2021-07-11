package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.ObiettivoDAO;
import com.example.eco_mobility.DTO.UtentiDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

public class FiltroControl extends HttpServlet {
    static ObiettivoDAO obDao = new ObiettivoDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UtentiDTO ut = (UtentiDTO) request.getSession().getAttribute("utente");

        String filter = request.getParameter("filter");

        if(filter!=null && filter.equals("chilometri") || filter.equals("spesa") || filter.equals("mezzo")){
            request.removeAttribute("obiettivi");
            try {
                request.setAttribute("obiettivi",obDao.obiettiviPerFiltro(filter,ut.getIdUtenti()));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(filter.equals("allObb")){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RetriveObiettiviControl");
            dispatcher.forward(request,response);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/obiettivi.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
