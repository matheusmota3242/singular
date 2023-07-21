package com.m2g2.singular.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2g2.singular.model.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer>{

	public List<Asset> findAllByUserId(Integer id);
}
