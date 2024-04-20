package org.sid.orderservice.services;

import org.sid.orderservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@FeignClient(name = "customerservice")
public interface CustomerRestClientService {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerservice",fallbackMethod = "getDefaultCustomer()")
    public Customer customerById(@PathVariable Long id);
    @GetMapping("/customers")
    public PagedModel<Customer> allCustomers();
    
    
    default Customer getDefaultCustomer( Long id, Exception exception) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Not available");
        customer.setEmail("Not available");
        return customer;
    }

}
