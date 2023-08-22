package com.project.mutualFund;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.project.stock.Stock;


@JacksonXmlRootElement
@Entity
@Table(name = "stock_allocation")
public class StockAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockAllocationId;

//    @ManyToOne
//    @JoinColumn(name = "mutual_fund_id")
//    private MutualFund mutualFund;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @Column(nullable = false)
    private double weight;

    public StockAllocation() {
		// TODO Auto-generated constructor stub
	}

	public int getStockAllocationId() {
		return stockAllocationId;
	}

	public void setStockAllocationId(int stockAllocationId) {
		this.stockAllocationId = stockAllocationId;
	}

//	public MutualFund getMutualFund() {
//		return mutualFund;
//	}
//
//	public void setMutualFund(MutualFund mutualFund) {
//		this.mutualFund = mutualFund;
//	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public StockAllocation(int stockAllocationId, MutualFund mutualFund, Stock stock, double weight) {
		super();
		this.stockAllocationId = stockAllocationId;
		//this.mutualFund = mutualFund;
		this.stock = stock;
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((mutualFund == null) ? 0 : mutualFund.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + stockAllocationId;
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockAllocation other = (StockAllocation) obj;
//		if (mutualFund == null) {
//			if (other.mutualFund != null)
//				return false;
//		} else if (!mutualFund.equals(other.mutualFund))
//			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (stockAllocationId != other.stockAllocationId)
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StockAllocation [stockAllocationId=" + stockAllocationId + ", stock=" + stock + ", weight=" + weight
				+ "]";
	}
    
    
}
