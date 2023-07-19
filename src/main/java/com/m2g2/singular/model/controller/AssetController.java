package com.m2g2.singular.model.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.m2g2.singular.model.Asset;
import com.m2g2.singular.model.service.AssetService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("asset")
@RequiredArgsConstructor
@Slf4j
public class AssetController {

	private final AssetService service;
	
	@PostMapping
	public Asset create(@RequestBody @Valid Asset asset) {
		log.info("Entrada do enpoint 'create' {}", asset);
		try {
			asset = service.create(asset);
		} catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("O 'id' de usuário %d não corresponde a nenhum existente.", asset.getUser().getId()));
		}
		log.info("Saida do endpoint 'create' {}", asset);
		return asset;
	}

	@GetMapping("{id}")
	public Asset getById(@PathVariable Integer id) {
		log.info("Entrada do endpoint 'getById' com 'id' = {}", id);
		try {
			Asset asset = service.getById(id);
			log.info("Saida do endpoint 'getById'. Retorno: {}", asset);
			return asset;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("Não há registro que corresponda ao 'id' = %d.", id));
		}
	}
	
	@GetMapping
	public List<Asset> getAll() {
		log.info("Entrada do endpoint 'getAll'.");
		List<Asset> assets = service.getAll();
		log.info("Saída do endpoint 'getAll'. Retorno: {}", assets);
		return assets;
	}
	
}
