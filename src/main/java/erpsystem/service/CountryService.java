package erpsystem.service;

import erpsystem.dao.CountryDAO;
import erpsystem.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("CountryService")
@Transactional
public class CountryService {
    @Autowired
    CountryDAO countryDAO;

    public void addCountry(Country country) {
        countryDAO.addCountry(country);
    }

    public Country getCountryById(int id) {
        return countryDAO.getCountryById(id);
    }

    public List<Country> getCountryList() {
        return countryDAO.getCountryList();
    }

    public void updateCountry(Country country) {
        countryDAO.updateCountry(country);
    }

    public void deleteCountry(Country country) {
        countryDAO.deleteCountry(country);
    }

}
