package erpsystem.dao;

import erpsystem.entity.Project;
import java.util.List;

public interface ProjectDAO {

    void addProject(Project project);

    void deleteProject(Project project);

    void deleteProjectByManager(String manager);

    Project getProjectById(int id);

    List<Project> getProjectList();
}

