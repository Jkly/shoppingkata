package com.itv.shoppingkata;

public class NormalPrice implements Price {

	private final long price;

	public NormalPrice(long price) {
		if (price < 0) {
			throw new IllegalArgumentException(
					"Price must be 0 or more pence. Was: " + price);
		}
		this.price = price;
	}

	@Override
	public long getCostInPence(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException(
					"Quantity must be 0 or more. Was: " + quantity);
		}
		return quantity * price;
	}

}
