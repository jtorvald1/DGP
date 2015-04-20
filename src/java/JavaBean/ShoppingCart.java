
package JavaBean;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {
    
    private ArrayList<CartItem> items = new ArrayList<>();
    private int numberOfItems;
    private double totalPrice;

    public ShoppingCart() {
        numberOfItems = 0;
        totalPrice = 0;
    }
    
    public void incrementNumberOfItems()
    {
        numberOfItems++;
    }
    
    public void updateTotalPrice()
    {
       totalPrice = 0;        
        
       for(CartItem cartItem: items)
       {
           double unitPrice = cartItem.getProduct().getPrice();
           int quantity = cartItem.getQuantity();
           
           totalPrice += unitPrice * quantity;
       }
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

    public void subtractNumberOfItems() {
        numberOfItems--;
    }

    public void minusItem(ProductBean productToAdd) {
        Iterator<CartItem> it = items.iterator();
        while(it.hasNext()) 
        {
            CartItem cartItem = it.next();
            if (cartItem.getProduct().getProductId() == productToAdd.getProductId())
            {
               cartItem.minusQuantity(); 
               if (cartItem.getQuantity() < 1)
               {
                   it.remove();
               }
            }
        }
    }

    public void plusItem(ProductBean productToAdd) {
        for(CartItem cartItem: items)
            if (cartItem.getProduct().getProductId() == productToAdd.getProductId())
            {
               cartItem.incrementQuantity(); 
            }
    }
}
