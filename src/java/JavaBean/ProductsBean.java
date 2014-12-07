
package JavaBean;

import java.util.ArrayList;

public class ProductsBean {
    
    private ArrayList<ProductBean> allProducts = new ArrayList<>();

    public ProductsBean() {
    }
    
    public ProductBean searchByColorAndSize(String size, String color)
    {
        for(ProductBean product: allProducts)
        {
            if(product.getColor().equals(color) && product.getSize().equals(size))
                return product;
        }
        return new ProductBean();
    }

    public ArrayList<ProductBean> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(ArrayList<ProductBean> allProducts) {
        this.allProducts = allProducts;
    }

    @Override
    public String toString() {
        return "ProductsBean{" + "allProducts=" + allProducts + '}';
    }
}
