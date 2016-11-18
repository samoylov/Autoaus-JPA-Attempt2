package autohaus.entity;

import javax.persistence.*;

@Entity
public class Make implements Comparable<Make> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    public Make() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Make(String name, Country country) {
        super();
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Make other = (Make) obj;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public int compareTo(Make o) {
        int nameDiff = this.name.compareTo(o.getName());
        if (nameDiff != 0)
            return nameDiff;
        int countryDiff = this.country.compareTo(o.getCountry());
        if (countryDiff != 0)
            return countryDiff;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%02d: %s (%s)", id, name, country.getName());
    }

}
