
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author jakelhamselv
 */
@Entity(name = "ITEMS")
@NamedQueries({
    @NamedQuery(name = "Item.findAvailable", query = "SELECT i FROM ITEMS i WHERE i.order IS NULL AND i.product.productId = :productId")
})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ITEM_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Item() {
    }

    public Item(Long itemId, CustomerOrder order, Product product, Stock stock) {
        this.itemId = itemId;
        this.order = order;
        this.product = product;
        this.stock = stock;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
