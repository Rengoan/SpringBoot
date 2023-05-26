package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Coche;

public interface CochesDao extends JpaRepository<Coche, String> {

}
