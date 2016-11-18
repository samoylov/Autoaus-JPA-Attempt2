package autohaus.entity;

import javax.persistence.*;

@Entity
public class CarModel implements Comparable<CarModel> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Make make;

    public CarModel() {
    }

    public CarModel(String name, Make make) {
        super();
        this.name = name;
        this.make = make;
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

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((make == null) ? 0 : make.hashCode());
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
        CarModel other = (CarModel) obj;
        if (make == null) {
            if (other.make != null)
                return false;
        } else if (!make.equals(other.make))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public int compareTo(CarModel o) {
        int makeDiff = this.make.compareTo(o.getMake());
        int nameDiff = this.name.compareTo(o.getName());
        if (makeDiff != 0)
            return makeDiff;
        else if (nameDiff != 0)
            return nameDiff;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%02d: (%s) %s", id, make.getName(), name);
    }

}
