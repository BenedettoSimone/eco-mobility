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
        String page="spostamenti";
        req.getSession().setAttribute("page","spostamenti");



        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RetriveSpostamentiControl");

        int idUtente=utente.getIdUtenti();

        //obiettivo km
        ObiettivoDAO ob = new ObiettivoDAO();
        ObiettiviDTO obiettivo = new ObiettiviDTO();


        //obiettivo mezzo
        ObiettivoDAO ob1 = new ObiettivoDAO();
        ObiettiviDTO obiettivo1 = new ObiettiviDTO();
        try {
            obiettivo=ob.obiettiviPerFiltroInCorso("Riduzione chilometri",idUtente);
            obiettivo1=ob1.obiettiviPerFiltroInCorso("Utilizzo mezzo eco",idUtente);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



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
            req.setAttribute("addSpost", "successo");

            if(obiettivo.getScadenza()!=null){
                //scandenza obiettivo riduzione chilometri
                Date scadenza= obiettivo.getScadenza();
                long mill= scadenza.getTime();

                //calcolo 8 giorni prima( inizio obiettivo -1)
                Date inizio= new Date(mill -86400000*(8));
                java.sql.Date date1 =Date.valueOf(data);//converting string into sql date

                if(date1.after(inizio)){
                    ob.UpdateProgresso(obiettivo.getProgresso()+km, obiettivo.getIdObiettivi());
                }
            }

            if(obiettivo1.getScadenza()!=null){
                //scandenza obiettivo utilizzo eco
                Date scadenza1= obiettivo1.getScadenza();
                long mill1= scadenza1.getTime();

                //calcolo 8 giorni prima( inizio obiettivo -1)
                Date inizio1= new Date(mill1 -86400000*(8));
                java.sql.Date date2 =Date.valueOf(data);//converting string into sql date

                if(spostamento.isTipoMezzo()==true){

                    if(date2.after(inizio1)){

                        ob1.UpdateProgresso(obiettivo1.getProgresso()+1, obiettivo1.getIdObiettivi());
                    }

                }

            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            req.setAttribute("addSpost", "fallito");
        }

        if(page!=null && page.equalsIgnoreCase("spostamenti")) {
            dispatcher = getServletContext().getRequestDispatcher("/ObiettiviScadutiControl");
        }




        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
