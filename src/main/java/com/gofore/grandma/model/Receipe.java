package com.gofore.grandma.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;


@ApiModel(description = "Receipt Domain")
@Validated
@Data
@Accessors(fluent = true)
@AllArgsConstructor
@Entity
public class Receipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@ApiModelProperty(required = true, value = "")
	@JsonProperty("name")
	@Column(name="name") 
	private String name;
	@Column(unique=true,name="reference")
	@JsonProperty("reference")
	private String reference;
	@JsonProperty("link")
	@Column(name="link")
	private String link;
	@JsonProperty("portions")
	@Column(name="portions")
	private Integer portions;
	@ApiModelProperty(required = true, value = "0")
	@JsonProperty("prepare_time")
	@Column(name="prepare_time")
	private Integer prepare_time;
	@ApiModelProperty(required = true, value = "")
	@JsonProperty("meal")
	@Column(name="meal")
	private String meal;
	@JsonProperty("instructions")
	@Column(name="instructions")
	private String instructions;
	@ApiModelProperty(required = true)
	@JsonProperty("ingredients")
	@OneToMany(mappedBy = "receipe", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Ingredients> ingredients = new ArrayList<>();

	
	public Receipe(){
		
	}
	
	// Copy Constructor
	public Receipe(Receipe receipe) {
		this.instructions = receipe.instructions;
		this.link = receipe.link;
		this.meal = receipe.meal;
		this.name = receipe.name;
		this.portions = receipe.portions;
		this.prepare_time = receipe.prepare_time();
		this.reference = receipe.reference;
		this.ingredients = receipe.ingredients;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Receipe))
			return false;
		Receipe Receipe = (Receipe) o;
		return Objects.equals(this.id, Receipe.id) && Objects.equals(this.name, Receipe.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name);
	}

	@Override
	public String toString() {
		return "Receipe{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
	}
}
