package ir.maktab.busTerminal.services;

import ir.maktab.busTerminal.dao.UserDao;
import ir.maktab.busTerminal.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

import static ir.maktab.busTerminal.util.EntityManagerFactoryUtil.createEntityManagerFactory;

public class UserService {
    private static EntityManager entityManager;
    private static UserDao userDao;

    public static void save(User user) {
        entityManager = createEntityManagerFactory().createEntityManager();
        userDao = new UserDao(entityManager);
        entityManager.getTransaction().begin();
        userDao.save(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<User> isExistUser(String username, String password) {
        entityManager = createEntityManagerFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> fromUser = query.from(User.class);

        query.select(fromUser).where(builder.and(
                builder.equal(fromUser.get("username"),username),
                builder.equal(fromUser.get("password"),password)
        ));

        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    public static List<User> isExistUser(String username) {
        entityManager = createEntityManagerFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> fromUser = query.from(User.class);

        query.select(fromUser).where(builder.equal(fromUser.get("username"),username));

        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
