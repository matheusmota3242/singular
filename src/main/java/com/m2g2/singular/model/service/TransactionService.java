package com.m2g2.singular.model.service;

import org.springframework.stereotype.Service;

import com.m2g2.singular.model.Transaction;
import com.m2g2.singular.model.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {

	private final TransactionRepository repository;
	
	private final AssetService assetService;
	
	public void create(Transaction transaction) {
		assetService.aggregateTransactionValue(transaction.getId(), transaction.getValue());
		repository.save(transaction);
	}
}
