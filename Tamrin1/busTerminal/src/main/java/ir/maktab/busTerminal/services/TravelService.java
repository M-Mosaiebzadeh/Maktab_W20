package ir.maktab.busTerminal.services;

import ir.maktab.busTerminal.dao.TravelDao;
import ir.maktab.busTerminal.entities.Travel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static ir.maktab.busTerminal.util.EntityManagerFactoryUtil.createEntityManagerFactory;

public class TravelService {
    private static EntityManager entityManager;
    private static TravelDao travelDao;

    public static void save(Travel travel) {
        entityManager = createEntityManagerFactory().createEntityManager();
        travelDao = new TravelDao(entityManager);
        entityManager.getTransaction().begin();
        travelDao.save(travel);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Travel> showTravelList(Date date, String origin, String destination) {
        entityManager = createEntityManagerFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Travel> query = builder.createQuery(Travel.class);
        Root<Travel> fromTravel = query.from(Travel.class);
        query.select(fromTravel).where(builder.and(
                builder.equal(fromTravel.get("date"),date),
                builder.and(
                        builder.equal(fromTravel.get("origin"),origin),
                        builder.equal(fromTravel.get("destination"),destination)
                )
        ));
        TypedQuery<Travel> typedQuery = entityManager.createQuery(query);
        List<Travel> travels = typedQuery.getResultList();
        travels.sort(Comparator.comparing(Travel::getTime));
        return travels;
    }
}
