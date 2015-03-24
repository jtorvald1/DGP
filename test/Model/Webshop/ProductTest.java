/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Webshop;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jakelhamselv
 */
public class ProductTest {
    
    public ProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProductId method, of class Product.
     */
    @Test
    public void testChangeWeight() {
        System.out.println("testChangeWeight");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", null, new Image());
        String expDescription = "T-shirt";
        String expBrand = "Nike";
        String expColor = "Red";
        String expSize = "L";
        double expPrice = 79.95;
        int expWeight = 200;
        String expCategory = "cloth";
        assertEquals(expDescription, instance.getDescription());
        assertEquals(expBrand, instance.getBrand());
        assertEquals(expColor, instance.getColor());
        assertEquals(expSize, instance.getSize());
        assertEquals(expPrice, instance.getPrice(), 1.0);
        assertEquals(expWeight, instance.getWeight(), 0.1);
        assertEquals(expCategory, instance.getCategory());
        double newExpWeight = 5000;
        instance.setWeight(5000);
        assertEquals(newExpWeight, instance.getWeight(), 0.1);
    }
    
    @Test
    public void testChangePrice() {
        System.out.println("testChangePrice");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", null, new Image());
        String expDescription = "T-shirt";
        String expBrand = "Nike";
        String expColor = "Red";
        String expSize = "L";
        double expPrice = 79.95;
        int expWeight = 200;
        String expCategory = "cloth";
        assertEquals(expDescription, instance.getDescription());
        assertEquals(expBrand, instance.getBrand());
        assertEquals(expColor, instance.getColor());
        assertEquals(expSize, instance.getSize());
        assertEquals(expPrice, instance.getPrice(), 1.0);
        assertEquals(expWeight, instance.getWeight(), 0.1);
        assertEquals(expCategory, instance.getCategory());
        double newPrice = 5000.01;
        instance.setPrice(5000.01);
        assertEquals(newPrice, instance.getPrice(), 1.0);
    }
    
    @Test
    public void testChangeCategory() {
        System.out.println("testChangeCategory");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", null, new Image());
        String expDescription = "T-shirt";
        String expBrand = "Nike";
        String expColor = "Red";
        String expSize = "L";
        double expPrice = 79.95;
        int expWeight = 200;
        String expCategory = "cloth";
        assertEquals(expDescription, instance.getDescription());
        assertEquals(expBrand, instance.getBrand());
        assertEquals(expColor, instance.getColor());
        assertEquals(expSize, instance.getSize());
        assertEquals(expPrice, instance.getPrice(), 1.0);
        assertEquals(expWeight, instance.getWeight(), 0.1);
        assertEquals(expCategory, instance.getCategory());
        String newCategory = "item";
        instance.setCategory("item");
        assertEquals(newCategory, instance.getCategory());
    }
    
    @Test
    public void testChangeSize() {
        System.out.println("testChangeSize");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", null, new Image());
        String expDescription = "T-shirt";
        String expBrand = "Nike";
        String expColor = "Red";
        String expSize = "L";
        double expPrice = 79.95;
        int expWeight = 200;
        String expCategory = "cloth";
        assertEquals(expDescription, instance.getDescription());
        assertEquals(expBrand, instance.getBrand());
        assertEquals(expColor, instance.getColor());
        assertEquals(expSize, instance.getSize());
        assertEquals(expPrice, instance.getPrice(), 1.0);
        assertEquals(expWeight, instance.getWeight(), 0.1);
        assertEquals(expCategory, instance.getCategory());
        String newSize = "S";
        instance.setSize("S");
        assertEquals(newSize, instance.getSize());
    }
    
    @Test
    public void testChangeDescription() throws IOException {
        System.out.println("testChangeDescription");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", null, new Image());
        String expDescription = "T-shirt";
        String expBrand = "Nike";
        String expColor = "Red";
        String expSize = "L";
        double expPrice = 79.95;
        int expWeight = 200;
        String expCategory = "cloth";
        assertEquals(expDescription, instance.getDescription());
        assertEquals(expBrand, instance.getBrand());
        assertEquals(expColor, instance.getColor());
        assertEquals(expSize, instance.getSize());
        assertEquals(expPrice, instance.getPrice(), 1.0);
        assertEquals(expWeight, instance.getWeight(), 0.1);
        assertEquals(expCategory, instance.getCategory());
        String newDescription = "Ball";
        instance.setDescription("Ball");
        assertEquals(newDescription, instance.getDescription());
    }
    
    @Test
    public void testChangeImage() throws IOException {
        System.out.println("testChangeImage");
        
        File file = new File("Image1.jpg");
        byte[] fileContent = Files.readAllBytes(file.toPath());
        Image image = new Image(null, "Image1.jpg", fileContent);
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", null, image);
        String expDescription = "T-shirt";
        String expBrand = "Nike";
        String expColor = "Red";
        String expSize = "L";
        double expPrice = 79.95;
        int expWeight = 200;
        String expCategory = "cloth";
        assertEquals(expDescription, instance.getDescription());
        assertEquals(expBrand, instance.getBrand());
        assertEquals(expColor, instance.getColor());
        assertEquals(expSize, instance.getSize());
        assertEquals(expPrice, instance.getPrice(), 1.0);
        assertEquals(expWeight, instance.getWeight(), 0.1);
        assertEquals(expCategory, instance.getCategory());
        
        File file2 = new File("Image2.jpg");
        byte[] fileContent2 = Files.readAllBytes(file2.toPath());
        Image newImage = new Image(null, "Image2.jpg", fileContent2);
        
        instance.setImage(new Image(null, "Image2.jpg", Files.readAllBytes(new File("Image2.jpg").toPath())));
        assertEquals(newImage, instance.getDescription());
    }
    
    @Test
    public void testChangeColor() {
        System.out.println("testChangeColor");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", null, new Image());
        String expDescription = "T-shirt";
        String expBrand = "Nike";
        String expColor = "Red";
        String expSize = "L";
        double expPrice = 79.95;
        int expWeight = 200;
        String expCategory = "cloth";
        assertEquals(expDescription, instance.getDescription());
        assertEquals(expBrand, instance.getBrand());
        assertEquals(expColor, instance.getColor());
        assertEquals(expSize, instance.getSize());
        assertEquals(expPrice, instance.getPrice(), 1.0);
        assertEquals(expWeight, instance.getWeight(), 0.1);
        assertEquals(expCategory, instance.getCategory());
        String newColor = "Black";
        instance.setColor("Black");
        assertEquals(newColor, instance.getColor());
    }
    
    @Test
    public void testChangeBrand() {
        System.out.println("testChangeBrand");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", null, new Image());
        String expDescription = "T-shirt";
        String expBrand = "Nike";
        String expColor = "Red";
        String expSize = "L";
        double expPrice = 79.95;
        int expWeight = 200;
        String expCategory = "cloth";
        assertEquals(expDescription, instance.getDescription());
        assertEquals(expBrand, instance.getBrand());
        assertEquals(expColor, instance.getColor());
        assertEquals(expSize, instance.getSize());
        assertEquals(expPrice, instance.getPrice(), 1.0);
        assertEquals(expWeight, instance.getWeight(), 0.1);
        assertEquals(expCategory, instance.getCategory());
        String newBrand = "Adidas";
        instance.setBrand("Adidas");
        assertEquals(newBrand, instance.getBrand());
    }
    
    @Test
    public void testAddToProduct() {
        System.out.println("testAddToProduct");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", new ArrayList<Item>(), new Image());
        Collection<Item> stock = new ArrayList<>();
        for(int i = 0; i < 10; i++)
        {
            stock = instance.getItems();
            stock.add(new Item());
        }
        int expStockSize = 10;
        assertEquals(expStockSize, stock.size());
    }
    
        @Test
    public void testDeleteStockProduct() {
        System.out.println("testDeleteStockProduct");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", new ArrayList<Item>(), new Image());
        Collection<Item> stock = new ArrayList<>();
        for(int i = 0; i < 10; i++)
        {
            stock = instance.getItems();
            stock.add(new Item());
        }
        stock.clear();
        int expStockSize = 0;
        assertEquals(expStockSize, stock.size());

    }
    
    @Test
    public void testDeleteSingleProduct() {
        System.out.println("testDeleteStockProduct");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", new ArrayList<Item>(), new Image());
        Collection<Item> stock = new ArrayList<>();
        for(int i = 0; i < 10; i++)
        {
            stock = instance.getItems();
            stock.add(new Item());
        }
        stock.remove(new Item());
        int expStockSize = 9;
        assertEquals(expStockSize, stock.size());
    }
    
    @Test
    public void testSearchCategory() {
        System.out.println("testSearchCategory");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", new ArrayList<Item>(), new Image());
        Product instance2 = new Product("T-shirt", "Nike", "Blue", "L", 79.95, 200, "cloth", new ArrayList<Item>(), new Image());
        Product instance3 = new Product("Ball", "Nike", "Red", "OneSize", 79.95, 200, "item", new ArrayList<Item>(), new Image());
        ArrayList<Product> prods = new ArrayList<>();
        prods.add(instance);
        prods.add(instance2);
        prods.add(instance3);
        ArrayList<Product> result = new ArrayList<>();
        for (Product product: prods)
        {
            if (product.getCategory().equals("cloth"))
            {
                result.add(product);
            }
        }
        int expSize = 2;
        assertEquals(expSize, result.size());
    }
    
    @Test
    public void testSearchBrand() {
        System.out.println("testSearchBrand");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", new ArrayList<Item>(), new Image());
        Product instance2 = new Product("T-shirt", "Adidas", "Blue", "L", 79.95, 200, "cloth", new ArrayList<Item>(), new Image());
        Product instance3 = new Product("Ball", "Nike", "Red", "OneSize", 79.95, 200, "item", new ArrayList<Item>(), new Image());
        ArrayList<Product> prods = new ArrayList<>();
        prods.add(instance);
        prods.add(instance2);
        prods.add(instance3);
        ArrayList<Product> result = new ArrayList<>();
        for (Product product: prods)
        {
            if (product.getBrand().equals("Adidas"))
            {
                result.add(product);
            }
        }
        int expSize = 1;
        assertEquals(expSize, result.size());
    }
    
    @Test
    public void testSearchDescription() {
        System.out.println("testSearchDescription");
        Product instance = new Product("T-shirt", "Nike", "Red", "L", 79.95, 200, "cloth", new ArrayList<Item>(), new Image());
        Product instance2 = new Product("T-shirt", "Adidas", "Blue", "OneSize", 79.95, 200, "cloth", new ArrayList<Item>(), new Image());
        Product instance3 = new Product("Ball", "Nike", "Red", "OneSize", 79.95, 200, "item", new ArrayList<Item>(), new Image());
        ArrayList<Product> prods = new ArrayList<>();
        prods.add(instance);
        prods.add(instance2);
        prods.add(instance3);
        ArrayList<Product> result = new ArrayList<>();
        for (Product product: prods)
        {
            if (product.getDescription().equals("Ball"))
            {
                result.add(product);
            }
        }
        int expSize = 1;
        assertEquals(expSize, result.size());
    }
}
