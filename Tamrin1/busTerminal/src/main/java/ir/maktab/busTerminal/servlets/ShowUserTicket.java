package ir.maktab.busTerminal.servlets;

import ir.maktab.busTerminal.entities.Ticket;
import ir.maktab.busTerminal.services.TicketService;
import ir.maktab.busTerminal.services.utils.CheckCookies;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ShowUserTicket extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        String username = CheckCookies.findCookieValue("user",cookies);

        List<Ticket> tickets = TicketService.showUserTickets(username);
        req.setAttribute("tickets",tickets);
        req.getRequestDispatcher("showUserTicket.jsp").forward(req,resp);

    }
}
