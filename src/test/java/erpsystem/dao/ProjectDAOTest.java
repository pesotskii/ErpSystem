package erpsystem.dao;

import erpsystem.config.AppConfig;
import erpsystem.config.application.WebConfig;
import erpsystem.entity.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class, })
public class ProjectDAOTest {

    @Autowired
    ProjectDAO projectDAO;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    @Transactional
    @Rollback
    public void getProjectListTest() {
        String sql = "SELECT * FROM Project;";
        List<erpsystem.model.Project> projectList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(erpsystem.model.Project.class));
        assertEquals(projectDAO.getProjectList().size(), projectList.size());
    }

    @Test
    @Transactional
    @Rollback
    public void getProjectByIdTest() {
        String sql = "SELECT * FROM Project;";
        List<erpsystem.model.Project>projectList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(erpsystem.model.Project.class));
        assertEquals(projectDAO.getProjectList().size(), projectList.size());
        erpsystem.model.Manager manager;
        int id;
        for(int i = 0; i < projectList.size(); i++ ){
            id = projectList.get(i).getId();
            assertNotNull(projectDAO.getProjectById(id).getId());
        }
    }

    @Test
    @Transactional
    @Rollback
    public void deleteProjectTest() {
        String sql = "SELECT * FROM Project;";
        List<erpsystem.model.Project> projectList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(erpsystem.model.Project.class));
        if(projectList.size() == 0){
            assertTrue(true);
            return;
        }
        projectDAO.deleteProject(projectDAO.getProjectById(projectList.get(0).getId()));
        assertEquals(projectDAO.getProjectList().size(), projectList.size() - 1);
    }

    @Test
    @Transactional
    @Rollback
    public void addProjectTest() {
        String sql = "SELECT * FROM Project;";
        List<erpsystem.model.Project> projectList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(erpsystem.model.Project.class));
        projectDAO.addProject(new Project());
        assertEquals(projectDAO.getProjectList().size(), projectList.size() + 1);
    }

    @Test
    @Transactional
    @Rollback
    public void deleteProjectByManagerTest() {
        String sql = "SELECT * FROM Project;";
        List<erpsystem.model.Project> projectList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(erpsystem.model.Project.class));
        projectDAO.addProject(new Project());
        projectDAO.addProject(new Project());
        projectDAO.addProject(new Project());
        assertEquals(projectDAO.getProjectList().size(), projectList.size() + 3);
        projectDAO.deleteProjectByManager("tmp_manager_for_test");
        assertEquals(projectDAO.getProjectList().size(), projectList.size());
    }
}
