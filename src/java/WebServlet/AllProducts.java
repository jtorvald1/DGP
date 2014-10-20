
package WebServlet;

import Bean.ImagesBean;
import Bean.ProductBean;
import Bean.ProductsBean;
import Model.Image;
import Model.Product;
import java.io.IOException;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;

@WebServlet(name = "AllProducts", urlPatterns = {"/AllProducts"})
public class AllProducts extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        EntityManager em = null;
        
        try
        {
            em = emf.createEntityManager();
                   
            Query findAll = em.createNamedQuery("Product.findAll");
            Collection<Product> allProducts = findAll.getResultList();

            ProductsBean bean = getBean(allProducts);
            sendData(bean, request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        finally
        {
            if(em != null)
                em.close();
        }
    }
    
    private void sendData(ProductsBean bean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("AllProducts.jsp");
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
            String imageDataString = getByteArrayString(imageData);
            
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
      
    private String getByteArrayString(byte[] imageData)
    {
        return Base64.encodeBase64String(imageData);
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
