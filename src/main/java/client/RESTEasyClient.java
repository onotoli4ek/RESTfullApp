package client;

import entity.Product;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class RESTEasyClient {
    public static void main(String[] args) {
        Product product = new Product();
        product.setName("Vasya");
        product.setQty(13);
        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target("http://localhost:8080/json/product/post");
            Response response = target.request().post(Entity.entity(product, "application/json"));
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code: " + response.getStatus());
            }
            System.out.println("Server response : \n");
            System.out.println(response.readEntity(String.class));
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
