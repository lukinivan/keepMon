package com.globallogic.softwaredesign.wallet;

/**
 * Digital wallet that holds user's money
 * and provide interface for the manipulations
 */
public class DigitalWallet {
	private final SmSReferalServer referalServer = new SmSReferalServer();
	private final long walletNumber;
	
	private double amount;
	
	public DigitalWallet(long walletNumber) {
		this.walletNumber = walletNumber;
	}

	/**
	 * Add money to the wallet
	 * @param amount - amount of money to add
	 * @return balance after the operation
	 */
	public double add(long amount) {
		this.amount += amount;
		return this.amount;
	}
	
	/**
	 * Subtract money from the wallet
	 * @param amount - amount of money to subtract
	 * @return balance after the operation
	 */
	public double subtract(long amount) {
		this.amount -= amount;
		return this.amount;
	}
	
	/**
	 * Return current balance of the wallet
	 * @return balance - money in the wallet
	 */
	public double balance() {
		return this.amount;
	}
	
	/**
	 * Perform purchase of the Product
	 * @param product - product to pay for
	 * @return balance after the operation
	 */
	public double pay(Product product) {
		this.amount -= product.price;
		return this.amount;
	}

	/**
	 * Helps to create viewable/printable document
	 * @return document in PDF format
	 */
	public TextReceipt createBalanceReceipt() {
		return new TextReceipt(this.amount);
	}
	
	/**
	 * Invite friend to join by referral link
	 * @param phoneNumber - phone number for referral link generation
	 */
	public void inviteFriend(long phoneNumber) {
		referalServer.inviteBySMS(this.walletNumber, phoneNumber);
	}
	
	/**
	 * Helps to create transfer operations
	 * @param amount - of money to transfer
	 * @param destinationWallet - destination where to transfer money
	 */
	public void transfer(long amount, DigitalWallet destinationWallet) {
		this.amount -= amount;
		destinationWallet.add(amount);
	}
}
