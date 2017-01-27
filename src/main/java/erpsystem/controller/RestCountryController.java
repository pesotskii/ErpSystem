package erpsystem.controller;

import erpsystem.entity.Country;
import erpsystem.entity.Question;
import erpsystem.service.CountryService;
import erpsystem.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Dima on 27.01.2017.
 */
public class RestCountryController {
    @Autowired
    CountryService countryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Object getCountry(@PathVariable(value = "id") String inputId, HttpServletResponse response) {
        try {
            int countryId = Integer.valueOf(inputId);
            Country country = countryService.getCountryById(countryId);
            if (country != null) {
                return country;
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return "Country with id: " + countryId + " not found.";
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Bad country id format: " + inputId;
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Country> getAllCountry() {
        return countryService.getCountryList();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object addCountry(@RequestBody Country country, HttpServletResponse response) {
        try {
            countryService.addCountry(country);
            return country;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error adding country: " + e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Object updateCountry(@RequestBody Country country, HttpServletResponse response) {
        try {
            countryService.updateCountry(country);
            return country;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error updating country: " + e.getMessage();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String deleteCountry(@PathVariable(value = "id") String inputId, HttpServletResponse response) {
        try {
            int countryId = Integer.valueOf(inputId);
            Country country = countryService.getCountryById(countryId);
            if (country != null) {
                countryService.deleteCountry(country);
                return "Country #" + countryId + " successfully deleted.";
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return "Country with id: " + countryId + " not found.";
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "Bad country id format: " + inputId;
        }
    }
}
