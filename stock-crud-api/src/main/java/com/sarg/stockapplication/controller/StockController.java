package com.sarg.stockapplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sarg.stockapplication.model.DoubleWrapperClass;
import com.sarg.stockapplication.model.Stock;
import com.sarg.stockapplication.service.StockServiceImp;

@RestController
public class StockController {
	
	@Autowired
	private StockServiceImp stockService;
	
	@RequestMapping("/stocks")
	public List<Stock> getAllStocks() {
		return stockService.getAllStocks();
	}
	
	@RequestMapping("/stocks/{stockName}")
	public Stock getStockByStockName(@PathVariable String stockName) {
		return stockService.getStockByStockName(stockName);
	}

	@PostMapping("/stocks/add")
	public void createStock(@RequestBody Stock stock) {
		stockService.createStock(stock);
	}
	
	@PutMapping("/stocks/{stockName}")
	public void updateStockDetails(@PathVariable String stockName, @RequestBody Stock stock) {
		stockService.updateStockDetails(stockName, stock);
	}
	
	@PutMapping("/stocks/price/{stockName}")
	public void updateStockPrice(@PathVariable String stockName,@RequestBody DoubleWrapperClass stockPrice) {
		stockService.updateStockPrice(stockName,stockPrice.getValue());
	}

	@DeleteMapping("/stocks/{stockName}")
	public void deleteStock(@PathVariable String stockName) {
		stockService.deleteStock(stockName);
	}
}
