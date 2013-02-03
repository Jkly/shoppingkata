package com.itv.shoppingkata;


public class MultiBuyPrice implements Price {

	private final int multiBuyQuantity;
	private final long multiBuyPrice;
	private final Price normalPrice;

	public MultiBuyPrice(Price normalPrice, int multiBuyQuantity,
			long multiBuyPrice) {
		if (multiBuyQuantity < 0) {
			throw new IllegalArgumentException(
					"Multi-buy quantity must be 0 or greater. Was: "
							+ multiBuyQuantity);
		}
		if (multiBuyPrice < 0) {
			throw new IllegalArgumentException(
					"Multi-buy price must be 0 or greater. Was: "
							+ multiBuyPrice);
		}
		this.normalPrice = normalPrice;
		this.multiBuyQuantity = multiBuyQuantity;
		this.multiBuyPrice = multiBuyPrice;
	}

	@Override
	public long getCostInPence(int quantity) {
		int multiBuys = quantity / multiBuyQuantity;
		int normalPricedQuantity = quantity % multiBuyQuantity;

		long costOfNormal = normalPrice.getCostInPence(normalPricedQuantity);
		long costOfMultiBuy = multiBuyPrice * multiBuys;

		return costOfNormal + costOfMultiBuy;
	}
}
