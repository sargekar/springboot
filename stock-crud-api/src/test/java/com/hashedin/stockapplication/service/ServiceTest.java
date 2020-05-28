package com.hashedin.stockapplication.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hashedin.stockapplication.controller.StockController;
import com.hashedin.stockapplication.model.DoubleWrapperClass;
import com.hashedin.stockapplication.model.Stock;
import com.hashedin.stockapplication.repository.StockRepository;
import com.hashedin.stockapplication.service.StockServiceImp;

public class ServiceTest {
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@InjectMocks
	private StockServiceImp stockService;
	
	@Mock
	private StockRepository stockRepository;
     
    @Test
    public void getAllStocksTest()
    {
    	Iterable<Stock> iterableStocks = Arrays.asList();
    	when(stockRepository.findAll()).thenReturn(iterableStocks);
    	
        List<Stock> stockList = stockService.getAllStocks();
        verify(stockRepository, times(1)).findAll();
        assertEquals(stockList.size(), 0);
    }


    
    @Test
    public void getStockByStockNameTest()
    {
    	when(stockRepository.findByStockName("stock1")).thenReturn(new Stock("stock1", 1.0, "stock1", "stock1"));
    	when(stockRepository.findByStockName("stock2")).thenReturn(new Stock("stock2", 2.0, "stock2", "stock2"));
    	when(stockRepository.findByStockName("stock3")).thenReturn(new Stock("stock3", 3.0, "stock3", "stock3"));
    	
        Stock resultStock = stockService.getStockByStockName("stock2");
        verify(stockRepository, times(1)).findByStockName("stock2");
        assert(resultStock.getStockPrice() == 2.0);
    }
    
    /*

    @Test
    public void createStockTest()
    {
    	Stock stockObject = new Stock();
    	doNothing().when(stockService).createStock(stockObject);
    	
        stockController.createStock(stockObject);
        verify(stockService, times(1)).createStock(stockObject);
    }
    
    @Test
    public void updateStockDetailsTest()
    {
    	String stockName = "stockName";
    	Stock stockObject = new Stock();
    	doNothing().when(stockService).updateStockDetails(stockName, stockObject);
    	
        stockController.updateStockDetails(stockName, stockObject);
        verify(stockService, times(1)).updateStockDetails(stockName, stockObject);
    }
    
    @Test
    public void updateStockPriceTest()
    {
    	String stockName = "stockName";
    	DoubleWrapperClass updatedStockPrice = new DoubleWrapperClass();
    	double updatedStockValue = 10.2;
    	updatedStockPrice.setValue(updatedStockValue);
    	doNothing().when(stockService).updateStockPrice(stockName, updatedStockValue);
    	
        stockController.updateStockPrice(stockName, updatedStockPrice);
        verify(stockService, times(1)).updateStockPrice(stockName, updatedStockValue);
    }
    
    @Test
    public void deleteStockTest()
    {
    	String stockName = "stockName";
    	doNothing().when(stockService).deleteStock(stockName);
    	
        stockController.deleteStock(stockName);
        verify(stockService, times(1)).deleteStock(stockName);
    }
    
    */
}

