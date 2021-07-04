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


public class AddSpeseControl extends HttpServlet {
    SpeseCarburanteDAO dao= new SpeseCarburanteDAO();
    public AddSpeseControl(){ super();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String data = req.getParameter("data");
        int euro =Integer.parseInt(req.getParameter("euro"));
        System.out.println("d "+ data);
        System.out.println("eur "+euro);




        UtentiDTO utente= (UtentiDTO) req.getSession().getAttribute("utente");
        int idUtente=utente.getIdUtenti();

        SpeseCarburanteDTO spesa= new SpeseCarburanteDTO();

        spesa.setData(data);
        spesa.setEuroSpesi(euro);
        spesa.setIdUtenti(idUtente);


        try {
            dao.doSaveSpeseCarburante(spesa);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.getSession().setAttribute("spese",null);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/speseCarb.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
