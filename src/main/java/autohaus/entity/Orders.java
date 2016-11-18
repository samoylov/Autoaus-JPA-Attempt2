package autohaus.entity;

import javax.persistence.*;

@Entity
public class Orders implements Comparable<Orders> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    @ManyToOne
    private Car car;
    private int price;

    public Orders() {
    }

    public Orders(Customer customer, Car car) {
        super();
        this.customer = customer;
        this.car = car;
        this.price = car.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((car == null) ? 0 : car.hashCode());
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + id;
        result = prime * result + price;
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
        Orders other = (Orders) obj;
        if (car == null) {
            if (other.car != null)
                return false;
        } else if (!car.equals(other.car))
            return false;
        if (customer == null) {
            if (other.customer != null)
                return false;
        } else if (!customer.equals(other.customer))
            return false;
        if (id != other.id)
            return false;
        return price == other.price;
    }

    public int compareTo(Orders o) {
        String thisData = this.customer.toString() + this.car.toString()
                + String.valueOf(price);
        String oData = o.getCustomer().toString() + o.getCar().toString()
                + String.valueOf(o.getPrice());
        int diff = thisData.compareTo(oData);
        if (diff != 0)
            return diff;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%02d: %s %s, %s, sold for $%d", id, customer.getFirstName(),
                customer.getLastName(), car, price);
    }

}
