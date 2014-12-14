
package WebServlet;

import Model.Webshop.Image;
import Model.Webshop.Item;
import Model.Webshop.Product;
import SessionBean.ItemFacade;
import SessionBean.ProductFacade;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
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

@WebServlet(name = "AdminProductEdit", urlPatterns = {"/AdminProductEdit"})
@MultipartConfig(maxFileSize = 10000000)
public class AdminProductEdit extends HttpServlet {
    
    @EJB
    private ProductFacade productFacade;
    @EJB
    private ItemFacade itemFacade;
    
    @Resource
    private UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalStateException, SecurityException, SystemException 
    {       
        String operation = request.getParameter("operation");
        String productId = request.getParameter("productId");      
        
        switch(operation)
        {
            case "delete": deleteProduct(productId, response); break;
            case "Edit product": editProduct(productId, request, response); break;
            case "Create new product": createProduct(request, response); break;
        }
    }
    
    private void deleteProduct(String productId, HttpServletResponse response) throws IllegalStateException, SecurityException, SystemException
    {
        try
        {
            Product product = productFacade.find(Long.parseLong(productId));
            
            if(product != null)
            {
                deleteItems(product);
                
                utx.begin();

                productFacade.remove(product);
            
                utx.commit();
            }
            response.sendRedirect("AdminProducts.jsp");
        }
        catch(Exception ex)
        {
            utx.rollback();
            System.out.println(ex);
        }
    }
    
    private void deleteItems(Product product) throws IllegalStateException, SecurityException, SystemException
    {
        try
        {
            Collection<Item> items = product.getItems();
            
            utx.begin();

            for(Item item: items)
            {
                itemFacade.remove(item);
            }
            utx.commit();
        }
        catch(Exception ex)
        {
            utx.rollback();
            System.out.println(ex);
        }
    }

    private void editProduct(String productId, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, SecurityException, SystemException 
    {
        try
        {
            Product product = productFacade.find(Long.parseLong(productId));

            if(product != null)
            {
                Image image = getImage(request);
                product = setNewProductParameters(product, request);
                
                utx.begin();
                
                product.setImage(image);
                productFacade.edit(product);
                
                utx.commit();
            }
            response.sendRedirect("AdminProducts.jsp");
        }
        catch(Exception ex)
        {
            utx.rollback();
            System.out.println(ex);
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, SecurityException, SystemException
    {
        try
        {
            Image image = getImage(request);
            Product product = getProduct(request);
            String items = request.getParameter("items"); 
                        
            product.setImage(image);
            
            utx.begin();
            
            productFacade.create(product);
            productFacade.flushEntityManager();

            utx.commit();
                      
            request.setAttribute("productGeneratedId", product);
            request.setAttribute("items", items);
            RequestDispatcher dispather = request.getRequestDispatcher("/CreateItems");
            dispather.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);

        }
    }
    
    private Product setNewProductParameters(Product product, HttpServletRequest request)
    {
        String category = request.getParameter("category");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String size = request.getParameter("size");
        String price = request.getParameter("price");
        String weight = request.getParameter("weight");
        String description = request.getParameter("description");
        
        product.setCategory(category);
        product.setBrand(brand);
        product.setColor(color);
        product.setSize(size);
        product.setPrice(Double.parseDouble(price));
        product.setWeight(Double.parseDouble(weight));
        product.setDescription(description);
        
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
        try
        {
            processRequest(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            processRequest(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
