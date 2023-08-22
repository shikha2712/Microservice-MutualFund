package com.project.stock;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer> {

	List<Stock> findAll();
	
	 @Query("SELECT s.stockId FROM Stock s")
	    List<Integer> findAllIds();

	 @Query(value="Select stock_price from stock where stock_id = ?",nativeQuery=true)
	 float getStockPrice(int stock_id);
}
