
package Model.Webshop;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jacob Nørgaard
 */
@Entity(name = "ORDER_LINES")
public class OrderLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderLineId;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;
    
    @Column(name = "QUANTITY")
    private int quantity;
        
    @Column(name = "LINE_PRICE")
    private double linePrice;

    public OrderLine() {
    }

    public Long getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(Long orderLineId) {
        this.orderLineId = orderLineId;
    }    
}
