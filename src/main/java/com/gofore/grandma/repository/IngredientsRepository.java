package com.gofore.grandma.repository;



import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.gofore.grandma.model.Ingredients;

@Repository
public interface IngredientsRepository extends CrudRepository<Ingredients,Long> {


}
