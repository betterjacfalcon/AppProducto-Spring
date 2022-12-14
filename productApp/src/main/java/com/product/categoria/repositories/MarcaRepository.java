package com.product.categoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.categoria.entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{

}
