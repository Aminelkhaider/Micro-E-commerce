package org.sid.orderservice.services;


import org.sid.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "inventoryservice")
public interface InventoryRestClientService {
    @GetMapping("/products/{id}")
    public Product productById(@PathVariable Long id);
    @GetMapping("/products")
    public PagedModel<Product> allProducts();
}
