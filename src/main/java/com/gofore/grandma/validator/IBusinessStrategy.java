package com.gofore.grandma.validator;

import java.util.HashMap;

import com.gofore.grandma.model.Receipe;
import com.gofore.grandma.requesttypes.WorthPayload;

public interface IBusinessStrategy {
	static final String HUSBAND = "HUSBAND";
	static final String GRANDSON = "GRANDSON";
	static final String DAUGHTER = "DAUGHTER";
	static final String REFERENCE = "reference";
	static final String WORTH = "worth";
	static final String WHO = "who";
	static final String PORTIONS = "portions";
	static final String PREPARE_TIME = "prepare_time";
	static final String NAH = "nah";
	static final String MEH = "meh";
	static final String YEAH = "yeah";
	static final String INVALID = "INVALID";
	
	
	
	
	HashMap<String, String> worth(Receipe r,WorthPayload wp);
	
}
