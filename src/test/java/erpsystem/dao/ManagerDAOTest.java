package erpsystem.dao;

import erpsystem.config.AppConfig;
import erpsystem.config.application.WebConfig;
import erpsystem.entity.Manager;
import org.hibernate.SessionFactory;
import org.junit.Before;
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

/**
 * Created by Саша on 27.01.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class, })
public class ManagerDAOTest {

    @Autowired
    OfficeManagerDAO officeManagerDAO;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    @Transactional
    @Rollback
    public void getManagerListTest() {

        String sql = "SELECT * FROM manager;";
        List<erpsystem.model.Manager> managerList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<erpsystem.model.Manager>(erpsystem.model.Manager.class));

        assertEquals(officeManagerDAO.getManagerList().size(), managerList.size());
    }

    @Test
    @Transactional
    @Rollback
    public void getManagerByIdTest() {

        String sql = "SELECT * FROM manager;";
        List<erpsystem.model.Manager> managerList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<erpsystem.model.Manager>(erpsystem.model.Manager.class));
        assertEquals(officeManagerDAO.getManagerList().size(), managerList.size());

        erpsystem.model.Manager manager;
        int id;
        for(int i = 0; managerList.size() > i; i++ ){
            id = managerList.get(i).getId();
            assertNotNull(officeManagerDAO.getManagerById(id).getId());
        }
    }

    @Test
    @Transactional
    @Rollback
    public void deleteManagerTest() {

        String sql = "SELECT * FROM manager;";
        List<erpsystem.model.Manager> managerList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<erpsystem.model.Manager>(erpsystem.model.Manager.class));
        if(managerList.size() == 0){
            assertTrue(true);
            return;
        }
        officeManagerDAO.deleteManager(officeManagerDAO.getManagerById(managerList.get(0).getId()));
        assertEquals(officeManagerDAO.getManagerList().size(), managerList.size() - 1);

    }

    @Test
    @Transactional
    @Rollback
    public void addManagerTest() {

        String sql = "SELECT * FROM manager;";
        List<erpsystem.model.Manager> managerList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<erpsystem.model.Manager>(erpsystem.model.Manager.class));

        officeManagerDAO.addManager(new Manager());
        assertEquals(officeManagerDAO.getManagerList().size(), managerList.size() + 1);

    }
}
