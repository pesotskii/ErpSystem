package erpsystem.dao;


import erpsystem.entity.Country;

import java.util.List;

public interface CountryDAO {
    void addCountry(Country country);

    void updateCountry(Country country);

    void deleteCountry(Country country);

    Country getCountryById(int id);

    Country getCountryByName(String name);

    List<Country> getCountryList();
}
