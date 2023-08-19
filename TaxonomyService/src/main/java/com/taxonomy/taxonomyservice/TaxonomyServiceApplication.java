package com.taxonomy.taxonomyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TaxonomyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxonomyServiceApplication.class, args);
	}

}
