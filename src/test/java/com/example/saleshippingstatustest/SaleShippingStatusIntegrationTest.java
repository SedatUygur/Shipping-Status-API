package com.example.saleshippingstatustest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.example.saleshippingstatus.SaleController;

import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes=SaleController.class)
class SaleShippingStatusIntegrationTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void getDefaultShippingStatus() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/sale/3/shipping",String.class)).contains("'sale':{'id':3, 'code':'0c784421-3cbb-4566-ab72-06628413758b'}");
		//assertThat(controller).isNotNull();
	}

}
