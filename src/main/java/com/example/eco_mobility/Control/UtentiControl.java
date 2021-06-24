package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.UtentiDAO;
import com.example.eco_mobility.DTO.UtentiDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;


public class UtentiControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //DAO utenti
        UtentiDAO utDao= new UtentiDAO();

        //Prelevo i parametri dalla request
        String nome= request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email= request.getParameter("email");
        String password = request.getParameter("password");

        //Controllo che siano pieni tutti i campi
        if((nome != null) && (cognome!=null) && (email!=null) && (password!=null)){

            try {
                UtentiDTO ut= new UtentiDTO(0,email,password,nome,cognome);
                int key=utDao.doSaveUtente(ut);
                ut.setIdUtenti(key);

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                request.setAttribute("messageRegistrazione", "true");
                dispatcher.forward(request, response);
            } catch (SQLException throwables) {
                // se un form è vuoto
                request.setAttribute("messageRegistrazione", "false");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
                throwables.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
