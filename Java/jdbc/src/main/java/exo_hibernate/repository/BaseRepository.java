package exo_hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import exo_hibernate.util.SessionFactorySingleton;

import java.util.List;

public abstract class BaseRepository<T> {
    protected Session session;
    protected SessionFactory sessionFactory;
    protected Class<T> repositoryType;

    public BaseRepository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
        repositoryType = defineRepositoryType();
    }

    public T createOrUpdate (T entity){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
            return entity;
        }catch (Exception e){
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean delete (int id){
        try{
            T entity = findById(id);
            if(entity != null){
                session = sessionFactory.openSession();
                session.beginTransaction();
                session.delete(entity);
                session.getTransaction().commit();
                return true;
            }
            return false;

        }catch (Exception e){
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public T findById (int id){
        session= sessionFactory.openSession();
        T entity = session.get(repositoryType,id);
        session.close();
        return entity;
    }

    public List<T> getAll (){
        session = sessionFactory.openSession();
        List<T> entity = session.createQuery("FROM " + repositoryType.getSimpleName(), repositoryType).list();
        session.close();
        return entity;
    }

    protected abstract Class<T> defineRepositoryType();
}
