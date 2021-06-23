package com.example.eco_mobility.Control;

import com.example.eco_mobility.DAO.UtentiDAO;
import com.example.eco_mobility.DTO.UtentiDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginControl", value = "/LoginControl")
public class LoginControl extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginControl() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String redirectedPage;

        try {
            if(checkLogin(email,password,request).equals("registrato")){
                redirectedPage="/home.jsp";
                response.sendRedirect(request.getContextPath() + redirectedPage);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }


    }

    private String checkLogin(String email, String password, HttpServletRequest request) throws Exception {
        UtentiDAO utDAO = new UtentiDAO();
        UtentiDTO ut = utDAO.doRetrivebyEmail(email);

        if (ut.getEmail().equals(email) && ut.getPassword().equals(password)) {

            request.getSession().setAttribute("utente",ut);

            return "registrato";
        } else
            throw new Exception("Invalid login and password");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
