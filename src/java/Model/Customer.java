/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author jakelhamselv
 */
@Entity(name = "CUSTOMERS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CUSTOMER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    
    @Column(name = "FIRST_NAME", length = 200, nullable = false)
    private String firstName;
    
    @Column(name = "LAST_NAME", length = 200, nullable = false)
    private String lastName;
    
    @Column(name = "ADDRESS")
    private String address;

    /*@OneToMany(mappedBy = "customer", targetEntity = CustomerOrder.class, fetch = FetchType.EAGER)
    private Collection<CustomerOrder> orders;*/
       
    public Customer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /*public Collection<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(Collection<CustomerOrder> orders) {
        this.orders = orders;
    }*/

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + '}';
    }

}
