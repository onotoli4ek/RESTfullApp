package service;


import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAService {
    public EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    public static void main(String[] args) {
        JPAService service = new JPAService();
        Product product = new Product();
        product.setName("uuuu@ua");
        product.setQty(21);
        service.add(product);
        System.exit(0);
    }
    public Product add (Product product) {
        em.getTransaction().begin();
        Product productFromDB = em.merge(product);
        em.getTransaction().commit();
        return productFromDB;
    }
}
