package erpsystem.model;

import java.util.Date;

/**
 * Created by Alexandr Zhilkin on 13.01.2017.
 */
public class Project {
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

    private int id;
    private String project_name;
    private String manager;
    private Date due_date;

    public Project(int id, String project_name, String manager, Date due_date){
        this.id = id;
        this.project_name = project_name;
        this.manager = manager;
        this.due_date = due_date;
    }

    public Project(){}
}
