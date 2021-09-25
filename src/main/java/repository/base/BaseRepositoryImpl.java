package repository.base;

import entity.base.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable>
        implements BaseRepository<E, ID>
{
    protected final EntityManager entityManager;
    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public abstract Class<E> getEntityClass();
    @Override
    public E save(E e) {
        getEntityManger().getTransaction().begin();
        if (e.getId() == null)
            getEntityManger().persist(e);
        else
            getEntityManger().merge(e);
        getEntityManger().getTransaction().commit();
        return e;
    }

    @Override
    public void delete(E e) {
        getEntityManger().getTransaction().begin();
        E findEntity = getEntityManger().find(getEntityClass(), e);
        getEntityManger().remove(findEntity);
       getEntityManger().getTransaction().commit();

    }

    @Override
    public boolean deleteByID(E  e) {
        getEntityManger().getTransaction().begin();
        int done = getEntityManger().createQuery("delete from " + getEntityClass().getSimpleName() + " where id=:id")
                .setParameter("id", e.getId())
                .executeUpdate();
        if (done > 0)
            return true;
        else return false;
    }

    @Override
    public E update(E e) {
        getEntityManger().getTransaction().begin();
        E updated = getEntityManger().merge(e);
        getEntityManger().getTransaction().commit();
        return updated;
    }

    @Override
    public E findByID(ID id) {
        return getEntityManger().find(getEntityClass(),id);
    }

    @Override
    public List<E> findAll() {
        getEntityManger().getTransaction().begin();
        List<E> resultList = getEntityManger().
                createQuery("from " + getEntityClass().getSimpleName(),
                        getEntityClass()).getResultList();
        getEntityManger().getTransaction().commit();
        return resultList;
    }

    @Override
    public boolean existsById(ID id) {
        boolean exist = getEntityManger().createQuery(
                "select count(id) from " + getEntityClass().getSimpleName() +
                        " where id = :id", Long.class).
                setParameter("id", id)
                .getSingleResult() == 1L;
        return exist;
    }

    @Override
    public EntityManager getEntityManger() {
        return entityManager;
    }
}
