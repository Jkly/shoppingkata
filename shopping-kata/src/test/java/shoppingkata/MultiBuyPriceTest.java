package shoppingkata;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import shoppingkata.MultiBuyPrice;
import shoppingkata.NormalPrice;
import shoppingkata.Price;

public class MultiBuyPriceTest {

	private MultiBuyPrice itemPriceA;
	private MultiBuyPrice itemPriceB;

	@Before
	public void setUpPrices() {
		itemPriceA = new MultiBuyPrice(new NormalPrice(50), 3, 130);
		itemPriceB = new MultiBuyPrice(new NormalPrice(30), 2, 45);
	}

	@Test
	public void normalPrice() {
		assertEquals(100, itemPriceA.getCostInPence(2));
	}

	@Test
	public void multiBuyPrice() {
		assertEquals(130, itemPriceA.getCostInPence(3));
	}

	@Test
	public void multipleMultiBuyPrice() {
		assertEquals(390, itemPriceA.getCostInPence(9));
	}

	@Test
	public void multiBuyPriceAndNormalPrice() {
		assertEquals(230, itemPriceA.getCostInPence(5));
	}

	@Test
	public void multiBuyPriceWithOneItem() {
		Price price = new MultiBuyPrice(new NormalPrice(2), 1, 1);
		assertEquals(5, price.getCostInPence(5));
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidMultiBuyPrice() {
		new MultiBuyPrice(new NormalPrice(1), 1, -10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidMultiBuyQuantity() {
		new MultiBuyPrice(new NormalPrice(1), -1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidQuantity() {
		itemPriceB.getCostInPence(-1);
	}

}
