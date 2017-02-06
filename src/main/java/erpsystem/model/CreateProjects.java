package erpsystem.model;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CreateProjects {
    private JdbcTemplate jdbcTemplate;

    public CreateProjects(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateProjects() {
    }

    public String tableCreation() {
        try {
            jdbcTemplate.execute("CREATE TABLE Project(\n" +
                    "   ID INT PRIMARY KEY     NOT NULL,\n" +
                    "   PROJECT_NAME           TEXT    NOT NULL,\n" +
                    "   MANAGER                TEXT    NOT NULL,\n" +
                    "   DUE_DATE               DATE \n" +
                    ");");
            return "table created";
        } catch (Exception e) {
            return "Error: "  + e;
        }
    }

    public String insert() {
        try {
            jdbcTemplate.update("INSERT INTO Project VALUES (0,'Project1','a','2017-03-27')");
            jdbcTemplate.update("INSERT INTO Project VALUES (1,'Project2','a','2016-12-31')");
            jdbcTemplate.update("INSERT INTO Project VALUES (2,'Project3','d','2017-09-27')");
            jdbcTemplate.update("INSERT INTO Project VALUES (3,'Project4','r','2017-07-26')");
            jdbcTemplate.update("INSERT INTO Project VALUES (4,'Project5','e','2017-03-17')");
            jdbcTemplate.update("INSERT INTO Project VALUES (5,'Project6','t','2017-05-01')");
            jdbcTemplate.update("INSERT INTO Project VALUES (6,'Project7','k','2017-02-03')");
            jdbcTemplate.update("INSERT INTO Project VALUES (7,'Project8','l','2017-09-16')");
            jdbcTemplate.update("INSERT INTO Project VALUES (8,'Project9','a','2018-03-14')");
            return "INSERTED";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    public List<Project> selectAll() {
        String sql = "SELECT * FROM Project";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Project.class));
    }


    public String rmProject(String manager) {
        try {
            jdbcTemplate.update("DELETE FROM Project WHERE MANAGER='" + manager + "'");
            return "DELETED";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }
}
