package ir.maktab.busTerminal.servlets;


import ir.maktab.busTerminal.entities.Travel;
import ir.maktab.busTerminal.services.TravelService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SearchTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       PrintWriter out = resp.getWriter();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(req.getParameter("date"));
            String origin = req.getParameter("origin");
            String destination = req.getParameter("destination");
            List<Travel> travels = TravelService.showTravelList(date,origin,destination);
            req.setAttribute("travelList",travels);
            req.getRequestDispatcher("showTickets.jsp").forward(req,resp);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
