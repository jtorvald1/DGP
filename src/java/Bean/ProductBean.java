
package Bean;

public class ProductBean {
    
    private Long productId;
        
    private String description;
    
    private String brand;
    
    private String color;
    
    private String size;
    
    private double price;
    
    private double weight;
    
    private String category;
    
    private String image;

    public ProductBean() {
    }

    public ProductBean(Long productId, String description, String brand, String color, String size, double price, double weight, String category, String image) {
        this.productId = productId;
        this.description = description;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
        this.weight = weight;
        this.category = category;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
