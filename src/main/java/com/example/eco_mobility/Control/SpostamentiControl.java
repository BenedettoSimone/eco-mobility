package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.SpostamentiDAO;
import com.example.eco_mobility.DTO.SpostamentiDTO;
import com.example.eco_mobility.DTO.UtentiDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpostamentiControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtentiDTO utente = (UtentiDTO) request.getSession().getAttribute("utente");

        List<SpostamentiDTO> sp = new ArrayList<SpostamentiDTO>();

        SpostamentiDAO spDAO = new SpostamentiDAO();

        //Prendo la data corrente
        long milliseconds = System.currentTimeMillis();
        Date data = new Date(milliseconds);
        String strData = data.toString();

        //Creo un vettore dove salvare i km da posizionare nel grafico della home
        int km[] = new int[7];

        for(int i=0;i<7;i++){
            km[i]=0;
        }

        try {
            //Salvo nell'arraylist i km e i giorni corrispondneti
            sp=spDAO.doRetiveDate(utente.getIdUtenti());

            List<String> dateSP = new ArrayList<String>();

            for (int i=0;i<sp.size();i++){
                dateSP.add(sp.get(i).getData().toString());
            }

            for (int i=0; i<7;i++){
                if(dateSP.contains(strData)){
                    km[i]=spDAO.doRetriveKMByData(strData, utente.getIdUtenti());
                    data= new Date(milliseconds-86400000*(i+1));
                    strData = data.toString();
                }
                else{
                    data= new Date(milliseconds-86400000*(i+1));
                    strData = data.toString();
                }
            }

            int tot=0, media=0;
            for(int i=0;i<7;i++){
                tot=km[i]+tot;
            }
            media=tot/7;

            request.setAttribute("kmSettimanali", km);
            request.getSession().setAttribute("mediaSet", media);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SpeseCarburanteControl");

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
