package com.gofore.grandma.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gofore.grandma.error.ErrorsCode;
import com.gofore.grandma.exception.BusinessException;
import com.gofore.grandma.model.Ingredients;
import com.gofore.grandma.model.Receipe;
import com.gofore.grandma.requesttypes.WorthPayload;
import com.gofore.grandma.responsetypes.ListReceipeResponseType;
import com.gofore.grandma.responsetypes.ReceipeResponseType;
import com.gofore.grandma.service.ReceipeService;
import com.gofore.grandma.utils.UtilsGrandma;
import com.gofore.grandma.validator.ValuesAllowed;



@Validated
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api-receipes")
public class ReceipeController {

	private static final Logger LOG = LoggerFactory.getLogger(ReceipeController.class);

	@Autowired
	private final ReceipeService receipeService;

	ReceipeController(ReceipeService receipeService) {
		this.receipeService = receipeService;
	}

	private ReceipeResponseType createReceipeResponseType(Receipe r, String errorCode) {
		ReceipeResponseType result = new ReceipeResponseType();
		result.receipe(r);
		result.errorCode(errorCode.split("-")[0]);
		result.message(errorCode.split("-")[1]);
		return result;
	}

	@PostMapping(value = "/receipes", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ReceipeResponseType> createReceipe(@RequestBody Receipe receipe) {
		LOG.info("CREATE RECEIPE");
		ReceipeResponseType result;
		try {

			if (receipe.reference() != null) {
				Receipe reference = receipeService.findByReference(receipe.reference());
				if (reference != null) {
					// Reference exist
					result = createReceipeResponseType(null, ErrorsCode.CODE_101);
					return new ResponseEntity<ReceipeResponseType>(result, HttpStatus.INTERNAL_SERVER_ERROR);
				} else {
					Receipe _receipe = receipeService.save(new Receipe(receipe));

					result = createReceipeResponseType(_receipe, ErrorsCode.CODE_100);
					return new ResponseEntity<ReceipeResponseType>(result, HttpStatus.CREATED);
				}
			} else {
				Receipe _receipe = receipeService.save(new Receipe(receipe));

				result = createReceipeResponseType(_receipe, ErrorsCode.CODE_100);
				return new ResponseEntity<ReceipeResponseType>(result, HttpStatus.CREATED);
			}
		} catch (BusinessException e) {
			result = createReceipeResponseType(null, e.code());
			result.message(e.message());
			return new ResponseEntity<ReceipeResponseType>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			result = createReceipeResponseType(null, ErrorsCode.CODE_102);
			return new ResponseEntity<ReceipeResponseType>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/receipes/search/filter")
	public ResponseEntity<ListReceipeResponseType> searchReceipe(@RequestParam("query") String query,
			@RequestParam("sort") String sort) {
		// If sort!=0 the order is asc
		List<Receipe> listReceipe = receipeService.findByNameContains(query, Integer.valueOf(sort));
		ListReceipeResponseType result = new ListReceipeResponseType();
		result.receipe(listReceipe);
		result.errorCode(ErrorsCode.CODE_100.split("-")[0]);
		result.message(ErrorsCode.CODE_100.split("-")[1]);
		return new ResponseEntity<ListReceipeResponseType>(result, HttpStatus.CREATED);

	}

	@GetMapping("/receipes/worth")
	public ResponseEntity<HashMap<String, String>> worth(
			@RequestParam(name = "reference", required = true) String reference,
			@RequestParam(name = "who", required = false) @ValuesAllowed(values = { "GRANDSON", "DAUGHTER",
					"HUSBAND" }) String who) {

		HashMap<String, String> r = receipeService.worth(new WorthPayload(reference, who));
		return new ResponseEntity<HashMap<String, String>>(r, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, path = "/ping")
	public ResponseEntity<String> getPing() {
		return ResponseEntity.ok("pong");
	}

	@PostConstruct
	public void init() {
		// run when bean is created
		Receipe r1 ;
		try {
			// receipeRepository.deleteAll();
			r1=new Receipe();
			r1.instructions("instructions\": \"Make sauce. Steam bok choy and chicken. Carry on steaming. Pour sauce over.");
			r1.link("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
			r1.meal("lunch");
			r1.name("Bittman Chinese Chicken With Bok Choy");
			r1.portions(10);
			r1.prepare_time(2);
			r1.reference("12345A");
			// Ingredients
			List<Ingredients> ingredients = new ArrayList<Ingredients>();
			Ingredients i1 = new Ingredients();
			i1.amount(2);
			i1.name("Chicken Breast");
			i1.unit("unit");
			ingredients.add(i1);
			Ingredients i2 = new Ingredients();
			i2.amount(2);
			i2.name("Bok Choy");
			i2.unit("unit");
			ingredients.add(i2);
			Ingredients i3 = new Ingredients();
			i3.amount(1);
			i3.name("Sauce");
			i3.unit("unit");
			ingredients.add(i3);
			r1.ingredients(ingredients);
			receipeService.save(r1);
			//B
			Receipe r2=new Receipe();
			r2.reference("12345B");
			r2.prepare_time(1);
			r2.instructions("instructions\": \"Make sauce. Steam bok choy and chicken. Carry on steaming. Pour sauce over.");
			r2.link("https://www.youtube.com/watch?v=ttttbbbb");
			r2.meal("lunch");
			r2.name(" Chinese pig With Bok Choy");
			r2.portions(5);
			// Ingredients
			ingredients = new ArrayList<Ingredients>();
			i1 = new Ingredients();
			i1.amount(2);
			i1.name("Pig Breast");
			i1.unit("unit");
			ingredients.add(i1);
			i2 = new Ingredients();
			i2.amount(2);
			i2.name("Bob Choy");
			i2.unit("unit");
			ingredients.add(i2);
			i3 = new Ingredients();
			i3.amount(1);
			i3.name("Spaghetti");
			i3.unit("unit");
			ingredients.add(i3);
			r2.ingredients(ingredients);
			receipeService.save(r2);
			//

			for (int i = 0; i < 3; i++) {
				r1=new Receipe();
				r1.instructions("Agregar azucar, miel, sal." + i);
				r1.link("http://youtube.com/1" + i);
				r1.meal(i % 2 == 0 ? "dinner" : "lunch");
				r1.name(i % 2 == 0 ? "Arandanos Cake" : "Arandanos Parrots");
				r1.portions(5);
				r1.prepare_time(i+1);
				r1.reference(UtilsGrandma.generateString());
				// Ingredients
			    ingredients = new ArrayList<Ingredients>();
				i1 = new Ingredients();
				i1.amount(i % 2 == 0 ? 10 : 2);
				i1.name(i % 2 == 0 ? "Calamar" : "apple");
				i1.unit("unit");
				ingredients.add(i1);
				i2 = new Ingredients();
				i2.amount(10);
				i2.name("Calamar");
				i2.unit("unit");
				ingredients.add(i2);
				i3 = new Ingredients();
				i3.amount(10);
				i3.name("Calamar");
				i3.unit("unit");
				ingredients.add(i3);
				r1.ingredients(ingredients);
				receipeService.save(r1);
			}
		} catch (Exception e) {

		}

	}
	
	

}
