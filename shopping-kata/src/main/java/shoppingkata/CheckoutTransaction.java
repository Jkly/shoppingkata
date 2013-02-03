package shoppingkata;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CheckoutTransaction {

	private final PricingRulesSource pricingRulesSource;

	private final Map<Item, Integer> items = new HashMap<>();

	public CheckoutTransaction(PricingRulesSource pricingRulesSource) {
		this.pricingRulesSource = pricingRulesSource;
	}

	public void scan(Item item) {
		Integer count = items.get(item);
		if (count == null) {
			count = 0;
		}
		items.put(item, ++count);
	}

	public long getTotalCostInPence() {
		PricingRules pricingRules = pricingRulesSource.getLatestPricingRules();

		long cost = 0;
		for (Entry<Item, Integer> entry : items.entrySet()) {
			Price p = pricingRules.getPrice(entry.getKey());
			if (p == null) {
				throw new IllegalArgumentException("Unknown SKU: "
						+ entry.getKey().getSku());
			}
			cost += p.getCostInPence(entry.getValue());
		}

		return cost;
	}
}
