package com.spring.msbootcoinrequest.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.spring.msbootcoinrequest.entity.BootCoinRequest;

public interface BootCoinRequestRepository extends ReactiveMongoRepository<BootCoinRequest, String> {
	
}
