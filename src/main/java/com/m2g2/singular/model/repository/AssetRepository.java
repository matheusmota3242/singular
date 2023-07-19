package com.m2g2.singular.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2g2.singular.model.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer>{

}
