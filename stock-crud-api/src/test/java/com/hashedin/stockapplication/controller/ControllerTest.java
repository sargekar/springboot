package com.hashedin.stockapplication.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hashedin.stockapplication.model.DoubleWrapperClass;
import com.hashedin.stockapplication.model.Stock;
import com.hashedin.stockapplication.service.StockServiceImp;

public class ControllerTest {
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@InjectMocks
	private StockController stockController;
	
	@Mock
	private StockServiceImp stockService;
     
    @Test
    public void getAllStocksTest()
    {
    	ArrayList<Stock> mockList = new ArrayList<Stock>();
    	mockList.add(new Stock());
    	when(stockService.getAllStocks()).thenReturn(mockList);
    	
        List<Stock> stockList = stockController.getAllStocks();
        verify(stockService, times(1)).getAllStocks();
        assertEquals(stockList.size(), 1);
    }
    
    @Test
    public void getStockByStockNameTest()
    {
    	when(stockService.getStockByStockName("stock1")).thenReturn(new Stock("stock1", 1.0, "stock1", "stock1"));
    	when(stockService.getStockByStockName("stock2")).thenReturn(new Stock("stock2", 2.0, "stock2", "stock2"));
    	when(stockService.getStockByStockName("stock3")).thenReturn(new Stock("stock3", 3.0, "stock3", "stock3"));
    	
        Stock resultStock = stockController.getStockByStockName("stock2");
        verify(stockService, times(1)).getStockByStockName("stock2");
        assert(resultStock.getStockPrice() == 2.0);
    }
    
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
}
