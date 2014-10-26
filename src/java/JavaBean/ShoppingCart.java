
package JavaBean;

import java.util.ArrayList;

public class ShoppingCart {
    
    private ArrayList<CartItem> items;

    public ShoppingCart() {
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }
}
