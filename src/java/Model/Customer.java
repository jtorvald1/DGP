/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Webshop;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author jakelhamselv
 */
@Entity(name = "CUSTOMERS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
    @NamedQuery(name = "Customer.findByPassword", query = "SELECT u FROM CUSTOMERS u WHERE u.email = :email AND u.password = :password"),
    @NamedQuery(name = "Customer.findByUserName", query = "SELECT u FROM CUSTOMERS u WHERE u.userName = :username"),
    @NamedQuery(name = "Customer.findAllUsers", query = "SELECT u FROM CUSTOMERS u"),
})
public abstract class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CUSTOMER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    
    @Column(name = "FIRST_NAME", length = 200, nullable = false)
    private String firstName;
    
    @Column(name = "LAST_NAME", length = 200, nullable = false)
    private String lastName;
    
    @Column(name = "USERNAME", length = 200, nullable = false)
    private String userName;
    
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "EMAIL", length = 320, nullable = false)
    private String email;
    
    @Column(name = "PASSWORD", length = 200, nullable = false)
    private String password;

    @OneToMany(mappedBy = "customer", targetEntity = CustomerOrder.class, fetch = FetchType.EAGER)
    private Collection<CustomerOrder> orders;
       
    public Customer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Collection<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(Collection<CustomerOrder> orders) {
        this.orders = orders;
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
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + "username=" + userName + ", address=" + address + '}';
    }
}
