package com.example.saleshippingstatus;

//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.boot.web.client.RestTemplateBuilder;


@RestController
@Api(value="Sale Management System")
public class SaleController {
	@Bean
	public RestTemplate restTemp(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	RestTemplate restTemp = new RestTemplate();
	

	@ApiOperation(value = "Get shipping status by sale id")
	@RequestMapping(value="/sale/{saleId}/shipping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getShippingStatus(@PathVariable int saleId) {
		String logShippingMessage = "";
		
		try {
			String shippingUrl = "http://5e209e06e31c6e0014c60962.mockapi.io/api/shipping/" + saleId;
			Shipping shipping = restTemp.getForObject(shippingUrl, Shipping.class);
			logShippingMessage = shipping.toString();
		}catch (final HttpClientErrorException e) {
			if(e.getStatusCode() == HttpStatus.NOT_FOUND) {
				logShippingMessage = "{'status':'Kargo durumu bulunamadi'}";
			}else {
				logShippingMessage = e.getStatusCode() + e.getResponseBodyAsString();
			}
		}
		
		try {
			String saleUrl = "http://5e209e06e31c6e0014c60962.mockapi.io/api/sales/" + saleId;
			Sale sale = restTemp.getForObject(saleUrl, Sale.class);
			logShippingMessage += sale.toString();
			int productId = sale.getProductId();
			String productUrl = "http://5e209e06e31c6e0014c60962.mockapi.io/api/products/" + productId;
			try {
				Product product = restTemp.getForObject(productUrl, Product.class);
				logShippingMessage += product.toString();
			}catch (final HttpClientErrorException e) {
				if(e.getStatusCode() == HttpStatus.NOT_FOUND) {
					logShippingMessage = "{'status':'Urun bulunamadi, teslim edilmedi'}";
				}else {
					logShippingMessage = e.getStatusCode() + productUrl + e.getResponseBodyAsString();
				}
			}
		}catch (final HttpClientErrorException e) {
			if(e.getStatusCode() == HttpStatus.NOT_FOUND) {
				logShippingMessage = "{'status':'Satis bulunamadi, teslim edilmedi'}";
			}else {
				logShippingMessage = e.getStatusCode() + e.getResponseBodyAsString();
			}
		}	
		//ResponseEntity<String> resShippingMessage = new ResponseEntity<String>(logShippingMessage, HttpStatus.OK);
		//return resShippingMessage;
		return logShippingMessage;
	}
}
