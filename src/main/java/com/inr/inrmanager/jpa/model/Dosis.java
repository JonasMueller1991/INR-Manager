package com.inr.inrmanager.jpa.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Dosis extends DbEntity {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Integer dosis;

    @Column(nullable = false)
    private LocalDate date;

    public Dosis() {
        this.id = null;
        this.dosis = null;
        this.date = null;
    }
}
