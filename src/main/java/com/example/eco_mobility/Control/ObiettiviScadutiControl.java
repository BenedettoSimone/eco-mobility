package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.ObiettivoDAO;
import com.example.eco_mobility.DAO.SpeseCarburanteDAO;
import com.example.eco_mobility.DAO.SpostamentiDAO;
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

public class ObiettiviScadutiControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObiettivoDAO obDao = new ObiettivoDAO();
        SpostamentiDAO spDao = new SpostamentiDAO();
        List<ObiettiviDTO> ob = new ArrayList<ObiettiviDTO>();
        UtentiDTO ut = (UtentiDTO) request.getSession().getAttribute("utente");

        try {
            //ob è la lista degli obiettivi scaduti
            ob=obDao.RetriveObiettiviScaduti(ut.getIdUtenti());

            for(int i=0;i<ob.size();i++){
                System.out.println(ob.get(i).toString());
            }


            for(int i=0;i<ob.size();i++){
                //Controllo status per Riduzione chilometri
                if(ob.get(i).getTipoObiettivo().equals("Riduzione chilometri")) {

                    Date data = ob.get(i).getScadenza();
                    Date dataS = ob.get(i).getScadenza();
                    dataS = new Date(data.getTime() + 86400000 * (7));

                    int obProgress = spDao.doRetriveKmOb(ut.getIdUtenti(),data.toString(), dataS.toString());

                    if (obProgress <= ob.get(i).getObiettivo()) {

                        obDao.UpdateStatus("completato",ob.get(i).getIdObiettivi());

                    } else {

                        obDao.UpdateStatus("fallito",ob.get(i).getIdObiettivi());
                    }
                }else if(ob.get(i).getTipoObiettivo().equals("Riduzione spesa")){

                    SpeseCarburanteDAO SCDao= new SpeseCarburanteDAO();

                    //Prendo le date
                    Date data = ob.get(i).getScadenza();
                    Date dataS = ob.get(i).getScadenza();
                    dataS = new Date(data.getTime() + 86400000 * (7));

                    int obProgress=SCDao.SpeseProgressByData(ut.getIdUtenti(),data.toString(), dataS.toString());

                    if(obProgress<=ob.get(i).getObiettivo()){
                        obDao.UpdateStatus("completato",ob.get(i).getIdObiettivi());
                    }else{
                        obDao.UpdateStatus("fallito",ob.get(i).getIdObiettivi());
                    }

                }else if(ob.get(i).getTipoObiettivo().equals("Utilizzo mezzo eco")){

                    Date data = ob.get(i).getScadenza();
                    Date dataS = ob.get(i).getScadenza();
                    dataS = new Date(data.getTime() + 86400000 * (7));

                    int mezzoProgress = spDao.UtilizzoEcoProgressData(ut.getIdUtenti(),data.toString(),dataS.toString());

                    if(mezzoProgress<=ob.get(i).getObiettivo()){
                        obDao.UpdateStatus("completato",ob.get(i).getIdObiettivi());
                    }else{
                        obDao.UpdateStatus("fallito",ob.get(i).getIdObiettivi());
                    }
                }
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            dispatcher.forward(request,response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
