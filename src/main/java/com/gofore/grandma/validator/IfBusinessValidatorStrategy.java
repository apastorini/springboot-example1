package com.gofore.grandma.validator;


import com.gofore.grandma.model.Receipe;
import com.gofore.grandma.requesttypes.WorthPayload;
import com.gofore.grandma.utils.UtilsGrandma;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Data
@Accessors(fluent = true)
@Component("IfBusinessValidatorStrategy")
public class IfBusinessValidatorStrategy implements IBusinessStrategy {
	
	
	
	public IfBusinessValidatorStrategy() {
	}

	@Override
	public HashMap<String, String> worth(Receipe r, WorthPayload worthPayload) {
		// TODO Auto-generated method stub
		HashMap<String,String> ret=new LinkedHashMap<String,String>();
		if(r==null) {
			//A
			ret.put(REFERENCE, worthPayload.reference());
			ret.put(WORTH, INVALID);
		}
		else {
			//B
			if(r.prepare_time()<2 && (worthPayload.who().equals(GRANDSON) || (worthPayload.who().equals(DAUGHTER)))){
				ret.put(REFERENCE, worthPayload.reference());
				ret.put(WORTH, YEAH);
                int minutes=UtilsGrandma.stringHourToInt(String.valueOf(r.prepare_time()));
            	ret.put(PREPARE_TIME,UtilsGrandma.sumMinutestoHour(minutes, -15));
				ret.put(PORTIONS, String.valueOf(r.portions()));
			
			 
			}else if(r.prepare_time()<2 && (worthPayload.who().equals(HUSBAND) )){
				//c
				ret.put(REFERENCE, worthPayload.reference());
				ret.put(WORTH, YEAH);
                ret.put(PREPARE_TIME,String.valueOf(r.prepare_time()));
				
			
			 
			}else if(r.prepare_time()==2 && (worthPayload.who().equals(GRANDSON) || (worthPayload.who().equals(DAUGHTER)))){
				//D
				ret.put(REFERENCE, worthPayload.reference());
				ret.put(WORTH, YEAH);
                int minutes=UtilsGrandma.stringHourToInt(String.valueOf(r.prepare_time()));
            	ret.put(PREPARE_TIME,UtilsGrandma.sumMinutestoHour(minutes, -10));
				ret.put(PORTIONS, String.valueOf(r.portions()));
			
			 
			}else if(r.prepare_time()==2 && (worthPayload.who().equals(HUSBAND))){
				//E
				ret.put(REFERENCE, worthPayload.reference());
				ret.put(WORTH, MEH);
				int minutes=UtilsGrandma.stringHourToInt(String.valueOf(r.prepare_time()));
	            ret.put(PREPARE_TIME,UtilsGrandma.sumMinutestoHour(minutes, 10));
				
			
			 
			}else if(r.prepare_time()>2 && (worthPayload.who().equals(GRANDSON) )){
				//F
				ret.put(REFERENCE, worthPayload.reference());
				ret.put(WORTH, YEAH);
				int minutes=UtilsGrandma.stringHourToInt(String.valueOf(r.prepare_time()));
	            ret.put(PREPARE_TIME,UtilsGrandma.sumMinutestoHour(minutes, -5));
				
							
			
			 
			}else if(r.prepare_time()>2 && (worthPayload.who().equals(DAUGHTER))){
				//G
				ret.put(REFERENCE, worthPayload.reference());
				ret.put(WORTH, MEH);
				ret.put(PREPARE_TIME,String.valueOf(r.prepare_time()));
				
			
			 
			}else if(r.prepare_time()>2 && (worthPayload.who().equals(HUSBAND) )){
				//H
				ret.put(REFERENCE, worthPayload.reference());
				ret.put(WORTH,NAH);
			
			}/*else{
				//Default
				ret.put(REFERENCE, worthPayload.reference());
				ret.put(WORTH, "nothingToDo");
                ret.put(PREPARE_TIME,String.valueOf(r.prepare_time()));
				ret.put("portions", String.valueOf(r.portions()));
			}*/
			
		}
		return ret;
	}
	
	
}