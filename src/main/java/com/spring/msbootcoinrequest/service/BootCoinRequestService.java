package com.spring.msbootcoinrequest.service;

import com.spring.msbootcoinrequest.entity.BootCoinRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootCoinRequestService {
	Mono<BootCoinRequest> create(BootCoinRequest t);

    Flux<BootCoinRequest> findAll();

    Mono<BootCoinRequest> findById(String id);
    
    Mono<BootCoinRequest> update(BootCoinRequest t);
    
    Mono<Boolean> delete(String t);
}
