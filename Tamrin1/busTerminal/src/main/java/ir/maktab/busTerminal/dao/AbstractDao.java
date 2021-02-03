package ir.maktab.busTerminal.dao;

import javax.persistence.EntityManager;


public abstract class AbstractDao<K,E> {
    protected EntityManager entityManager;

    public AbstractDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public E load(K id) {
        return entityManager.find(getEntityClass(),id);
    }

    public void save(E entity) {
        entityManager.persist(entity);
    }

    public void delete(E entity) {
        entityManager.remove(entity);
    }

    public void update(E entity) {
        entityManager.merge(entity);
    }


    public abstract Class<E> getEntityClass();
}
