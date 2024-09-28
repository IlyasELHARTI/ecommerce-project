package com.ilyas.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.ilyas.ecommerce.entity.Product;
import com.ilyas.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		
		HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
		
		// disable HTTP methods for Product: PUT, POST, DELETE
		config.getExposureConfiguration()
				.forDomainType(Product.class)
				.withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
		
		// disable HTTP methods for ProductCategory: PUT, POST, DELETE
				config.getExposureConfiguration()
						.forDomainType(ProductCategory.class)
						.withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
						.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
	}
	
	

}
