package com.inr.inrmanager.repository;

import com.inr.inrmanager.jpa.model.Inr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InrRepository extends JpaRepository<Inr, Long> {
}
