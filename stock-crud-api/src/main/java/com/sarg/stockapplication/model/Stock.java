package com.sarg.stockapplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;
@Entity
public class Stock {
	
	@Id 
	private String stockName;
	private Double stockPrice;
	private Date stockCreationDate;
	private Date stockModificationDate;
	private String stockDescription;
	private String stockSymbol;
	
	public Stock() {
	}
	
	public Stock(String stockName, Double stockPrice, String stockDescription,String stockSymbol) {
		super();
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.stockSymbol=stockSymbol;
		this.stockDescription = stockDescription;
		stockCreationDate = new Date();
		stockModificationDate = stockCreationDate;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Date getStockCreationDate() {
		return stockCreationDate;
	}

	public void setStockCreationDate(Date stockCreationDate) {
		this.stockCreationDate = stockCreationDate;
	}

	public Date getStockModificationDate() {
		return stockModificationDate;
	}

	public void setStockModificationDate(Date stockModificationDate) {
		this.stockModificationDate = stockModificationDate;
	}

	public String getStockDescription() {
		return stockDescription;
	}

	public void setStockDescription(String stockDescription) {
		this.stockDescription = stockDescription;
	}
	
	
}
