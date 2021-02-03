package ir.maktab.busTerminal.servlets;


import ir.maktab.busTerminal.entities.Ticket;
import ir.maktab.busTerminal.services.TicketService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FullDetailTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer ticketId = Integer.parseInt(req.getParameter("ticket"));
        Ticket ticket = TicketService.loadById(ticketId);
        req.setAttribute("ticket",ticket);
        req.getRequestDispatcher("fullDetailTicket.jsp").forward(req,resp);

    }
}
