package com.spring.msbootcoinrequest.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.spring.msbootcoinrequest.entity.BootCoinRequest;
import com.spring.msbootcoinrequest.service.BootCoinRequestService;

import reactor.core.publisher.Mono;

@Component
public class BootCoinRequestHandler {
	@Autowired
	BootCoinRequestService BootCoinRequestService;
	
	public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
        		.contentType(MediaType.APPLICATION_JSON)
        		.body(BootCoinRequestService.findAll(), BootCoinRequest.class);
    }
	
	public Mono<ServerResponse> findById(ServerRequest request) {
		String id = request.pathVariable("id");
		
        return ServerResponse.ok()
        		.contentType(MediaType.APPLICATION_JSON)
        		.body(BootCoinRequestService.findById(id), BootCoinRequest.class);
    }
	
	public Mono<ServerResponse> create(ServerRequest request) {
		Mono<BootCoinRequest> monoBootCoint = request.bodyToMono(BootCoinRequest.class);
		
		return monoBootCoint.flatMap(bootcoint -> BootCoinRequestService.create(bootcoint)
													.flatMap(bootcoinCreate -> ServerResponse
					        													.status(HttpStatus.CREATED)
					        													.contentType(MediaType.APPLICATION_JSON)
					        													.body(fromValue(bootcoinCreate))));
	}
	
	public Mono<ServerResponse> delete(ServerRequest request) {
		String id = request.pathVariable("id");
		System.out.println("Esta llegando al DELETE");
        return BootCoinRequestService.delete(id)
        		.flatMap(bootCoinRequest -> ServerResponse.status(HttpStatus.OK)
								.bodyValue("BootCoin Eliminado"));
    }
}
