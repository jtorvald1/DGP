
package Model.Webshop;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author jakelhamselv
 */
@Entity(name = "PRODUCTS")
@NamedQueries({                                        
    @NamedQuery(name = "Product.findByBrand", query = "SELECT p FROM PRODUCTS p WHERE p.brand = :brand"),
    @NamedQuery(name = "Product.findByColor", query = "SELECT p FROM PRODUCTS p WHERE p.color = :color"),
    @NamedQuery(name = "Product.findBySize", query = "SELECT p FROM PRODUCTS p WHERE p.size = :size")/*,
    @NamedQuery(name = "Product.findByBrand&Category", query = "SELECT p FROM PRODUCTS p WHERE p.brand = :brand AND p.category = :category")*/
})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
        
    @Column(name = "DESCRIPTION", length = 1000)
    private String description;
    
    @Column(name = "BRAND")
    private String brand;
    
    @Column(name = "COLOR")
    private String color;
    
    @Column(name = "PRODUCT_SIZE")
    private String size;
    
    @Column(name = "PRICE")
    private double price;
    
    @Column(name = "WEIGHT")
    private double weight;
    
    @Column(name = "CATEGORY")
    private String category;
    
    @OneToMany(mappedBy = "product", targetEntity = Item.class, fetch = FetchType.EAGER)
    private Collection<Item> items;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGE_ID")
    private Image image;
    
    public Product() {
    }

    public Product(String description, String brand, String color, String size, double price, double weight, String category, Collection<Item> items, Image image) {
        this.description = description;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
        this.weight = weight;
        this.category = category;
        this.items = items;
        this.image = image;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", description=" + description + ", brand=" + brand + ", color=" + color + ", size=" + size + ", price=" + price + ", weight=" + weight + ", category=" + category + ", items=" + items + ", image=" + image + '}';
    }
}
