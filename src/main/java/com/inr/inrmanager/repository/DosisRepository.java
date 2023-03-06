package com.inr.inrmanager.repository;

import com.inr.inrmanager.jpa.model.Dosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DosisRepository extends JpaRepository<Dosis,Long> {
}
