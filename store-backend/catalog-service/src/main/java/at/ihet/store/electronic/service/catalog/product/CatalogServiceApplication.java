package at.ihet.store.electronic.service.catalog.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebConfiguration.class)
public class CatalogServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}
}
