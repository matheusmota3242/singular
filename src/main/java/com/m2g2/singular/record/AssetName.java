package com.m2g2.singular.record;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AssetName(@NotNull Integer id, @NotEmpty String name) {

	public String toString() {
		return String.format("AssetName(id = %d, name = %s)", id, name);
	}
}
