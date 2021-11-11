package com.gofore.grandma.responsetypes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gofore.grandma.model.Receipe;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class ListReceipeResponseType  extends ResponseType {
	
	@ApiModelProperty(required = true, value = "")
	@JsonProperty("receipe")
	private List<Receipe> receipe=new ArrayList<Receipe>();

}
