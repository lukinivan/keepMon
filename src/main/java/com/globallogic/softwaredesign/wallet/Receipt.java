package com.globallogic.softwaredesign.wallet;

public interface Receipt {
	
	/**
	 * Byte representation of the receipt
	 * @return byte[] - array of bytes that represents receipt 
	 */
	byte[] getBytes();
	
	/**
	 * Print receipt on the real printer
	 */
	void print();
	
	/**
	 * Render an image from the data
	 * @return byte[] - array of bytes that represent the image
	 */
	byte[] render();
}
