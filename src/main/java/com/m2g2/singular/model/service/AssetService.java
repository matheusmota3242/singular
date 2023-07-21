package com.m2g2.singular.model.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.m2g2.singular.model.Asset;
import com.m2g2.singular.model.repository.AssetRepository;
import com.m2g2.singular.record.AssetName;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssetService {
	
	private final AssetRepository repository;
	
	public void create(Asset asset) {
		repository.save(asset);
	}
	
	public List<Asset> getAllByUser(Integer id) {
		return repository.findAllByUserId(id);
	}
	
	public void updateName(AssetName assetName) {
		Asset asset = repository.findById(assetName.id()).orElseThrow();
		asset.setName(assetName.name());
		repository.save(asset);
	}
	
	public void aggregateTransactionValue(Integer assetId, BigDecimal value) {
		// TODO refatorar lógica de excecao
		Asset asset = repository.findById(assetId).orElseThrow(() -> new NoSuchElementException("Asset não encontrado."));
		asset.setTotalAmount(asset.getTotalAmount().add(value));
		repository.save(asset);
	}

}
