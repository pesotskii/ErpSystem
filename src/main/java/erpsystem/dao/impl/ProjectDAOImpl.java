package erpsystem.dao.impl;

import erpsystem.dao.ProjectDAO;
import erpsystem.entity.Project;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ListIterator;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProject(Project project) {
        sessionFactory.getCurrentSession().save(project);
    }

    @Override
    public void deleteProject(Project project) {
        final Session session = sessionFactory.getCurrentSession();
        session.delete(project);
        session.flush();
    }

    @Override
    public Project getProjectById(int id) {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Project.class);
        criteria.add(Restrictions.eq("id", id));
        return (Project) criteria.uniqueResult();
    }

    @Override
    public void deleteProjectByManager(String manager) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.
                createCriteria(Project.class);
        criteria.add(Restrictions.eq("manager", manager));
        List<Project> projects = (List<Project>) criteria.list();
        ListIterator projectsIterator = projects.listIterator();
        while(projectsIterator.hasNext()){
            session.delete(projectsIterator.next());
            session.flush();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> getProjectList() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(Project.class);
        return (List<Project>) criteria.list();
    }

}