package com.example.saleshippingstatus;

public class Shipping {
	private int saleId;
	private boolean status;
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		String shippingResult = "";
		if(status) {
			shippingResult = "Urun aliciya teslim edildi";
		}else {
			shippingResult = "Urun kargoda, teslim edilmedi";
		}
		return "{" + "'status':'" + shippingResult + "',";
	}
}
