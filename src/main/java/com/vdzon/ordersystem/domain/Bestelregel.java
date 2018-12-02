package com.vdzon.ordersystem.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Bestelregel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String product;
    private int aantal;
    private double stuksPrijs;

    public Bestelregel(String product, int aantal, double stuksPrijs) {
        this.product = product;
        this.aantal = aantal;
        this.stuksPrijs = stuksPrijs;
    }
}
