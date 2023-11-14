package com.java.jsf;

public class Wallet {
		
	
	private int walletId;
	private int custId;
	private double walletAmount;
	private WalletSource walletsource;
	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public double getWalletAmount() {
		return walletAmount;
	}
	public void setWalletAmount(double walletAmount) {
		this.walletAmount = walletAmount;
	}
	public WalletSource getWalletsource() {
		return walletsource;
	}
	public void setWalletsource(WalletSource walletsource) {
		this.walletsource = walletsource;
	}
	
	
	
}
