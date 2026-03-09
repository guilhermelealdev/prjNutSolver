package com.nutsolver.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nutsolver.demo.entities.Fase;

@Repository
public interface FaseRepository extends JpaRepository<Fase, Long>{

}
