package com.gofore.grandma.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(fluent = true)
@Entity
public class Ingredients {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	@ApiModelProperty(required = true, value="")
	@JsonProperty("name")
	private String name;
	@ApiModelProperty(required = true, value="0")
	@JsonProperty("amount")
	private Integer amount;
	@ApiModelProperty(required = true, value="")
	@JsonProperty("unit")
	private String unit;
	@ManyToOne
	@JoinColumn(name = "receipe_id" )
	Receipe receipe;
	
	
	public Ingredients(){
		
	}
	
	public Ingredients(String name,Integer amount,String unit, Receipe receipe) {
		this.name=name;
		this.amount=amount;
		this.unit=unit;
		this.receipe=receipe;
	}
	
}
