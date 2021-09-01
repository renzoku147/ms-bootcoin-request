package com.spring.msbootcoinrequest.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Document("BootCointRequest")
@AllArgsConstructor
@NoArgsConstructor
public class BootCoinRequest {
	@Id
	private String id;
	
	@NotNull
	private BootCoin bootCoin;
	
	@NotNull
	private Double amount;
	
	@NotNull
	private TypePaid typePaid;
	
	private String accountNumber;
	
	@NotNull
	private Double exchangeRate;
	
	@NotNull
	private BootCoinState bootCoinState;
}
