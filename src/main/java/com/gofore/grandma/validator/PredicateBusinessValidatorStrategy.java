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
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Data
@Accessors(fluent = true)
@AllArgsConstructor
@Component("PredicateBusinessValidatorStrategy")
public class PredicateBusinessValidatorStrategy implements IBusinessStrategy {
	
	List<BiPredicate<Receipe,WorthPayload>> validators=null;
	List<Function<Optional<Receipe>,HashMap<String,String>>> actions=null;
	
	public PredicateBusinessValidatorStrategy() {
		validators = new ArrayList<BiPredicate<Receipe,WorthPayload>>();
		actions = new ArrayList<Function<Optional<Receipe>,HashMap<String,String>>>();
		//A
		BiPredicate<Receipe,WorthPayload> predA=(x,y)->
		{return x==null;
		};
		
		//pred.test func.apply
		Function<Optional<Receipe>,HashMap<String,String>> funcA= jj -> {
			HashMap<String,String> ret=new LinkedHashMap<String,String>();
			ret.put(REFERENCE,jj.get().reference() );
			ret.put(WORTH, INVALID);
			return ret;
			
		};
		validators.add(predA);
		actions.add(funcA);
		//B
		BiPredicate<Receipe,WorthPayload> predB2= (x,y) -> {
			 return x.prepare_time()<2 && (y.who().equals(GRANDSON) || y.who().equals(DAUGHTER)) ;
		};
		//pred.test func.apply
		Function<Optional<Receipe>,HashMap<String,String>> funcB= jj -> {
			HashMap<String,String> ret=new LinkedHashMap<String,String>();
			ret.put(REFERENCE, jj.get().reference());
			ret.put(WORTH, YEAH);
			int minutes=UtilsGrandma.stringHourToInt(String.valueOf(jj.get().prepare_time()));
         	ret.put(PREPARE_TIME,UtilsGrandma.sumMinutestoHour(minutes, -15));
			ret.put(PORTIONS, String.valueOf(jj.get().portions()));
			return ret;
			
		};
		validators.add(predB2);
		actions.add(funcB);
		//C
		BiPredicate<Receipe,WorthPayload> predC2= (x,y) -> {
			 return x.prepare_time()<2 && (y.who().equals(HUSBAND)) ;
		};
		//pred.test func.apply
		Function<Optional<Receipe>,HashMap<String,String>> funcC= jj -> {
			HashMap<String,String> ret=new LinkedHashMap<String,String>();
			ret.put(REFERENCE, jj.get().reference());
			ret.put(WORTH, YEAH);
			ret.put(PREPARE_TIME, String.valueOf(jj.get().prepare_time()));
			return ret;
			
		};
		validators.add(predC2);
		actions.add(funcC);
		//D
		BiPredicate<Receipe,WorthPayload> predD2= (x,y) -> {
			 return x.prepare_time()==2 && (y.who().equals(GRANDSON) || y.who().equals(DAUGHTER)) ;
		};
		//pred.test func.apply
		Function<Optional<Receipe>,HashMap<String,String>> funcD= jj -> {
			HashMap<String,String> ret=new LinkedHashMap<String,String>();
			ret.put(REFERENCE, jj.get().reference());
			ret.put(WORTH, YEAH);
			int minutes=UtilsGrandma.stringHourToInt(String.valueOf(jj.get().prepare_time()));
         	ret.put(PREPARE_TIME,UtilsGrandma.sumMinutestoHour(minutes, -10));
			ret.put(PORTIONS, String.valueOf(jj.get().portions()));
			return ret;
			
		};
		validators.add(predD2);
		actions.add(funcD);
		//E
		BiPredicate<Receipe,WorthPayload> predE2= (x,y) -> {
			 return x.prepare_time()==2 && (y.who().equals(HUSBAND) ) ;
		};
		//pred.test func.apply
		Function<Optional<Receipe>,HashMap<String,String>> funcE= jj -> {
			HashMap<String,String> ret=new LinkedHashMap<String,String>();
			ret.put(REFERENCE, jj.get().reference());
			ret.put(WORTH, MEH);
			int minutes=UtilsGrandma.stringHourToInt(String.valueOf(jj.get().prepare_time()));
            ret.put(PREPARE_TIME,UtilsGrandma.sumMinutestoHour(minutes, 10));
			
			return ret;
			
		};
		validators.add(predE2);
		actions.add(funcE);
		//F
		BiPredicate<Receipe,WorthPayload> predF2= (x,y) -> {
			 return x.prepare_time()>2 && (y.who().equals(GRANDSON) ) ;
		};
		//pred.test func.apply
		Function<Optional<Receipe>,HashMap<String,String>> funcF= jj -> {
			HashMap<String,String> ret=new LinkedHashMap<String,String>();
			ret.put(REFERENCE, jj.get().reference());
			ret.put(WORTH, YEAH);
			int minutes=UtilsGrandma.stringHourToInt(String.valueOf(jj.get().prepare_time()));
            ret.put(PREPARE_TIME,UtilsGrandma.sumMinutestoHour(minutes, -5));
			
			
			return ret;
			
		};
		validators.add(predF2);
		actions.add(funcF);
		//G
		BiPredicate<Receipe,WorthPayload> predG2= (x,y) -> {
			 return x.prepare_time()>2 && (y.who().equals(DAUGHTER) ) ;
		};
		//pred.test func.apply
		Function<Optional<Receipe>,HashMap<String,String>> funcG= jj -> {
			HashMap<String,String> ret=new LinkedHashMap<String,String>();
			ret.put(REFERENCE, jj.get().reference());
			ret.put(WORTH, MEH);
			ret.put(PREPARE_TIME,String.valueOf(jj.get().prepare_time()));
			return ret;
			
		};
		validators.add(predG2);
		actions.add(funcG);
		//H
		BiPredicate<Receipe,WorthPayload> predH2= (x,y) -> {
			 return x.prepare_time()>2 && (y.who().equals(HUSBAND) ) ;
		};
		//pred.test func.apply
		Function<Optional<Receipe>,HashMap<String,String>> funcH= jj -> {
			HashMap<String,String> ret=new LinkedHashMap<String,String>();
			ret.put(REFERENCE, jj.get().reference());
			ret.put(WORTH, NAH);
			return ret;
			
		};
		validators.add(predH2);
		actions.add(funcH);
		
	}

	@Override
	public HashMap<String, String> worth(Receipe r, WorthPayload wp) {
		// TODO Auto-generated method stub
		int length = validators.size();
		HashMap<String,String> ret = null;
		Receipe rnull=new Receipe();
		rnull.reference(wp.reference());
		//only for case 1
		Optional<Receipe> oR = Optional.of(Optional.ofNullable(r).orElse(rnull));
		
		
		// for each predicate until predicate ll be true, when is true execute the associate function
		for(int i=0; i< length;  i++) {
			if(validators.get(i).test(r, wp)) {
				ret=actions.get(i).apply(oR);
				return ret;
			}
				
		}
		ret=new HashMap<String,String>();
		return ret;
	}
	
	
}
