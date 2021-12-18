package com.globallogic.softwaredesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globallogic.softwaredesign.wallet.DigitalWallet;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		var wallet = new DigitalWallet(12_12_34_12);
		var vacationWallet = new DigitalWallet(12_13_34_54);
		
		wallet.add(100);
		
		var balance = wallet.balance();
		log.info("Current balance: {}", balance);
		
		balance = wallet.subtract(30);
		log.info("Current balance: {}", balance);
		
		wallet.transfer(30, vacationWallet);
		log.info("Current balance: {}, Vacation balance: {}", wallet.balance(), vacationWallet.balance());
		
		wallet.inviteFriend(5869371);
		
		var receipt = wallet.createBalanceReceipt();
		receipt.print();
	}
}
