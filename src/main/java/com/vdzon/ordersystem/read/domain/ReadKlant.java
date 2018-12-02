package com.vdzon.ordersystem.read.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "klant")
public class ReadKlant {
    @Id
    private long id;
    private String naam;
}
