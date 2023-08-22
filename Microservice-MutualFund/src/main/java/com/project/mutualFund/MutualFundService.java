package com.project.mutualFund;
//import java.util.ArrayList;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.stock.Stock;
import com.project.stock.StockRepository;



@Service
public class MutualFundService {

	@Autowired
	MutualFundRepository mRepository;
	
	@Autowired
	StockRepository stockRepository;

	public Iterable<MutualFund> getAllMutualFunds() {
		return mRepository.findAll();

	}

	public String createMutualFund(MutualFund mutualFund) {
		double calculatedNav = calculateNav(mutualFund);
		System.out.println(calculatedNav);
		mutualFund.setNav(calculatedNav);
		mRepository.save(mutualFund);
		return "successfully added";
	}

	public String addFund(MutualFund mutualfund1, ArrayList<Stock> stocks) {
		mRepository.save(mutualfund1);
		return "added";
	}

	public MutualFund getMutualFundById(int id) {
		return mRepository.findOne(id);
	}

	public String deleteFundById(int id) {
		mRepository.delete(id);
		return "successfully deleted";
	}

	public double calculateNav(MutualFund fund) {
		long totalExpenses = (long) ((fund.getExpenseRatio() * fund.getCashBalance())
				+ (fund.getEntryLoad() * fund.getCashBalance()));
		long investment = fund.getCashBalance() - totalExpenses;

		double totalUnits = 0.0;
		

		for (StockAllocation allocation : fund.getStockAllocations()) {
			
			int stockId = allocation.getStock().getStockId();
			float stockPrice = stockRepository.getStockPrice(stockId);
			System.out.println("===============");
			System.out.println(stockPrice);
			double stockWeight = allocation.getWeight(); // Get the weight of the stock from the allocation
			double weightedInvestment = (stockWeight * investment) / 100;

    		double unitsForStock = weightedInvestment / stockPrice;
			totalUnits += unitsForStock;
			
			

		}

		double nav = investment / totalUnits;


		DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedNav = decimalFormat.format(nav);
        fund.setTotalUnits(Double.parseDouble(decimalFormat.format(totalUnits)));

        return Double.parseDouble(formattedNav);
        

	}

}
