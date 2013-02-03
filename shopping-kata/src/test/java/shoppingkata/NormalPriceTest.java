package shoppingkata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import shoppingkata.NormalPrice;
import shoppingkata.Price;

public class NormalPriceTest {
	@Test
	public void normalPrice() {
		NormalPrice price = new NormalPrice(20);
		assertEquals(100, price.getCostInPence(5));
	}

	@Test
	public void freeItem() {
		NormalPrice price = new NormalPrice(0);
		assertEquals(0, price.getCostInPence(5));
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidPrice() {
		new NormalPrice(-10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidQuantity() {
		Price price = new NormalPrice(10);
		price.getCostInPence(-1);
	}

}
