package org.ss.customerservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.ss.customerservice.entity.Customer;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}