package kr.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "kr.spring.log.repository")
public class MongoDBConfig {
    
	@Autowired
	private MongoDatabaseFactory mongoDatabaseFactory;
	
	@Autowired
	private MongoMappingContext mongoMappingContext;

    @Bean
	public MappingMongoConverter mappingMongoConverter() {
		MappingMongoConverter converter = new MappingMongoConverter(
				new DefaultDbRefResolver(mongoDatabaseFactory), mongoMappingContext);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		return converter;
	}
	
}