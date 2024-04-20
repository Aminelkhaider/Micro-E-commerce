package org.ss.customerservice;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.ss.customerservice.entity.Customer;
import org.ss.customerservice.repo.CustomerRepository;


@SpringBootApplication
public class CustomerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Customer.class);
		   	customerRepository.saveAll(List.of(
					Customer.builder().name("Amine").email("amine@gmail.com").build(),
					Customer.builder().name("Oussama").email("ouss@gmail.com").build(),
					Customer.builder().name("IMane").email("imane@gmail.com").build()
			));
			   customerRepository.findAll().forEach(System.out::println);
		};
	}

}
