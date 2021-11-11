package com.gofore.grandma.validator;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.gofore.grandma.model.Receipe;
import com.gofore.grandma.requesttypes.WorthPayload;

@Component("BusinessValidator")
public class BusinessValidator {
	
	@Autowired
	@Qualifier("PredicateBusinessValidatorStrategy")
	IBusinessStrategy bi;
	
		 
	public HashMap<String, String> worth(Receipe r,WorthPayload wp){
		 return bi.worth(r, wp);
	 }
	

}
