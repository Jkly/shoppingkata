package shoppingkata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import shoppingkata.HardCodedPricingRules;
import shoppingkata.Item;
import shoppingkata.Price;

public class HardCodedPricingRulesTest {

	private HardCodedPricingRules pricingRules;
	
	@Before
	public void setUpClassUnderTest() {
		pricingRules = new HardCodedPricingRules();
	}
	
	@Test
	public void testPricingRules() {
		Price priceOfA = pricingRules.getPrice(new Item("A"));
		assertEquals(180, priceOfA.getCostInPence(4));

		Price priceOfB = pricingRules.getPrice(new Item("B"));
		assertEquals(75, priceOfB.getCostInPence(3));

		Price priceOfC = pricingRules.getPrice(new Item("C"));
		assertEquals(40, priceOfC.getCostInPence(2));

		Price priceOfD = pricingRules.getPrice(new Item("D"));
		assertEquals(150, priceOfD.getCostInPence(10));
	}

	@Test
	public void notExactMatchingItemReturnsNull() {
		HardCodedPricingRules pricingRules = new HardCodedPricingRules();
		Price p = pricingRules.getPrice(new Item("a"));
		assertNull(p);
	}

	@Test
	public void unknownItemReturnsNull2() {
		HardCodedPricingRules pricingRules = new HardCodedPricingRules();
		Price p = pricingRules.getPrice(new Item("c"));
		assertNull(p);
	}
}
