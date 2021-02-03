package ir.maktab.busTerminal.services;

import ir.maktab.busTerminal.dao.TicketDao;
import ir.maktab.busTerminal.entities.Ticket;
import static ir.maktab.busTerminal.util.EntityManagerFactoryUtil.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketService{
    private static EntityManager entityManager;
    private static TicketDao ticketDao;

    public static Ticket loadById(Integer id) {
        entityManager = createEntityManagerFactory().createEntityManager();
        ticketDao = new TicketDao(entityManager);
        return ticketDao.load(id);
    }

    public static void delete(Ticket ticket) {
        entityManager = createEntityManagerFactory().createEntityManager();
        ticketDao = new TicketDao(entityManager);
        entityManager.getTransaction().begin();
        ticketDao.delete(entityManager.contains(ticket) ? ticket : entityManager.merge(ticket));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void save(Ticket ticket) {
        entityManager = createEntityManagerFactory().createEntityManager();
        ticketDao = new TicketDao(entityManager);
        entityManager.getTransaction().begin();
        ticketDao.save(ticket);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Ticket> showUserTickets(String username) {
        entityManager = createEntityManagerFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> query = builder.createQuery(Ticket.class);
        Root<Ticket> fromTicket = query.from(Ticket.class);

        query.select(fromTicket)
                .where(builder.equal(fromTicket.get("user").get("username"),username));

        TypedQuery<Ticket> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
