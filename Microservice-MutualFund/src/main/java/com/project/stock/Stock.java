package com.project.stock;

import java.util.List;


import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement
@Entity
@Table(name ="stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockId;
	private String stockName;
	private float stockPrice;
	
	 @ElementCollection
	 @CollectionTable(name = "prev_price_details", joinColumns = @JoinColumn(name = "entity_id"))
	 @Column(name = "price_detail")
	private List<String> prevPriceDetails;


	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(int stockId, String stockName, float stockPrice, List<String> prevPriceDetails) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.prevPriceDetails = prevPriceDetails;
	}

	public Stock(String stockName, float stockPrice, List<String> prevPriceDetails) {
		super();
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.prevPriceDetails = prevPriceDetails;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public float getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}

	public List<String> getPrevPriceDetails() {
		return prevPriceDetails;
	}

	public void setPrevPriceDetails(List<String> prevPriceDetails) {
		this.prevPriceDetails = prevPriceDetails;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", stockPrice=" + stockPrice
				+ ", prevPriceDetails=" + prevPriceDetails + "]";
	}

	
	
	
	
}
