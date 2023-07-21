package com.m2g2.singular.model.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.m2g2.singular.model.Asset;
import com.m2g2.singular.model.service.AssetService;
import com.m2g2.singular.record.AssetName;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("assets")
@RequiredArgsConstructor
@Slf4j
public class AssetController {

	private final AssetService service;
	
	@PostMapping
	public void create(@RequestBody @Valid Asset asset) {
		log.info("Entrada do enpoint 'create'. Entrada: {}", asset);
		try {
			service.create(asset);
		} catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					String.format("O 'id' de usuário %d não corresponde a nenhum existente.", asset.getUser().getId()));
		}
		log.info("Saida do endpoint 'create'. Objeto: {}", asset);
	}
	
	@GetMapping("user/{userId}")
	public List<Asset> getAllByUserId(@PathVariable Integer userId) {
		return service.getAllByUser(userId);
	}
	
	@PatchMapping
	public void updateName(@RequestBody @Valid AssetName assetName) {
		log.info("Entrada do endpoint 'updateName'. Objeto: {}", assetName);
		service.updateName(assetName);
		log.info("Saida do endpoint 'updateName'. Id = {}", assetName.id());
	}
	
}
