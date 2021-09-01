package com.spring.msbootcoinrequest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.msbootcoinrequest.entity.BootCoinRequest;
import com.spring.msbootcoinrequest.repository.BootCoinRequestRepository;
import com.spring.msbootcoinrequest.service.BootCoinRequestService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootCoinRequestServiceImpl implements BootCoinRequestService {

	@Autowired
	BootCoinRequestRepository bootCoinRequestRepository;
	
	@Override
	public Mono<BootCoinRequest> create(BootCoinRequest t) {
		// TODO Auto-generated method stub
		return bootCoinRequestRepository.save(t);
	}

	@Override
	public Flux<BootCoinRequest> findAll() {
		// TODO Auto-generated method stub
		return bootCoinRequestRepository.findAll();
	}

	@Override
	public Mono<BootCoinRequest> findById(String id) {
		// TODO Auto-generated method stub
		return bootCoinRequestRepository.findById(id);
	}

	@Override
	public Mono<BootCoinRequest> update(BootCoinRequest t) {
		// TODO Auto-generated method stub
		return bootCoinRequestRepository.save(t);
	}

	@Override
	public Mono<Boolean> delete(String t) {
        return bootCoinRequestRepository.findById(t)
                .flatMap(
                		bootCoinRequest -> bootCoinRequestRepository.delete(bootCoinRequest)
                                .then(Mono.just(Boolean.TRUE))
                )
                .defaultIfEmpty(Boolean.FALSE);
    }

}
