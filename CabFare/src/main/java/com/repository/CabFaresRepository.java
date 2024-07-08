package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.CabFares;

public interface CabFaresRepository extends JpaRepository<CabFares, Integer> {

	@Query("select f.price from CabFares f where f.fare_from = :fare_from and f.fare_to = :fare_to")
	public float getFarePrice(@Param("fare_from") String fare_from, @Param("fare_to") String fare_to);
}
