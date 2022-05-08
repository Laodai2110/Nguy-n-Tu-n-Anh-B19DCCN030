/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controll;
import Entity.Product;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(@RequestParam Map<String, String> form, ModelMap modelMap) {
        //Lay du lieu database
        //B1. Ket noi toi CSDL
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BT1994PU");
        EntityManager em = factory.createEntityManager();
        
        //B2. Tao query toi database
        Query q = null;
        if(form.containsKey("s")) {
            String s = form.get("s");
            
            q = em.createNamedQuery("Product.findByTitleLike", Product.class);
            q.setParameter("title", "%"+s+"%");
        } else {
            q = em.createNamedQuery("Product.findAll", Product.class);
        }
        
        //B3. Lay du lieu
        List<Product> list = q.getResultList();
        
        modelMap.put("productList", list);
        
        return "/product/index";
    }
    
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(@RequestParam Map<String, String> form, ModelMap modelMap) {
        Product product = new Product();
         @RequestMapping(value = "/view", method = RequestMethod.GET);
    public String view(@RequestParam Map<String, String> form, ModelMap modelMap){
        Product product = new Product();
        
        if(form.containsKey("id")) {
            int id = Integer.parseInt(form.get("id"));
            //B1. Ket noi toi CSDL
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("BT1994PU");
            EntityManager em = factory.createEntityManager();
            
            product = em.find(Product.class, id);
            
            if(product == null) {
                product = new Product();
            }
        }
        
        modelMap.put("product", product);
        
        return "/product/view";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam Map<String, String> form) {
        String title = form.get("title");
        String thumbnail = form.get("thumbnail");
        String content = form.get("content");
        float price = Float.parseFloat(form.get("price"));
        float discount = Float.parseFloat(form.get("discount"));
        
        int id = 0;
        if(form.containsKey("id") && !form.get("id").isEmpty()) {
            id = Integer.parseInt(form.get("id"));
        }
         EntityManagerFactory factory = Persistence.createEntityManagerFactory("BT1994PU");
        EntityManager em = factory.createEntityManager();
        
        if(id > 0) {
            //update
            Product productFind = em.find(Product.class, id);
            
            em.getTransaction().begin();
        
            productFind.setTitle(title);
            productFind.setThumbnail(thumbnail);
            productFind.setContent(content);
            productFind.setPrice(price);
            productFind.setDiscount(discount);
            productFind.setUpdatedAt(new Date());

            em.getTransaction().commit();
        } else {
            //insert
            em.getTransaction().begin();
        
            Product product = new Product();
            product.setTitle(title);
            product.setThumbnail(thumbnail);
            product.setContent(content);
            product.setPrice(price);
            product.setDiscount(discount);
            product.setCreatedAt(new Date());
            product.setUpdatedAt(new Date());

            em.persist(product);

            em.getTransaction().commit();
        }
        
        return "redirect:index.html";
    }@RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam Map<String, String> form) {
        int id = 0;
        if(form.containsKey("id") && !form.get("id").isEmpty()) {
            id = Integer.parseInt(form.get("id"));
        }
        
        //B1. Ket noi toi CSDL
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BT1994PU");
        EntityManager em = factory.createEntityManager();
        
        if(id > 0) {
            //delete
            Product productFind = em.find(Product.class, id);
            
            if(productFind != null) {
                em.getTransaction().begin();
                em.remove(productFind);
                em.getTransaction().commit();
            }
        }
        return "redirect:index.html";
    }
    
    //delete/1.html
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete2(@PathVariable int id) {
        //B1. Ket noi toi CSDL
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BT1994PU");
        EntityManager em = factory.createEntityManager();
        
        if(id > 0) {
            //delete
            Product productFind = em.find(Product.class, id);
            
            if(productFind != null) {
                em.getTransaction().begin();
                em.remove(productFind);
                em.getTransaction().commit();
            }
        }
        return "redirect:index.html";
    }
}
}
