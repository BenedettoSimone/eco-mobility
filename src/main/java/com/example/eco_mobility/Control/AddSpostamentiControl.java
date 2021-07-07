package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.ObiettivoDAO;
import com.example.eco_mobility.DAO.SpostamentiDAO;
import com.example.eco_mobility.DTO.ObiettiviDTO;
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
        UtentiDTO utente = (UtentiDTO) req.getSession().getAttribute("utente");

        String data=req.getParameter("data");
        int km= Integer.parseInt(req.getParameter("km"));
        String mezzo=req.getParameter("mezzo");


        int idUtente=utente.getIdUtenti();

        ObiettivoDAO ob = new ObiettivoDAO();
        ObiettiviDTO obiettivo = new ObiettiviDTO();
        try {
            obiettivo=ob.obiettiviPerFiltroInCorso("Riduzione chilometri",idUtente);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //scandenza obiettivo
        Date scadenza= obiettivo.getScadenza();
        long mill= scadenza.getTime();

        //calcolo 8 giorni prima( inizio obiettivo -1)
        Date inizio= new Date(mill -86400000*(8));


        java.sql.Date date1 =Date.valueOf(data);//converting string into sql date


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
            if(spostamento.isTipoMezzo()==true){

                if(data1.after(inizio)){
                    ob.UpdateProgresso(obiettivo.getProgresso()+1, obiettivo.getIdObiettivi());
                }
            }

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
