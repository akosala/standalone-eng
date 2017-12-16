package searchengine.servlets;

import searchengine.dao.UsersRepositoryDao;
import searchengine.dao.UsersRepositoryDaoBean;
import searchengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/statistics")
public class SearchStatistics extends HttpServlet {
    @EJB
    UsersRepositoryDao dao;


    @Override
protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if( req.getParameter("id")==null){

//            UsersRepositoryDaoBean.startStistic();

            List<User> list = dao.userList();
            System.out.println("[USER LIST SIZE] " + list.size());
            req.setAttribute("listSize", list.size());
            req.setAttribute("list", list);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/statistic.jsp");
            requestDispatcher.forward(req, resp);

//        resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter writer = resp.getWriter();
//writer.printf("Stystayka dla wszystkich logowań");
//        for(User user : dao.userList()){



//        }



//}
 }}