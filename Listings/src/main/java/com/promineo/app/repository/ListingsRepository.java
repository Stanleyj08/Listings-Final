package com.promineo.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promineo.app.entity.Listings;
@Repository
public interface ListingsRepository extends JpaRepository<Listings,Integer> {
	


}
