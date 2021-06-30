package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.SpeseCarburanteDAO;
import com.example.eco_mobility.DTO.SpeseCarburanteDTO;
import com.example.eco_mobility.DTO.UtentiDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpeseCarburanteControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtentiDTO utente = (UtentiDTO) request.getSession().getAttribute("utente");

        List<SpeseCarburanteDTO> spese = new ArrayList<SpeseCarburanteDTO>();

        SpeseCarburanteDAO spDao = new SpeseCarburanteDAO();

        //Prendo la data corrente
        long milliseconds = System.currentTimeMillis();
        Date data = new Date(milliseconds);
        String strData = data.toString();

        //Creo un vettore dove salvare le spese carburante
        int sp[] = new int[7];

        for(int i=0;i<7;i++){
            sp[i]=0;
        }

        try {
            spese=spDao.doRetriveEuroSpesi(utente.getIdUtenti());

            List<String> dateSC = new ArrayList<String>();

            for (int i=0;i<spese.size();i++){
                dateSC.add(spese.get(i).getData().toString());
            }

            for (int i=0; i<7;i++){
                if(dateSC.contains(strData)){
                    sp[i]= spDao.doRetriveSpeseByData(strData, utente.getIdUtenti());
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
                tot=sp[i]+tot;
            }
            media=tot/7;

            request.setAttribute("speseSettimanali", sp);
            request.setAttribute("mediaSpCarburante", media);

            for(int i=0;i<7;i++) {
                System.out.println(sp[i]);
            }
            System.out.println(media);

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
