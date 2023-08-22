package com.project.mutualFund;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@JacksonXmlRootElement(namespace="MutualFund")
@ApiModel(description="Details about MutualFund")
@Entity
@Table(name = "mutual_fund")
public class MutualFund {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes="Id of the MutualFund")
	private int mutualFundId;
	@Column(nullable = false)
	private String mutualFundName;
	@Column(name="expense_ratio", nullable = false, length=20, precision = 8, scale=3)
	private float expenseRatio;
	@Column(name="entry_load", nullable = false, length=20, precision = 8, scale=3)
	private float entryLoad;
	@Column(name="exit_load", nullable = false, length=20, precision = 8, scale=3)
	private float exitLoad;
	@Column(name="cash_balance", nullable = false, length=20, precision = 8, scale=3)
	private long cashBalance;
	@Column(name="total_units",  length=20, precision = 8, scale=3)
	private double totalUnits;
	@Column(name="nav",  length=20, precision = 8, scale=3)
	private double nav;
	
	
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "mutualFundId")
	    private List<StockAllocation> stockAllocations;
	 
	 public MutualFund() {
		
	}

	public int getMutualFundId() {
		return mutualFundId;
	}

	public void setMutualFundId(int mutualFundId) {
		this.mutualFundId = mutualFundId;
	}

	public String getMutualFundName() {
		return mutualFundName;
	}

	public void setMutualFundName(String mutualFundName) {
		this.mutualFundName = mutualFundName;
	}

	public float getExpenseRatio() {
		return expenseRatio;
	}

	public void setExpenseRatio(float expenseRatio) {
		this.expenseRatio = expenseRatio;
	}

	public float getEntryLoad() {
		return entryLoad;
	}

	public void setEntryLoad(float entryLoad) {
		this.entryLoad = entryLoad;
	}

	public float getExitLoad() {
		return exitLoad;
	}

	public void setExitLoad(float exitLoad) {
		this.exitLoad = exitLoad;
	}

	public long getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(long cashBalance) {
		this.cashBalance = cashBalance;
	}

	public List<StockAllocation> getStockAllocations() {
		return stockAllocations;
	}

	public void setStockAllocations(List<StockAllocation> stockAllocations) {
		this.stockAllocations = stockAllocations;
	}


	public double getNav() {
		return nav;
	}

	public void setNav(double nav) {
		this.nav = nav;
	}

	
	

	public double getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(double totalUnits) {
		this.totalUnits = totalUnits;
	}

	

@Override
	public String toString() {
		return "MutualFund [mutualFundId=" + mutualFundId + ", mutualFundName=" + mutualFundName + ", expenseRatio="
				+ expenseRatio + ", entryLoad=" + entryLoad + ", exitLoad=" + exitLoad + ", cashBalance=" + cashBalance
				+ ", totalUnits=" + totalUnits + ", nav=" + nav + ", stockAllocations=" + stockAllocations + "]";
	}

public MutualFund(int mutualFundId, String mutualFundName, float expenseRatio, float entryLoad, float exitLoad,
			long cashBalance, double totalUnits, double nav, List<StockAllocation> stockAllocations) {
		super();
		this.mutualFundId = mutualFundId;
		this.mutualFundName = mutualFundName;
		this.expenseRatio = expenseRatio;
		this.entryLoad = entryLoad;
		this.exitLoad = exitLoad;
		this.cashBalance = cashBalance;
		this.totalUnits = totalUnits;
		this.nav = nav;
		this.stockAllocations = stockAllocations;
	}

//	public float calculateNAV(MutualFund fund) {
//		  const totalUnits =
//		    fund.cashBalance / stockPrice[fund.stockMF[0].stockName][0];
//		  const nav =
//		    (fund.cashBalance / totalUnits) *
//		    (1 - fund.entryLoad) *
//		    (1 + fund.exitLoad) *
//		    (1 - fund.expenseRatio);
//		  return nav.toFixed(2); // Rounded to 2 decimal places
//		}
	

	


}
