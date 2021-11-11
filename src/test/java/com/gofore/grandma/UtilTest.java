package com.gofore.grandma;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


import com.gofore.grandma.controller.ReceipeController;
import com.gofore.grandma.model.Ingredients;
import com.gofore.grandma.model.Receipe;
import com.gofore.grandma.utils.UtilsGrandma;




public class UtilTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(ReceipeController.class);

	public static Receipe createReceipe(int i) {
		Receipe r1 = new Receipe();
		r1.instructions("Agregar azucar, miel, sal." + i);
		r1.link("http://youtube.com/1" + i);
		r1.meal(i%2==0?"dinner":"lunch");
		r1.name(i%2==0?"Arandanos Cake":"Arandanos Parrots");
		r1.portions(5);
		r1.prepare_time(i%2==0?10:3);
		r1.reference(UtilsGrandma.generateString());
		// Ingredients
		List<Ingredients> ingredients = new ArrayList<Ingredients>();
		Ingredients i1 = new Ingredients();
		i1.amount(i%2==0?10:2);
		i1.name(i%2==0?"Calamar":"apple");
		i1.unit("unit");
		ingredients.add(i1);
		Ingredients i2 = new Ingredients();
		i2.amount(10);
		i2.name("Calamar");
		i2.unit("unit");
		ingredients.add(i2);
		Ingredients i3 = new Ingredients();
		i3.amount(10);
		i3.name("Calamar");
		i3.unit("unit");
		ingredients.add(i3);
		r1.ingredients(ingredients);
		return r1;
	}
	
	
	public static Receipe createReceipeWorth(String reference, int prepared_time) {
		Receipe r1 = new Receipe();
		r1.reference(reference);
		r1.instructions("Agregar azucar, miel, sal." );
		r1.link("http://youtube.com/1" );
		r1.meal("dinner");
		r1.name("Pascualina");
		r1.portions(5);
		r1.prepare_time(prepared_time);
		// Ingredients
		List<Ingredients> ingredients = new ArrayList<Ingredients>();
		Ingredients i1 = new Ingredients();
		i1.amount(5);
		i1.name("rice");
		i1.unit("unit");
		ingredients.add(i1);
		Ingredients i2 = new Ingredients();
		i2.amount(10);
		i2.name("Calamar");
		i2.unit("unit");
		ingredients.add(i2);
		Ingredients i3 = new Ingredients();
		i3.amount(10);
		i3.name("Calamar");
		i3.unit("unit");
		ingredients.add(i3);
		r1.ingredients(ingredients);
		return r1;
	}

	@Test
	public void testConvertHourFunction() throws Exception {
		LOG.info("TESTING UTIL");
		assertThat(UtilsGrandma.sumMinutestoHour(120, -5)).isEqualTo("1.55");
		assertThat(UtilsGrandma.sumMinutestoHour(120, -10)).isEqualTo("1.50");
		
	}
	
	@Test
	public void testStringHourToInt() throws Exception {
		
		assertThat(UtilsGrandma.stringHourToInt("2.5")).isEqualTo(170);
		assertThat(UtilsGrandma.stringHourToInt("2.05")).isEqualTo(125);
		assertThat(UtilsGrandma.stringHourToInt("-0.05")).isEqualTo(-5);
		
	}
}