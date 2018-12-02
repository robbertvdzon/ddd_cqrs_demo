package com.vdzon.ordersystem.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Bestelregel {
    @Id
    private long id;
    private long orderId;
    private String product;
    private int aantal;
    private double stuksPrijs;
}
