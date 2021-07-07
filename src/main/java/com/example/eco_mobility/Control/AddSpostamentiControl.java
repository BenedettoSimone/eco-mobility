package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.SpostamentiDAO;
import com.example.eco_mobility.DTO.SpostamentiDTO;
import com.example.eco_mobility.DTO.UtentiDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class AddSpostamentiControl extends HttpServlet {
    public AddSpostamentiControl() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("sono nella porcdio si servelt");
        UtentiDTO utente = (UtentiDTO) req.getSession().getAttribute("utente");

        String data=req.getParameter("data");
        int km= Integer.parseInt(req.getParameter("km"));
        String mezzo=req.getParameter("mezzo");

        SpostamentiDTO spostamento = new SpostamentiDTO();

        Date data1 = Date.valueOf(data);

        spostamento.setData(data1);
        spostamento.setIdUtenti(utente.getIdUtenti());
        spostamento.setKmPercorsi(km);

        if(mezzo.equalsIgnoreCase("eco")){
            spostamento.setTipoMezzo(true);
        }else {
            spostamento.setTipoMezzo(false);
        }

        SpostamentiDAO spostDao = new SpostamentiDAO();

        try {
            spostDao.doSaveSpostamento(spostamento);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/spostamentiDan.jsp");

        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
