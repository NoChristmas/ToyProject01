package kr.spring.log.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import kr.spring.log.entity.LogEntity;

public interface LogRepository extends MongoRepository<LogEntity,String>{

}
