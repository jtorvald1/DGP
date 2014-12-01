
package WebServlet;

import JavaBean.ProductBean;
import JavaBean.ProductsBean;
import Model.Base64Encoder;
import Model.Product;
import SessionBean.ProductFacade;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AllProducts", urlPatterns = {"/AllProducts"})
public class AllProducts extends HttpServlet {
    
    @EJB
    private ProductFacade productSessionFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try
        {
            List<Product> allProducts = productSessionFacade.findAll();
            ProductsBean bean = getBean(allProducts);

            sendData(bean, request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    private void sendData(ProductsBean bean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("webshop.jsp");
            request.setAttribute("result", bean);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
}