package com.gofore.grandma;





import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.gofore.grandma.model.Ingredients;
import com.gofore.grandma.model.Receipe;
import com.gofore.grandma.repository.ReceipeRepository;
import com.gofore.grandma.utils.UtilsGrandma;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(SpringRunner.class)
@DataJpaTest 
public class ReceipeRepositoryTest {

	
	private List<Receipe> receipts = new ArrayList<Receipe>();
	
	
	
	@Autowired
	private ReceipeRepository receipeRepository;
	
	
	@Before
   	public void runBeforeAllTestMethods() {
		receipts = new ArrayList<Receipe>();
		try {
			//receipeRepository.deleteAll();
			Receipe r;
			for (int i = 0; i < 3; i++) {
				r=UtilTest.createReceipe(i);
				r=receipeRepository.save(r);
				receipts.add(r);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		

	}
	
	@AfterAll
   	public void runAfterAllTestMethods() {
		receipeRepository.deleteAll();
	}
	
	
	

	@Test
	public void createReceipe_getReceipe() throws Exception {
		try {
		
			Receipe r=UtilTest.createReceipe(10);
			r=receipeRepository.save(r);
			Receipe rcomp;
			rcomp=receipeRepository.findByReference(r.reference());
			Assertions.assertThat(rcomp.id()).isEqualTo(r.id());
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Test
	public void searchReceipeLength_getReceipeAscLength() throws Exception {
		try {
		
			
			List<Receipe> rcomp=receipeRepository.findReceipeByPrepareTimeAsc("anos");
			Assertions.assertThat(rcomp.size()).isEqualTo(3);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Test
	public void searchReceipeCorrectOrder_getReceipeAscCorrectOrder() throws Exception {
		try {
		
			
			List<Receipe> rcomp=receipeRepository.findReceipeByPrepareTimeAsc("anos");
			Assertions.assertThat(rcomp.get(0).id()).isEqualTo(receipts.get(1).id());
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Test
	public void searchReceipeCorrectOrder_getReceipeDescCorrectOrder() throws Exception {
		try {
		
			
			List<Receipe> rcomp=receipeRepository.findReceipeByPrepareTimeDesc("anos");
			Assertions.assertThat(rcomp.get(0).id()).isEqualTo(receipts.get(0).id());
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
