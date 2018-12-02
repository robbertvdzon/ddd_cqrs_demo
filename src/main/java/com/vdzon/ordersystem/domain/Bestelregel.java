package com.vdzon.ordersystem.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Bestelregel {
    @Id
    private long id;
    @ManyToOne
    private Bestelling bestelling;
    private String product;
    private int aantal;
    private double stuksPrijs;
}
