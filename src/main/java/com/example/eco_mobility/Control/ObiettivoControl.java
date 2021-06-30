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
import java.util.ArrayList;
import java.util.List;

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
            List<ObiettiviDTO>obiettivi=new ArrayList<ObiettiviDTO>();
            obiettivi=obDAO.doRetriveObiettivi(ut.getIdUtenti());

            for(int i=0;i<obiettivi.size();i++){
                if(action==1 && obiettivi.get(i).getTipoObiettivo().equalsIgnoreCase("Riduzione chilometri")){
                    action=0;
                }
                if(action==2 && obiettivi.get(i).getTipoObiettivo().equalsIgnoreCase("Riduzione spesa")){
                    action=0;
                }
                if(action==3 && obiettivi.get(i).getTipoObiettivo().equalsIgnoreCase("Utilizzo mezzo eco")){
                    action=0;
                }

            }

            if(action==1) {
                ob.setTipoObiettivo("Riduzione chilometri");
                ob.setObiettivo(obiettivo);
                ob.setIdUtenti(ut.getIdUtenti());
                ob.setScadenza(data);
                ob.setStatus(false);

                obDAO.doSaveObiettivi(ob);

            }else if(action==2) {
                ob.setTipoObiettivo("Riduzione spesa");
                ob.setObiettivo(obiettivo);
                ob.setIdUtenti(ut.getIdUtenti());
                ob.setScadenza(data);
                ob.setStatus(false);

                obDAO.doSaveObiettivi(ob);
            }else if(action==3){
                ob.setTipoObiettivo("Utilizzo mezzo eco");
                ob.setObiettivo(obiettivo);
                ob.setIdUtenti(ut.getIdUtenti());
                ob.setScadenza(data);
                ob.setStatus(false);

                obDAO.doSaveObiettivi(ob);
            }else if(action==0){
                request.setAttribute("ErrObiettivo", "true");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RetriveObiettiviControl");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
