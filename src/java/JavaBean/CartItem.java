
package JavaBean;

public class CartItem {
    
    private Long productId;
    
    private Long itemId;
        
    private String description;
    
    private String brand;
    
    private String color;
    
    private String size;
    
    private double price;
    
    private double weight;
       
    private String image;

    public CartItem() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "CartItem{" + "productId=" + productId + ", itemId=" + itemId + ", description=" + description + ", brand=" + brand + ", color=" + color + ", size=" + size + ", price=" + price + ", weight=" + weight + ", image=" + image + '}';
    }
}
