package erpsystem.service;

import erpsystem.dao.OfficeManagerDAO;
import erpsystem.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Саша on 26.01.2017.
 */
@Component("OfficeManagerService")
@Transactional
public class OfficeManagerService {

    @Autowired
    OfficeManagerDAO officeManagerDAO;

    public void addManager(Manager manager) {
        officeManagerDAO.addManager(manager);
    }

    public Manager getManagerById(int id) {
        return officeManagerDAO.getManagerById(id);
    }

    public List<Manager> getManagerList() {
        return officeManagerDAO.getManagerList();
    }

    public void updateManager(Manager manager) {
        officeManagerDAO.updateManager(manager);
    }

    public void deleteManager(Manager manager) {
        officeManagerDAO.deleteManager(manager);
    }
}
