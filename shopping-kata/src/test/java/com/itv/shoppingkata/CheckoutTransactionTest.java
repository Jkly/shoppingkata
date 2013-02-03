package com.itv.shoppingkata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckoutTransactionTest {
	
	@Test
	public void checkoutOutOfOrder() {
		CheckoutTransaction transaction = new CheckoutTransaction(
				new HardCodedPricingRulesSource());
		transaction.scan(new Item("B"));
		transaction.scan(new Item("A"));
		transaction.scan(new Item("B"));
		assertEquals(95, transaction.getTotalCostInPence());
	}
}
