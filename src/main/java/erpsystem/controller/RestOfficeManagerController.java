package erpsystem.controller;

import erpsystem.entity.Manager;
import erpsystem.entity.Question;
import erpsystem.service.OfficeManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Саша on 26.01.2017.
 */
@RestController
@RequestMapping("/api/office")
public class RestOfficeManagerController {

    @Autowired
    OfficeManagerService officeManagerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Object getManager(@PathVariable(value = "id") String inputId, HttpServletResponse response) {
        try {
            int managerId = Integer.valueOf(inputId);
            Manager manager = officeManagerService.getManagerById(managerId);
            System.out.println(manager.getId());
            if (manager != null) {
                return manager;
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return "Manager with id: " + managerId + " not found.";
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Bad manager id format: " + inputId;
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Manager> getAllManager() {
        return officeManagerService.getManagerList();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object addManager(@RequestBody Manager manager, HttpServletResponse response) {
        try {
            officeManagerService.addManager(manager);
            return manager;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error adding question: " + e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Object updateManager(@RequestBody Manager manager, HttpServletResponse response) {
        try {
            officeManagerService.updateManager(manager);
            return manager;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error updating question: " + e.getMessage();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String deleteManager(@PathVariable(value = "id") String inputId, HttpServletResponse response) {
        try {
            int managerId = Integer.valueOf(inputId);
            Manager manager = officeManagerService.getManagerById(managerId);
            if (manager != null) {
                officeManagerService.deleteManager(manager);
                return "Manager #" + managerId + " successfully deleted.";
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return "Manager with id: " + managerId + " not found.";
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Bad manager id format: " + inputId;
        }
    }

}
