package com.example.eco_mobility.Control;

import com.example.eco_mobility.DTO.UtentiDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ObiettivoControl", value = "/ObiettivoControl")
public class ObiettivoControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtentiDTO ut = (UtentiDTO) request.getSession().getAttribute("utente");
        
        String tipoObiettivo= request.getParameter("tipoObiettivo");
        int obiettivo = Integer.parseInt(request.getParameter("obiettivo"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        String scadenza = request.getParameter("scadenza");
        int idUtente= Integer.parseInt(request.getParameter("idUtente"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
