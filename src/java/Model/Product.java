
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jakelhamselv
 */
@Entity(name = "PRODUCTS")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    
    @Column(name = "BRAND", nullable = false)
    private String brand;
    
    @Column(name = "DESCRIPTION", length = 1000)
    private String description;
    
    @Column(name = "PRICE")
    private double price;
    
    @OneToMany(mappedBy = "product", targetEntity = Item.class, fetch = FetchType.EAGER)
    private Collection<Item> items;

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
}
