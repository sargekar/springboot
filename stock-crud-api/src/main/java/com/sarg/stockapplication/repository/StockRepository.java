package com.sarg.stockapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sarg.stockapplication.model.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock,String> {

	public Stock findByStockName(String stockName);

}
