package com.sarg.stockapplication.service;

import java.util.List;

import com.sarg.stockapplication.model.Stock;

public interface StockService  {
	public List<Stock> getAllStocks();
	public Stock getStockByStockName(String stockName);
	public void createStock(Stock stock);
	public void updateStockDetails(String stockName, Stock stock);
	public void deleteStock(String stockName);
}
