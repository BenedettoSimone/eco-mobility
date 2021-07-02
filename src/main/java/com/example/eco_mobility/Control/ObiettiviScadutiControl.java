package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.ObiettivoDAO;
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
            ob=obDao.RetriveObiettiviScaduti(ut.getIdUtenti());

            for(int i=0;i<ob.size();i++){
                System.out.println(ob.get(i).toString());
            }

            //Controllo status per Riduzione chilometri
            for(int i=0;i<ob.size();i++){
                if(ob.get(i).getTipoObiettivo().equals("Riduzione chilometri")) {

                    Date data = ob.get(i).getScadenza();
                    Date dataS = ob.get(i).getScadenza();
                    dataS = new Date(data.getTime() + 86400000 * (7));

                    int obProgress = spDao.doRetriveKmOb(data.toString(), dataS.toString());
                    System.out.println("data da " + data.toString() + " a: " + dataS.toString());
                    System.out.println("Obiettivo progresso: " + obProgress);

                    if (obProgress <= ob.get(i).getObiettivo()) {
                        System.out.println("Setta l'obirttivo come completato");
                        obDao.UpdateStatus("completato",ob.get(i).getIdObiettivi());

                    } else {
                        System.out.println("Fallito");
                        obDao.UpdateStatus("fallito",ob.get(i).getIdObiettivi());
                    }
                }
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
