package com.gofore.grandma.service;



import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gofore.grandma.error.ErrorsCode;
import com.gofore.grandma.exception.BusinessException;
import com.gofore.grandma.model.Receipe;
import com.gofore.grandma.repository.ReceipeRepository;
import com.gofore.grandma.requesttypes.WorthPayload;
import com.gofore.grandma.utils.UtilsGrandma;
import com.gofore.grandma.validator.PredicateBusinessValidatorStrategy;
import com.gofore.grandma.validator.BusinessValidator;


@Service
public class ReceipeService {

	
	@Autowired
	private final ReceipeRepository receipeRepository;
	
	@Autowired
	@Qualifier("BusinessValidator")
	private BusinessValidator bv;
	
  

    public ReceipeService(ReceipeRepository receipeRepository) {
        this.receipeRepository = receipeRepository;
    }

    public Iterable<Receipe> list() {
        return receipeRepository.findAll();
    }

    public Receipe save(Receipe receipe) throws BusinessException {
    	//If receipe.reference is null create one
    	if(receipe.link()==null && receipe.instructions()==null)
    		throw new BusinessException(ErrorsCode.CODE_101.split("-")[0], ErrorsCode.CODE_101.split("-")[1]);
        
    	if(receipe!=null && (receipe.reference()==null || receipe.reference().length()==0 ))
        	receipe.reference(UtilsGrandma.generateString());
    	return receipeRepository.save(receipe);
    }
    
    public Receipe findByReference(String reference){
		return receipeRepository.findByReference(reference);
    	
    }
    
    public List<Receipe> findByNameContains(String name,Integer order)  {

    	//return receipeRepository.findByNameAndSort(name,Sort.by((order==0)?Sort.Direction.DESC:Sort.Direction.ASC, "prepare_time"));
    	if(order==0){
    		return receipeRepository.findReceipeByPrepareTimeDesc(name);
    	}else {
    		return receipeRepository.findReceipeByPrepareTimeAsc(name);
    	}
    	
    	
    	
	}

	
    
    public HashMap<String, String> worth(WorthPayload wp) {
    	Receipe r=receipeRepository.findByReference(wp.reference());
    	//bv=new BusinessValidator(new PredicateBusinessValidatorStrategy());
    	if(wp==null || wp.who()==null || wp.who().length()==0) {
    		HashMap<String,String> ret=new HashMap<String,String>();
    		ret.put("worth", "Nothing to Do");
    		return ret;
    	}else
    		return bv.worth(r, wp);

	}


	

	

}