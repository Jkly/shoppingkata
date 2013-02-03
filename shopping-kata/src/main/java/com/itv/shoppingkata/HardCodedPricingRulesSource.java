package com.itv.shoppingkata;

public class HardCodedPricingRulesSource implements PricingRulesSource {

	@Override
	public PricingRules getLatestPricingRules() {
		return new HardCodedPricingRules();
	}

}
