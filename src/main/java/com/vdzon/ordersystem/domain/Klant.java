package com.vdzon.ordersystem.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Klant {
    @Id
    private long id;
    private String naam;
}
