package com.project.stock;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StockController {
  
	@Autowired
	StockService ss;
	
	@RequestMapping(value="/stock",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ArrayList<Stock> getAllStocks()
	{
		System.out.println("Stocks Controller");
		return ss.getAllStocks();
	}
	
	@RequestMapping(value="/stock",method=RequestMethod.POST)
	public String addStock(@RequestBody Stock newStock	)
	{
		return ss.addStock(newStock);
	}
	
	@RequestMapping(value="/stock/{id}",method=RequestMethod.DELETE)
	public String removeCustomer(@PathVariable("id") int cid) {
		System.out.println( "The stock id given is "+ cid);
		return ss.deleteById(cid);
	}
	
	@RequestMapping(value="/stocks",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<Stock> getStocks()
	{
		System.out.println("Stocks Controller");
		return ss.showStock();
	}
	
	@RequestMapping(value="/stock/stockIds",method=RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<Integer> getStockIds()
	{
		return ss.getStockIds();
	}
	
	@RequestMapping(value = "/stock/{stockId}",method = RequestMethod.GET)
	public Stock getAStock(@PathVariable("stockId") int stockId)
	{
		for (Stock s:getAllStocks())
		{
			if (s.getStockId()==stockId)
			{
				return s;
			}
		}
		return null;
	}
	
	
}