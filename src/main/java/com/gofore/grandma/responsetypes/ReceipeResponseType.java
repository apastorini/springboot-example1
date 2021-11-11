package com.gofore.grandma.responsetypes;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.gofore.grandma.model.Receipe;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true)
public class ReceipeResponseType extends ResponseType{
	
	@ApiModelProperty(required = true, value = "")
	@JsonProperty("receipe")
	private Receipe receipe;
	
	
	

}
