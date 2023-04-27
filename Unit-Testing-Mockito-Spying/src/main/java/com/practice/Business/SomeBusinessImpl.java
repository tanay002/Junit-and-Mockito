package com.practice.Business;

import java.util.Arrays;
import java.util.OptionalInt;

import com.practice.data.SomeDataService;

public class SomeBusinessImpl {

	SomeDataService someDataService;
	
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}


	public int calculateSum(int [] data)
	{
	OptionalInt number=Arrays.stream(data).reduce(Integer::sum);
     return number.orElse(0);  
		 /*	int sum=0;
		for(int value:data)
		{
			sum+=value;
		}
		return sum;
*/	}
	
	public int calculateSumUsingDataService()
	{
		int [] data=someDataService.retrieveAllData();
		int sum=0;
		for(int value:data)
		{
			sum+=value;
		}
		return sum;
	}
}
