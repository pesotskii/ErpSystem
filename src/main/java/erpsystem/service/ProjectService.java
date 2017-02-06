package erpsystem.service;

import erpsystem.dao.ProjectDAO;
import erpsystem.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("ProjectService")
@Transactional
public class ProjectService {
    @Autowired
    ProjectDAO projectDAO;

    public void addProject(Project project) {
        projectDAO.addProject(project);
    }

    public Project getProjectById(int id) {
        return projectDAO.getProjectById(id);
    }

    public List<Project> getProjectList() {
        return projectDAO.getProjectList();
    }

    public void deleteProject(Project project) {
        projectDAO.deleteProject(project);
    }

    public void deleteProjectByManager(String manager) {
        projectDAO.deleteProjectByManager(manager);
    }

}