package ir.maktab.busTerminal.filters;


import ir.maktab.busTerminal.entities.Ticket;
import ir.maktab.busTerminal.services.TicketService;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CancelTicketFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        servletResponse.setContentType("text/html");

        Integer cancelTicketId = Integer.parseInt(servletRequest.getParameter("cancel"));

        Ticket ticket = TicketService.loadById(cancelTicketId);


        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");

        try {
            Date nowDate = formatterDate.parse(formatterDate.format(new Date()));

            if (ticket.getTravel().getDate().after(nowDate)) {
                servletRequest.setAttribute("ticketForDel",ticket);
                filterChain.doFilter(servletRequest, servletResponse);

            } else {
                out.println("<center><h3>");
                out.println("your ticket is expired...sorry");
                out.println("</h3></center>");
                servletRequest.getRequestDispatcher("userPage.jsp").include(servletRequest, servletResponse);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
