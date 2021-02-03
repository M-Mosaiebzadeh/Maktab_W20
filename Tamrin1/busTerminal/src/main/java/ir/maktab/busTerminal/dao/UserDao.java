package ir.maktab.busTerminal.dao;

import ir.maktab.busTerminal.entities.User;
import javax.persistence.EntityManager;

public class UserDao extends AbstractDao<Integer, User>{

    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

}
