package ir.maktab.busTerminal.servlets;


import ir.maktab.busTerminal.entities.Ticket;
import ir.maktab.busTerminal.services.TicketService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class CancelTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Ticket ticket = (Ticket) req.getAttribute("ticketForDel");
        TicketService.delete(ticket);

        out.println("<center><h3>");
        out.println("Ticket (Ticket ID : " + ticket.getId() + " ) is deleted");
        out.println("</h3></center>");
        req.getRequestDispatcher("userPage.jsp").include(req,resp);


    }
}
