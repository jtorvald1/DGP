
package JavaBean;

import java.util.ArrayList;

public class ShoppingCart {
    
    private ArrayList<CartItem> items = new ArrayList<CartItem>();
    private int numberOfItems;
    private double totalPrice;

    public ShoppingCart() {
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "items=" + items + ", numberOfItems=" + numberOfItems + ", totalPrice=" + totalPrice + '}';
    }
}
