
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "CUSTOMER_ORDERS")
public class CustomerOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "ORDER_DATE_TIME")
    private String dateTime;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    
    @OneToMany(mappedBy = "order", targetEntity = Item.class, fetch = FetchType.EAGER)
    private Collection<Item> items;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "SHIPPING_ID")
    private Shipping shipping;

    public CustomerOrder() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
