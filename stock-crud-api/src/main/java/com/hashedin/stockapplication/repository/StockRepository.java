package com.hashedin.stockapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hashedin.stockapplication.model.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock,String> {

	public Stock findByStockName(String stockName);

}
