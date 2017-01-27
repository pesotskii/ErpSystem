package erpsystem.dao.impl;

import erpsystem.dao.OfficeManagerDAO;
import erpsystem.entity.Manager;
import erpsystem.entity.Question;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Саша on 26.01.2017.
 */
@Repository
@Transactional
public class OfficeManagerDAOImpl implements OfficeManagerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public OfficeManagerDAOImpl (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addManager(Manager manager) {
        sessionFactory.getCurrentSession().save(manager);
    }

    @Override
    public void updateManager(Manager manager) {
        sessionFactory.getCurrentSession().update(manager);
    }

    @Override
    public void deleteManager(Manager manager) {
        final Session session = sessionFactory.getCurrentSession();
        session.delete(manager);
        session.flush();
    }

    @Override
    public Manager getManagerById(int id) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Manager.class);
        criteria.add(Restrictions.eq("id", id));
        return (Manager) criteria.uniqueResult();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Manager> getManagerList() {
        System.out.println("asdasdasd");
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Manager.class);
        return (List<Manager>) criteria.list();
    }
}
