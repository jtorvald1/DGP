
package WebServlet;

import JavaBean.ProductBean;
import JavaBean.ProductsBean;
import Model.Webshop.Base64Encoder;
import Model.Webshop.Product;
import SessionBean.ProductFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Nicole
 */
@WebServlet(name = "AdminProductSearch", urlPatterns = {"/AdminProductSearch"})
public class AdminProductSearch extends HttpServlet {

    @EJB
    private ProductFacade productSessionFacade;
 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try
        {
            String searchBy = request.getParameter("searchBy");
            String value = request.getParameter("value");
                                   
            Collection<Product> products;
            
            switch(searchBy) 
            {
                case "ID": 
                    Product product = productSessionFacade.find(Long.parseLong(value));
                    products = new ArrayList<>();
                    if(product != null)
                        products.add(product);                
                    break;
                case "brand": products = productSessionFacade.findByBrand(value); break;
                case "color": products = productSessionFacade.findByColor(value); break;
                case "size": products = productSessionFacade.findBySize(value); break;
                default: products = productSessionFacade.findAll(); break;
            }

            ProductsBean searchResult = getBean(products);           

            request.setAttribute("result", searchResult);
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminProducts.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private ProductsBean getBean(Collection<Product> allProducts)
    {
        ProductsBean bean = new ProductsBean();
        
        for(Product product : allProducts) {

            byte[] imageData = product.getImage().getContent();
            String imageDataString = Base64Encoder.getByteArrayString(imageData);
            
            ProductBean productBean = getProductBean(product);
            productBean.setImage(imageDataString);
            
            bean.getAllProducts().add(productBean);
        }
        
        return bean;
    }
    
    private ProductBean getProductBean(Product product)
    {
        ProductBean productBean = new ProductBean();
        productBean.setProductId(product.getProductId());
        productBean.setDescription(product.getDescription());
        productBean.setSize(product.getSize());
        productBean.setWeight(product.getWeight());
        productBean.setBrand(product.getBrand());
        productBean.setCategory(product.getCategory());
        productBean.setPrice(product.getPrice());
        productBean.setColor(product.getColor());
        
        return productBean;                
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
