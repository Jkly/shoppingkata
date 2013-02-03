package com.itv.shoppingkata;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HardCodedPricingRules implements PricingRules {

	private final Map<Item, Price> readOnlyPrices;

	public HardCodedPricingRules() {
		Map<Item, Price> prices = new HashMap<>();
		prices.put(new Item("A"),
				new MultiBuyPrice(new NormalPrice(50), 3, 130));
		prices.put(new Item("B"), new MultiBuyPrice(new NormalPrice(30), 2, 45));
		prices.put(new Item("C"), new NormalPrice(20));
		prices.put(new Item("D"), new NormalPrice(15));
		readOnlyPrices = Collections.unmodifiableMap(prices);
	}

	@Override
	public Price getPrice(Item item) {
		return readOnlyPrices.get(item);
	}

}
