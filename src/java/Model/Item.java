
package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author jakelhamselv
 */
@Entity(name = "ITEMS")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ITEM_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ORDER_ID")
    private CustomerOrder order;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;
    
    public Long getId() {
        return itemId;
    }

    public void setId(Long id) {
        this.itemId = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public void setOrder(CustomerOrder order) {
        this.order = order;
    }
}
