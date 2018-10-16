package com.annotationDemo.service;

public class TransferService {
   public void transfer(String accountA, String accountB, Long amount){
	   System.out.println(amount+ "amount has been transfer from "+accountA +" to "+ accountB );
   }
   
   public Double checkBalance(String account){
	   System.out.println("Available balance is 5000");
	   return new Double(50000);
   }
   
   public Long withdrow(String account, Long amount){
	   System.out.println("withdrow amount is "+amount);
	   return amount;
   }
   
   public void deposit(String account, Long amount){
	   System.out.println(amount+ " Amount has been deposited to "+account);
   }
}
