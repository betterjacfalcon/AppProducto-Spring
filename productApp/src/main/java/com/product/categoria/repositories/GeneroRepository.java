package com.product.categoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.categoria.entities.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{

}
