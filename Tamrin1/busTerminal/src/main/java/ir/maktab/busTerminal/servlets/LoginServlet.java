package ir.maktab.busTerminal.servlets;

import ir.maktab.busTerminal.entities.User;
import ir.maktab.busTerminal.services.UserService;
import ir.maktab.busTerminal.services.utils.CheckCookies;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();


        Cookie[] cookies = req.getCookies();
        String usernameCookie = CheckCookies.findCookieValue("user", cookies);

        if (usernameCookie != null) {
            User user = UserService.isExistUser(usernameCookie).get(0);
            req.getRequestDispatcher("userPage.jsp").include(req, resp);

        } else {

            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if (UserService.isExistUser(username, password).size() != 0) {
                User user = UserService.isExistUser(username, password).get(0);
                Cookie cookie = new Cookie("user", user.getUsername());
                cookie.setMaxAge(1000000);
                resp.addCookie(cookie);

                out.println("<center><h3>");
                out.println("Welcome " + user.getFirstname() + " " + user.getLastname() + " ....");
                out.println("</h3></center><br>");

                req.getRequestDispatcher("userPage.jsp").include(req, resp);

            } else if (username == null && password == null) {
                req.getRequestDispatcher("login.jsp").forward(req, resp);

            } else {
                out.println("<center><h3>");
                out.println("username " + username + " not found!!");
                out.println("please sign up first!");
                out.println("</h3></center><br>");


                req.getRequestDispatcher("login.jsp").include(req, resp);
            }
        }
    }
}
