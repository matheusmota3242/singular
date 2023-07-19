package com.m2g2.singular.model.service;

import org.springframework.stereotype.Service;

import com.m2g2.singular.model.Asset;
import com.m2g2.singular.model.repository.AssetRepository;

@Service
public class AssetService extends AbstractService<Asset> {
	
	public AssetService(AssetRepository repository) {
		super(repository);
	}

}
