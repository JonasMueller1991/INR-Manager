package com.inr.inrmanager.jpa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Inr {
    @Id
    @GeneratedValue
    @Column( nullable = false)
    private Long id;

    @Column(nullable = false)
    private Float inrValue;
    @Column(nullable = false)
    private LocalDate date;

    public Inr() {
        this.id = null;
        this.inrValue = null;
        this.date = null;
    }

}
