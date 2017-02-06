package erpsystem.controller;


import erpsystem.entity.Project;
import erpsystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class RestProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Object getProject(@PathVariable(value = "id") String inputId, HttpServletResponse response) {
        try {
            int projectId = Integer.valueOf(inputId);
            Project project = projectService.getProjectById(projectId);
            if (project != null) {
                return project;
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return "Project with id: " + projectId + " not found.";
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Bad question id format: " + inputId;
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Project> getAllProject() {
        return projectService.getProjectList();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object addProject(@RequestBody Project project, HttpServletResponse response) {
        try {
            projectService.addProject(project);
            return project;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error adding project: " + e.getMessage();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String deleteProject(@PathVariable(value = "id") String inputId, HttpServletResponse response) {
        try {
            int projectId = Integer.valueOf(inputId);
            Project project = projectService.getProjectById(projectId);
            if (project != null) {
                projectService.deleteProject(project);
                return "Project #" + projectId + " successfully deleted.";
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return "Project with id: " + projectId + " not found.";
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Bad project id format: " + inputId;
        }
    }

    @RequestMapping(value = "/manager/{m}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String deleteProjectByManager(@PathVariable(value = "m") String manager, HttpServletResponse response) {
        try {
            projectService.deleteProjectByManager(manager);
            return "Projects with manager:" + manager + " successfully deleted.";
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Bad manager: " + manager;
        }
    }
}
