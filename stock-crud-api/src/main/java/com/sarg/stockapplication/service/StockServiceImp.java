package com.sarg.stockapplication.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarg.stockapplication.model.DoubleWrapperClass;
import com.sarg.stockapplication.model.Stock;
import com.sarg.stockapplication.repository.StockRepository;

@Service
public class StockServiceImp implements StockService{
	
	@Autowired
	private StockRepository stockRepository;
	
	public List<Stock> getAllStocks(){
		return (List<Stock>)stockRepository.findAll();
	}
	
	public Stock getStockByStockName(String stockName) {
		return stockRepository.findByStockName(stockName);
	}
	
	public void createStock(Stock stock){
		stock.setStockCreationDate(new Date());
		stock.setStockModificationDate(stock.getStockCreationDate());
		stockRepository.save(stock);
	}
	
	public void updateStockDetails(String stockName, Stock stock) {
		stock.setStockModificationDate(new Date());
		stockRepository.save(stock);
	}
	
	public void updateStockPrice(String stockName,Double stockPrice) {
		Stock stock= stockRepository.findByStockName(stockName);
		stock.setStockPrice(stockPrice);
		stock.setStockModificationDate(new Date());
		stockRepository.save(stock);
	}
	
	public void deleteStock(String stockName) {
		stockRepository.delete(stockName);
	}
	
}
