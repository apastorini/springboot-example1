package com.gofore.grandma.responsetypes;

import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.AccessLevel;

@Getter
@Setter
@Data
@Accessors(fluent = true,chain = true)
public abstract class ResponseType {
	
	
	@ApiModelProperty(required = true, value = "")
	@JsonProperty("errorCode")
	@Getter(AccessLevel.PROTECTED)
	protected String errorCode;
	@ApiModelProperty(required = true, value = "")
	@JsonProperty("message")
	@Getter(AccessLevel.PROTECTED)
	protected String message;
	
	

}
