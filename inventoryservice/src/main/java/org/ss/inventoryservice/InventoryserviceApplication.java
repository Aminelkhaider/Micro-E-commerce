package org.ss.inventoryservice;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.ss.inventoryservice.entity.Product;
import org.ss.inventoryservice.repo.ProductRepository;

@SpringBootApplication
public class InventoryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryserviceApplication.class, args);
	}
	@Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            productRepository.saveAll(
                    List.of(
                         Product.builder().name("Computer").quantity(12).price(1200).build(),
                            Product.builder().name("Printer").quantity(32).price(120).build(),
                            Product.builder().name("Smartphone").quantity(31).price(900).build()
                    )
            );
        };
    }

}
