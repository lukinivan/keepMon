package com.globallogic.softwaredesign.wallet;

import java.time.LocalDateTime;

public class TextReceipt implements Receipt {
	
	private final LocalDateTime dateTime;
	private final double balance;

	public TextReceipt(double amount) {
		this.dateTime = LocalDateTime.now();
		this.balance = amount;
	}

	public byte[] getBytes() {
		return String.format("Issued date: %s, Balance: %s", this.dateTime, this.balance).getBytes();
	}

	public void print() {
		throw new NotSupportedException();
	}

	public byte[] render() {
		throw new NotSupportedException();
	}

}
