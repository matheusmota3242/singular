package com.m2g2.singular.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = { @JoinColumn(name = "transaction_id") },
	           inverseJoinColumns = { @JoinColumn(name = "tag_id") }
	)
	private List<Tag> tags = new ArrayList<>();
	
	private String destinatary;
	
	@NotNull(message = "The value must be informed.")
	private BigDecimal value;

	@ManyToOne
	@JoinColumn(name = "asset_id", nullable = false)
	@NotNull(message = "A 'transaction' object must be associated to an 'asset'.")
	private Asset asset;
}
