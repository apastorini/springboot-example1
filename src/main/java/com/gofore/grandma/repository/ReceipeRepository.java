package com.gofore.grandma.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.gofore.grandma.model.Receipe;

@Repository
public interface ReceipeRepository extends PagingAndSortingRepository<Receipe,Long>, JpaSpecificationExecutor<Receipe>  {
	
	public Receipe findByReference(String reference);
	

	public List<Receipe> findByName(String name);
	
	@Query("SELECT m FROM Receipe m WHERE m.name LIKE %:name%")
	public List<Receipe> searchByNameike(@Param("name") String name);

	@Query(value = "SELECT m FROM Receipe m WHERE m.name LIKE %:name% order by m.prepare_time asc")
    List<Receipe> findReceipeByPrepareTimeAsc(@Param("name") String name);    // list of all employee ascending order by name

	@Query(value = "SELECT m FROM Receipe m WHERE m.name LIKE %:name% order by m.prepare_time desc")
    List<Receipe> findReceipeByPrepareTimeDesc(@Param("name") String name);    // list of all employee descending order by name


	public void saveAndFlush(Receipe createReceipeWorth);

	
	
}
