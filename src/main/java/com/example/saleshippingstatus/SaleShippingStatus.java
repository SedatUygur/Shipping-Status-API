package com.example.saleshippingstatus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;*/

@EnableSwagger2
@SpringBootApplication
public class SaleShippingStatus {
	/*private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		int saleId = 3;
		String shippingUrl = "http://5e209e06e31c6e0014c60962.mockapi.io/api/shipping/" + saleId;
		Shipping shipping = restTemplate.getForObject(shippingUrl, Shipping.class);
		//String logShippingMessage = shipping.toString();
		
		String saleUrl = "http://5e209e06e31c6e0014c60962.mockapi.io/api/sales/" + saleId;
		Sale sale = restTemplate.getForObject(saleUrl, Sale.class);
		//logShippingMessage += sale.toString();
		
		int productId = sale.getProductId();
		String productUrl = "http://5e209e06e31c6e0014c60962.mockapi.io/api/products/" + productId;
		Product product = restTemplate.getForObject(productUrl, Product.class);
		//logShippingMessage += product.toString();
		
		return args -> {
			//Sale sale = restTemplate.getForObject("http://5e209e06e31c6e0014c60962.mockapi.io/api/sales/3", Sale.class);
			String logShippingMessage = shipping.toString();
			logShippingMessage += sale.toString();
			logShippingMessage += product.toString();
			log.info(logShippingMessage);
		};
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(SaleShippingStatus.class, args);
	}

}
