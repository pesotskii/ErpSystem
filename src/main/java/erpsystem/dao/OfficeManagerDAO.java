package erpsystem.dao;

import erpsystem.entity.Manager;

import java.util.List;

/**
 * Created by Саша on 26.01.2017.
 */
public interface OfficeManagerDAO {

    void addManager(Manager manager);

    void updateManager(Manager manager);

    void deleteManager(Manager manager);

    Manager getManagerById(int id);

    List<Manager> getManagerList();
}
