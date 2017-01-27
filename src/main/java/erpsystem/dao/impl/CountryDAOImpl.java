package erpsystem.dao.impl;

import erpsystem.dao.CountryDAO;
import erpsystem.entity.Country;
import erpsystem.entity.Question;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CountryDAOImpl implements CountryDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public CountryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCountry(Country country) {
        sessionFactory.getCurrentSession().save(country);
    }

    @Override
    public void updateCountry(Country country) {
        // saving old password if do not provided new
        final String query = "SELECT country from country WHERE id=:id";
        String oldCountry = (String) sessionFactory.
                getCurrentSession().
                createSQLQuery(query).
                setParameter("id", country.getId()).
                uniqueResult();
        country.setCountry(oldCountry);
        sessionFactory.getCurrentSession().update(country);
    }

    @Override
    public void deleteCountry(Country country) {
        final Session session = sessionFactory.getCurrentSession();
        session.delete(country);
        session.flush();
    }

    @Override
    public Country getCountryById(int id) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Question.class);
        criteria.add(Restrictions.eq("id", id));
        return (Country) criteria.uniqueResult();
    }

    @Override
    public Country getCountryByName(String country) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Question.class);
        criteria.add(Restrictions.eq("country", country));
        return (Country) criteria.uniqueResult();
    }

    @Override
    public List<Country> getCountryList() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Question.class);
        return (List<Country>) criteria.list();
    }
}
