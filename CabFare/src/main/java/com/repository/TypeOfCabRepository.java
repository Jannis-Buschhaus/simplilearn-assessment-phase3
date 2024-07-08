package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.TypeOfCab;

@Repository
public interface TypeOfCabRepository extends JpaRepository<TypeOfCab, Integer>{

	@Query("select t.factor from TypeOfCab t where t.cabType = :cabType")
	public float getPriceFactor(@Param("cabType") String cabType);
}
