package com.example.controller;

import com.example.da.Validate;
import com.example.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);




        if (Validate.checkUser(username,password) == true){
            HttpSession httpSession = request.getSession(false);
            httpSession.setAttribute("chien",user);
            response.sendRedirect("createProduct.jsp");

        }else {
            response.sendRedirect("fail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
