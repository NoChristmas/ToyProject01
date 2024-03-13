package kr.spring.log.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import kr.spring.log.entity.MemberLogEntity;

public interface MemberLogRepository extends MongoRepository<MemberLogEntity,String>{

}
