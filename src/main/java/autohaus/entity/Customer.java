package autohaus.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer implements Comparable<Customer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String email;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Orders> orders;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String streetAddress,
                    String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return String.format("%02d: %s %s, %s, %s", id, firstName, lastName, email,
                streetAddress);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
        Customer other = (Customer) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }

    public int compareTo(Customer that) {
        String thisData = this.firstName + this.lastName + this.email;
        String thatData = that.getFirstName() + that.getLastName() + that.getEmail();
        int nameDiff = thisData.compareTo(thatData);
        if (nameDiff != 0)
            return nameDiff;
        return 0;
    }

}
