package erpsystem.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "PROJECT_NAME")
    private String project_name;

    @Column(name = "MANAGER")
    private String manager;

    @Column(name = "DUE_DATE")
    private Date due_date;

    public Project(int id, String project_name, String manager, Date due_date){
        this.id = id;
        this.project_name = project_name;
        this.manager = manager;
        this.due_date = due_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Project(){
        this.project_name = "tmp_name";
        this.manager = "tmp_manager_for_test";
    }
}
