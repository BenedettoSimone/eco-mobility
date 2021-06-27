package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.ObiettivoDAO;
import com.example.eco_mobility.DTO.ObiettiviDTO;
import com.example.eco_mobility.DTO.UtentiDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "ObiettivoControl", value = "/ObiettivoControl")
public class ObiettivoControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtentiDTO ut = (UtentiDTO) request.getSession().getAttribute("utente");
        ObiettiviDTO ob = new ObiettiviDTO();
        ObiettivoDAO obDAO = new ObiettivoDAO();

        int obiettivo = Integer.parseInt(request.getParameter("obiettivo"));
        int action = Integer.parseInt(request.getParameter("action"));

        //Prendo la data corrente e aggiungo 7 giorni
        long milliseconds = System.currentTimeMillis();
        Date data = new Date(milliseconds+86400000*(7));

        try {
            if(action==1) {
                ob.setTipoObiettivo("Obiettivo riduzione chilometri");
                ob.setObiettivo(obiettivo);
                ob.setIdUtenti(ut.getIdUtenti());
                ob.setScadenza(data);
                ob.setStatus(false);

                obDAO.doSaveObiettivi(ob);

            }else if(action==2) {
                ob.setTipoObiettivo("Obiettivo riduzione spese carburante");
                ob.setObiettivo(obiettivo);
                ob.setIdUtenti(ut.getIdUtenti());
                ob.setScadenza(data);
                ob.setStatus(false);

                obDAO.doSaveObiettivi(ob);
            }else if(action==3){
                ob.setTipoObiettivo("Obiettivo utilizzo mezzo ECO-SOSTENIBILE");
                ob.setObiettivo(obiettivo);
                ob.setIdUtenti(ut.getIdUtenti());
                ob.setScadenza(data);
                ob.setStatus(false);

                obDAO.doSaveObiettivi(ob);
            }


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
