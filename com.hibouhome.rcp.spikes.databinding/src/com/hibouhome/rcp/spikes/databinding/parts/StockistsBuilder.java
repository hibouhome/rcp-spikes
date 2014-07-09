package com.hibouhome.rcp.spikes.databinding.parts;

import com.hibouhome.rcp.spikes.emf.stockists.Country;
import com.hibouhome.rcp.spikes.emf.stockists.Region;
import com.hibouhome.rcp.spikes.emf.stockists.Stockist;
import com.hibouhome.rcp.spikes.emf.stockists.Stockists;
import com.hibouhome.rcp.spikes.emf.stockists.StockistsFactory;

public class StockistsBuilder {

	private static final int N_COUNTRIES = 10;
	private static final int N_REGIONS = 6;
	private static final int N_STOCKISTS = 4;

	public static Stockists build() {
		final Stockists stockists = StockistsFactory.eINSTANCE.createStockists();
		for (int i = 0; i < N_COUNTRIES; i++) {
			createCountry(stockists, "Country-" + i);
		}
		return stockists;
	}

	private static void createCountry(final Stockists stockists, final String name) {
		final Country country = StockistsFactory.eINSTANCE.createCountry();
		country.setName(name);
		for (int i = 0; i < N_REGIONS; i++) {
			createRegion(country, name + "_Region-" + i);
		}
		stockists.getCountries().add(country);
	}

	private static void createRegion(final Country country, final String name) {
		final Region region = StockistsFactory.eINSTANCE.createRegion();
		region.setName(name);
		for (int i = 0; i < N_STOCKISTS; i++) {
			createStockists(region, name + "_Stockists-" + i);
		}
		country.getRegions().add(region);
	}

	private static void createStockists(final Region region, final String name) {
		final Stockist stockist = StockistsFactory.eINSTANCE.createStockist();
		stockist.setName(name);
		region.getStockists().add(stockist);
	}
}
