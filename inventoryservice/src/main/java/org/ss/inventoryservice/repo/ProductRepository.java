package org.ss.inventoryservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.ss.inventoryservice.entity.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
}
