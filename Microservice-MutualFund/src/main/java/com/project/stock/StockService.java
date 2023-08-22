package com.project.stock;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

	@Autowired
	StockRepository sRepository;
	
	public String addStock(Stock stock)
	{
		sRepository.save(stock);
		return "Successfully Added";
	}
	
	public ArrayList<Stock> getAllStocks()
	{
		System.out.println("Calling all Stocks from StockService JPA");
		ArrayList<Stock> allStocks=new ArrayList<Stock>();	
		sRepository.findAll()
		.forEach(stock -> allStocks.add(stock));	 	 	
		return allStocks;
	}
	
	public String deleteById(int id)
	{
		sRepository.delete(id);
		return "Successfully Deleted";
	}
	
	public List<Stock> showStock()
	{
		List<Stock> allStocks = sRepository.findAll();
		
		return allStocks;
		
		
	}
	
	public List<Integer> getStockIds()
	{
		
		List<Integer> allIds = sRepository.findAllIds();
		
		return allIds;
		
		
	}
}
