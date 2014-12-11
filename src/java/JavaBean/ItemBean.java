
package JavaBean;

public class ItemBean {
    
    private Long ItemId;
    private Long ProductId;
    private Long StockId;
    private Long OrderId;

    public ItemBean() {
    }

    public Long getItemId() {
        return ItemId;
    }

    public void setItemId(Long ItemId) {
        this.ItemId = ItemId;
    }

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long ProductId) {
        this.ProductId = ProductId;
    }

    public Long getStockId() {
        return StockId;
    }

    public void setStockId(Long StockId) {
        this.StockId = StockId;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long OrderId) {
        this.OrderId = OrderId;
    }
}
