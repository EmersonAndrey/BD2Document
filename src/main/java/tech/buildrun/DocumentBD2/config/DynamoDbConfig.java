package tech.buildrun.DocumentBD2.config;

import java.net.URI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig {

	@Bean
	public DynamoDbClient dynamoDbClient() {
		return DynamoDbClient.builder()
				.endpointOverride(URI.create("http://localhost:4566"))
				.region(Region.SA_EAST_1)
				.build();
	}
	
	
}
