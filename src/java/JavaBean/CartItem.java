
package JavaBean;

public class CartItem {
    
    private ProductBean product;
    private int quantity;

    public CartItem() {
        quantity = 1;
    }

    public void incrementQuantity()
    {
        quantity++;
    }
    
    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" + "product=" + product + ", quantity=" + quantity + '}';
    }
}
