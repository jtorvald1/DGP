
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author jakelhamselv
 */
@Entity(name = "INVOICES")
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "INVOICE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;
    
    @Column(name = "TOTAL_PRICE", precision = 2)
    private double totalPrice;
    
    @OneToOne(mappedBy = "invoice")
    @JoinColumn(name = "ORDER_ID")
    private CustomerOrder order;
    
    @OneToMany(mappedBy = "invoice", targetEntity = OrderLine.class, fetch = FetchType.EAGER)
    private Collection<OrderLine> orderLines;

    public Invoice() {
    }

    public Invoice(CustomerOrder order) {
        this.order = order;
        createOrderLines();
    }  
        
    private void createOrderLines()
    {      
        Collection<Item> items = order.getItems();
        orderLines = new ArrayList();
        
        for(Item item: items) {
            orderLines.add(new OrderLine());
        }
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public void setOrder(CustomerOrder order) {
        this.order = order;
    }

    public Collection<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Collection<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
