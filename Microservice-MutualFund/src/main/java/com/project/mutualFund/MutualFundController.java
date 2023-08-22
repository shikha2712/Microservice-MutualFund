package com.project.mutualFund;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stock.Stock;

@RestController
@RequestMapping("/mutualfunds")
public class MutualFundController {
    @Autowired
    private MutualFundService ms;
    

    @GetMapping(produces = "application/json")
    public List<MutualFund> getAllMutualFunds() {
    	
        
        return (List<MutualFund>) ms.getAllMutualFunds();
        
    }
    
    
    @GetMapping("/{id}")
    public MutualFund getMutualFundById(@PathVariable int id) {
        // Retrieve MutualFund entity from the database or any other data source
        return ms.getMutualFundById(id);
    }
    
//    @GetMapping(produces = "application/json")
//    public void calculateNavForMutualFund(@PathVariable int id) {
//        
//    }
  
    
    
    @PostMapping
    public String createMutualFund(@RequestBody MutualFund mutualFund) {
    	
       return ms.createMutualFund(mutualFund);
   }
    
    @DeleteMapping("/{id}")
    public String deleteFund(@PathVariable("id") int cid)
    {
    	return ms.deleteFundById(cid);
    }
  
    @PostMapping("/addfund")
	public String addFund(@RequestBody MutualFund mutualfund,@RequestBody ArrayList<Stock> stocks) {
		System.out.println("addFund function called..");
		if(ms.addFund(mutualfund,stocks) == null) {
		return "invalid user";
		}
		else {	
		return ms.addFund(mutualfund, stocks);
		}
	}
    
    
}




