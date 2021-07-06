package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.SpeseCarburanteDAO;
import com.example.eco_mobility.DTO.UtentiDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RetriveSpeseControl extends HttpServlet {
    SpeseCarburanteDAO dao=new SpeseCarburanteDAO();
    public RetriveSpeseControl() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UtentiDTO utente= (UtentiDTO) req.getSession().getAttribute("utente");
        int idUtente=utente.getIdUtenti();



        try {
            req.getSession().setAttribute("spese",dao.doRetriveByUser(idUtente));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/speseCarb.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
