
package JavaBean;

import java.util.ArrayList;

public class ItemsBean {
    
    private ArrayList<ItemBean> items = new ArrayList<>();

    public ItemsBean() {
    }

    public ArrayList<ItemBean> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemBean> items) {
        this.items = items;
    }
}
