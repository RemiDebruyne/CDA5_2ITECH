package exo_hibernate.repository;

import exo_hibernate.entity.Sale;
import org.hibernate.query.Query;

import java.util.List;

public class SaleRepository extends BaseRepository<Sale> {
    @Override
    protected Class<Sale> defineRepositoryType() {
        return Sale.class;
    }

    public List<Sale> getByFilter(String filter, Object valueToFilterBy) {
        try {
            session = sessionFactory.openSession();
            String hql = "FROM Sale s JOIN s." + filter + " j WHERE j.id = :valueToFilterBy";
            Query query = session.createQuery(hql, Sale.class);
            query.setParameter("valueToFilterBy", valueToFilterBy);
            return query.list();
        } finally {
            session.close();
        }

    }

    public List<Sale> getByProduct(int itemId) {
        try{
            session = sessionFactory.openSession();
            String hql = "FROM Sale s JOIN s.items i WHERE i.id = :itemId";
            Query query = session.createQuery(hql, Sale.class);
            query.setParameter("itemId", itemId);
            return query.list();
        } finally {
            session.close();
        }
    }

    public List<Sale> getByClient(int clientId) {
        try {
            session = sessionFactory.openSession();
            String hql = "FROM Sale s JOIN s.client c WHERE c.id = :clientId";
            Query query = session.createQuery(hql, Sale.class);
            query.setParameter("clientId", clientId);
            return query.list();
        } finally {
            session.close();
        }

    }
}
