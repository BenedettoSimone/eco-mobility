package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.SpeseCarburanteDAO;
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

public class SearchSpeseByDateControl extends HttpServlet {
    public SearchSpeseByDateControl() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UtentiDTO ut = (UtentiDTO) req.getSession().getAttribute("utente");
        String data = req.getParameter("data");
        SpeseCarburanteDAO speseDao= new SpeseCarburanteDAO();

        //nessuna data selezionata
        if (data.isEmpty()){
            try {
                req.getSession().setAttribute("spese",speseDao.doRetriveByUser(ut.getIdUtenti()));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/speseCarb.jsp");
            dispatcher.forward(req, resp);
            return;
        }



        try {
            req.getSession().setAttribute("spese",speseDao.speseByData(data, ut.getIdUtenti()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/speseCarb.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
