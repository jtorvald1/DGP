
package WebServlet;

import Model.Image;
import Model.Product;
import SessionBean.ProductFacade;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.apache.commons.io.IOUtils;

@WebServlet(name = "CreateProduct", urlPatterns = {"/CreateProduct"})
@MultipartConfig(maxFileSize = 10000000)
public class CreateProduct extends HttpServlet {
        
    @EJB
    private ProductFacade productFacade;
    
    @Resource
    private UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               
        try
        {
            Image image = getImage(request);
            Product product = getProduct(request);
                        
            product.setImage(image);
            Product productGeneratedId = persist(product);
            
            request.setAttribute("productGeneratedId", productGeneratedId);
            RequestDispatcher dispather = request.getRequestDispatcher("/CreateItems");
            dispather.forward(request, response);
        }
        catch(Exception e)
        {
            throw new ServletException();
        }
    }
    
    private Product persist(Product product) throws IllegalStateException, SecurityException, SystemException
    {
        try
        {
            utx.begin();
            
            productFacade.create(product);
            productFacade.flushEntityManager();

            utx.commit();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            utx.rollback();
        }
        return product;
    }
    
    private Product getProduct(HttpServletRequest request)
    {
        Product product = null;
        
        try
        {
            String description = request.getParameter("description");
            String brand = request.getParameter("brand");
            String color = request.getParameter("color");
            String size = request.getParameter("size");
            String price = request.getParameter("price");
            String weight = request.getParameter("weight");
            String category = request.getParameter("category");

            double priceDouble = Double.parseDouble(price);
            double weightDouble = Double.parseDouble(weight);
            
            product = new Product(description, brand, color, size, priceDouble, weightDouble, category, null, null);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }

        return product;
    }
    
    private Image getImage(HttpServletRequest request) throws IOException, ServletException
    {
        Image image = null;
        
        try
        {
            Part filePart = request.getPart("image");

            InputStream in = filePart.getInputStream();

            byte[] imageBytes = IOUtils.toByteArray(in);
            String fileName = filePart.getSubmittedFileName();

            image = new Image(null, fileName, imageBytes);
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (ServletException ex) {
            System.out.println(ex.getMessage());
        }
            return image;
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
