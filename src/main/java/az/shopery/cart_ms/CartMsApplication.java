package az.shopery.cart_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CartMsApplication {

	static void main(String[] args) {
		SpringApplication.run(CartMsApplication.class, args);
	}
}
