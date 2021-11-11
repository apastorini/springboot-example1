package com.gofore.grandma.requesttypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
public class WorthPayload {
	public WorthPayload() {
		// TODO Auto-generated constructor stub
	}
	@ApiModelProperty(required = true, value = "")
	@JsonProperty("reference")
	private String reference;
	@ApiModelProperty(required = false, value = "")
	@JsonProperty("who")
	private String who;
}
