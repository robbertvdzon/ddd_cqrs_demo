package com.vdzon.ordersystem.read.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "bestelregel")
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
