package exo_JPA.Repository;

import exo_JPA.Entity.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class BaseRepository<T extends BaseEntity> {
    protected static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory(
            "exo_jpa");
    protected static EntityManager entityManager = entityManagerFactory.createEntityManager();
    protected Class<T> repositoryType;

    public void add(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void update(T entity) {
        try {
            entityManager.getTransaction().begin();
            T entityFromDb = getById(entity.getId());
            entityFromDb = entity;
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

    }

    public T getById(int id) {
        return (T) entityManager.find(repositoryType, id);
    }

    public List<T> getAll() {
        return entityManager.createQuery("SELECT e FROM " + getSimpleClassName(repositoryType.getName()) + " e", repositoryType)
                .getResultList();

    }

    public void delete(int id) {
        try {
            entityManager.getTransaction().begin();
            T entityFromDb = getById(id);
            entityManager.remove(entityFromDb);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }


    protected abstract Class<T> defineRepositoryType();

    public BaseRepository(){
        repositoryType = defineRepositoryType();
    }

    private String getSimpleClassName(String className){
        return className.substring(className.lastIndexOf('.') + 1);
    }

}