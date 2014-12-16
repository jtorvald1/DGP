
package JavaBean;

import java.util.ArrayList;

public class OrdersBean {
    
    private ArrayList<OrderBean> orderBeans = new ArrayList<>();

    public OrdersBean() {
    }

    public ArrayList<OrderBean> getOrders() {
        return orderBeans;
    }

    public void setOrders(ArrayList<OrderBean> orderBeans) {
        this.orderBeans = orderBeans;
    }
}
