package erpsystem.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Саша on 13.01.2017.
 */
@PropertySource(value = {"classpath:ManagerSQL.properties"})
public class TableManagers {

    @Autowired
    Environment environment;

    private JdbcTemplate jdbcTemplate;

    public TableManagers(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public TableManagers() {
    }

    public String createTable() {
        try {
            /*jdbcTemplate.execute(environment.getProperty("createManagersTableQuery"));*/
            jdbcTemplate.execute("CREATE TABLE managers( id INT PRIMARY KEY NOT NULL, name TEXT NOT NULL, age INT NOT NULL, salary REAL, office INT);");
            return "table created";
        } catch (Exception e) {
            return "Error : " + e;
        }
    }

    public String insertManagers() {
        try {
            /*jdbcTemplate.update(environment.getProperty("insertManagers"));*/
            jdbcTemplate.update("INSERT INTO managers VALUES (1, 'Вася Пупкин', 34, 10000.0, 10); " +
                    "INSERT INTO managers VALUES(2, 'Дарт Вейдер', 25, 45660.0, 10); " +
                    "INSERT INTO managers VALUES(3, 'Алладин', 21, 5600.0, 12); " +
                    "INSERT INTO managers VALUES(4, 'Брэд Питт', 53, 34000.0, 13); " +
                    "INSERT INTO managers VALUES(5, 'Дэвид Дрейман', 43, 24000.0, 13);");
            return "inserted";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    public List<Manager> selectManagersByOffice(Office office) {
        /*String sql = environment.getProperty("selectManagersByOffice");*/
        if(office.getNumber() == null || office.getNumber() == ""){
            return selectManagers();
        }
        if(!checkString(office.getNumber())){
            return selectManagers();
        }
        String sql = "SELECT * FROM managers WHERE office=?";
        return jdbcTemplate.query(sql, new Integer[]{Integer.parseInt(office.getNumber())},
                new BeanPropertyRowMapper<Manager>(Manager.class));
    }

    public List<Manager> selectManagers() {
        /*String sql = environment.getProperty("selectManagers");*/
        String sql = "SELECT * FROM managers;";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<Manager>(Manager.class));
    }

    private boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
