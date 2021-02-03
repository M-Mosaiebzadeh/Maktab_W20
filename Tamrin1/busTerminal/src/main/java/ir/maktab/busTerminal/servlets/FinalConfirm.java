package ir.maktab.busTerminal.servlets;

import ir.maktab.busTerminal.entities.Ticket;
import ir.maktab.busTerminal.entities.Travel;
import ir.maktab.busTerminal.entities.User;
import ir.maktab.busTerminal.services.TicketService;
import ir.maktab.busTerminal.services.UserService;
import ir.maktab.busTerminal.services.utils.CheckCookies;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class FinalConfirm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);
        Travel travel = (Travel) session.getAttribute("myTravel");

        Cookie[] cookies = req.getCookies();

        String username = CheckCookies.findCookieValue("user",cookies);

        User user = UserService.isExistUser(username).get(0);


        String name = req.getParameter("name");
        String gender = req.getParameter("gender");

        Ticket ticket = new Ticket();
        ticket.setName(name);
        ticket.setGender(gender);
        ticket.setUser(user);
        ticket.setTravel(travel);
        TicketService.save(ticket);

        req.setAttribute("ticketId",ticket.getId());
        req.getRequestDispatcher("successfulPurchase.jsp").forward(req,resp);
    }
}
