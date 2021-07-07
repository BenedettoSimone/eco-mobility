package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.SpostamentiDAO;
import com.example.eco_mobility.DTO.UtentiDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SearchSpostamentiByDateControl extends HttpServlet {
    public SearchSpostamentiByDateControl() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UtentiDTO utente = (UtentiDTO) req.getSession().getAttribute("utente");

        String data=req.getParameter("data");


        SpostamentiDAO spostDao = new SpostamentiDAO();

        if(data.isEmpty()){
            try {
                req.getSession().setAttribute("retriveSpost",spostDao.doRetriveSpostamenti(utente.getIdUtenti()));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/spostamentiDan.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        try {
            req.getSession().setAttribute("retriveSpost",spostDao.spostamentiByData(data, utente.getIdUtenti()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/spostamentiDan.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
