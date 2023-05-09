package daohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

//Hibernate 3.0
public class HibernateDao {

    private SessionFactory sessionFactory;

    //Pour inserer ou pour modifier
    public <T> T create(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    //Pour retourner quelque chose selon son id
    public <T> T findById(Class<T> clazz, Serializable id) {
        Session session = sessionFactory.openSession();
        T entity = (T) session.get(clazz, id);
        session.close();
        return entity;
    }

    // Pour lister quelque chose par id quelque chose
    public <T> List<T> findByColumn(Class<T> tClass, String columnInDatabase, Object ob) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(tClass);
        criteria.add(Restrictions.eq(columnInDatabase, ob));

        List<T> results = criteria.list();
        session.close();
        return results;
    }

    //Pour faire une recherche
    public <T> List<T> findByRecherche(Class<T> tClass, String recherche, String column) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(tClass);
        criteria.add(Restrictions.like(column, recherche, MatchMode.ANYWHERE));

        List<T> results = criteria.list();
        session.close();
        return results;
    }

    //Pour lister quelque chose
    public <T> List<T> findAll(Class<T> tClass) {
        Session session = sessionFactory.openSession();
        List<T> results = session.createCriteria(tClass).list();
        session.close();
        return results;
    }

    // Pour but de lister quelque chose avec une somme d'une colonne grouper par une colone
    public <T> List<T> sumByColumn(Class<?> clazz, String sumColumn, String groupByColumn) {
        Session session = sessionFactory.openSession();
        List<T> results = session.createQuery("SELECT SUM(" + sumColumn + "), " + groupByColumn + " FROM " + clazz.getSimpleName() + " GROUP BY " + groupByColumn).list();
        session.close();
        return results;
    }

    //Pour sommer la valeur d'une colonne par une autre colonne
    public <T> int sumColumnByColumn(Class<T> tClass, String columnToSum, String columnToGroupBy) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(tClass)
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty(columnToGroupBy))
                        .add(Projections.sum(columnToSum)));
        List<Object[]> results = criteria.list();
        session.close();
        int total = 0;
        for (Object[] result : results) {
            int sum = (int) result[1];
            total += sum;
        }
        return total;
    }

    //Pour sommer un ou plusieurs colonne
    public double sumTabColumnByColumn(Class<?> tClass, String columnToSum, String columnToGroupBy, String column2, String column3) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(tClass);
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.groupProperty(columnToGroupBy));
        projectionList.add(Projections.sum(columnToSum));
        projectionList.add(Projections.sum(column2));
        projectionList.add(Projections.sum(column3));
        criteria.setProjection(projectionList);

        List<Object[]> results = criteria.list();
        double sum = 0.0;
        for (Object[] result : results) {
            sum += ((Number) result[1]).doubleValue() + ((Number) result[2]).doubleValue() + ((Number) result[3]).doubleValue();
        }
        session.close();
        return sum;
    }

    public <T> List<T> findWhere(T entity) {
        Session session = sessionFactory.openSession();
        Example example = Example.create(entity).ignoreCase();
        List<T> results = session.createCriteria(entity.getClass()).add(example).list();
        session.close();
        return results;
    }

    public <T> List<T> paginateWhere(T entity, int offset, int size) {
        Session session = sessionFactory.openSession();
        Example example = Example.create(entity).ignoreCase();
        List<T> results = session.createCriteria(entity.getClass())
                .add(example)
                .setFirstResult(offset)
                .setMaxResults(offset + size).list();
        session.close();
        return results;
    }

    public <T> List<T> paginate(Class<T> clazz, int offset, int size) {
        Session session = sessionFactory.openSession();
        System.out.println("CLASS : " + clazz.getSimpleName());
        List<T> results = session.createQuery("FROM ".concat(clazz.getSimpleName())).setFetchSize(offset).setMaxResults(size).list();
        session.close();
        return results;
    }

    public <T> List<T> paginate(Class<T> clazz, int offset, int size, String orderBy, boolean orderAsc) {
        Session session = sessionFactory.openSession();
        Order order = (orderAsc) ? Order.asc(orderBy) : Order.desc(orderBy);
        List<T> results = session.createCriteria(clazz)
                .addOrder(order)
                .setFirstResult(offset)
                .setMaxResults(offset + size).list();
        session.close();
        return results;
    }

    public void deleteById(Class tClass, Serializable id) {
        delete(findById(tClass, id));
    }

    public void delete(Object entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public <T> T update(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int getTotalQuantiteByMatierePremiere(int idMatierePremiere) {
        int totalQuantite = 0;
        try {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            String hql = "SELECT SUM(m.quantite) FROM MatiereStock m WHERE m.matierepremiere.id = :idMatierePremiere";
            Query query = session.createQuery(hql);
            query.setParameter("idMatierePremiere", idMatierePremiere);
            List<?> results = query.list();
            if (results.get(0) != null) {
                totalQuantite = ((Long) results.get(0)).intValue();
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalQuantite;
    }

}
