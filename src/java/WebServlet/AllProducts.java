
package WebServlet;

import Bean.ImagesBean;
import Model.Image;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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

@WebServlet(name = "AllProducts", urlPatterns = {"/AllProducts"})
public class AllProducts extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        EntityManager em = null;
        
        try
        {
            em = emf.createEntityManager();
        
            Query findAll = em.createNamedQuery("Image.findAll");
            Collection<Image> allImages = findAll.getResultList();

            ImagesBean imagesBean = getBean(allImages);
            sendData(imagesBean, request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            em.close();
        }
    }
    
    private void sendData(ImagesBean beans, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("AllProducts.jsp");
            request.setAttribute("result", beans);
            dispatcher.forward(request, response);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    private ImagesBean getBean(Collection<Image> allImages)
    {
        
        ImagesBean imagesBean = new ImagesBean();
        
        for(Image image : allImages) {
            byte[] imageData = image.getContent();
            imagesBean.setImagesData(imageData);
        }
        
        return imagesBean;
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
