package erpsystem.entity;

import javax.persistence.*;

@Entity
@Table(name ="country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(length = 100)
    private String country;

    @Column(length = 100)
    private String capital;

    @Column
    private long population;

    @Column
    private long area;

    public Country(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }
}
