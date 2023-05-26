package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer> {
	
	@Query("SELECT c FROM Curso c WHERE c.precio BETWEEN :minPrice AND :maxPrice")
	List<Curso> findBy(double minPrice, double maxPrice);

}
