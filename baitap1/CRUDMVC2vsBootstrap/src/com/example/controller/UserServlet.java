package com.example.controller;

import com.example.da.UserDao;
import com.example.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class UserServlet extends HttpServlet {

    private UserDao userDao;

    public void init(){
        userDao = new UserDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                      showNewForm(request, response);
                    break;
                case "/insert":
                        insertUser(request, response);
                        break;
                case "/delete":
                        deleteUser(request, response);
                        break;
                case "/edit":
                        showEditForm(response, request);
                        break;
                case "/update":
                        updateUser(response, request);
                        break;
                default:
                        listUser(response, request);
                        break;
            }
        }catch (SQLException | ClassNotFoundException ex){
            throw new ServletException(ex);
        }
    }
    private void listUser(HttpServletResponse response,HttpServletRequest request) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<User> listUser = userDao.selectAllUsers();
        request.setAttribute("listUser",listUser);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user-list.jsp");
        requestDispatcher.forward(request,response);
    }
    private void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user-form.jsp");
        requestDispatcher.forward(request,response);
    }
    private void showEditForm(HttpServletResponse response,HttpServletRequest request) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDao.selectUser(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user",user);
        requestDispatcher.forward(request,response);
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ClassNotFoundException,ServletException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        userDao.insertUser(user);
        response.sendRedirect("list");
    }
    private void updateUser(HttpServletResponse response,HttpServletRequest request) throws SQLException, ClassNotFoundException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("name");
        String country = request.getParameter("country");
        User userbook = new User(id,name,email,country);
        userDao.updateUser(userbook);
        response.sendRedirect("list");
    }
    private void deleteUser(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDao.deleteUser(id);
        response.sendRedirect("list");
    }
}
