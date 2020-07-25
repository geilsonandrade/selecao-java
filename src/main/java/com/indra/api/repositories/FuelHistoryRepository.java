package com.indra.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.api.domain.FuelHistory;

@Repository
public interface FuelHistoryRepository extends JpaRepository<FuelHistory, Long> {

}