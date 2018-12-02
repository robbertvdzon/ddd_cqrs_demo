package com.vdzon.ordersystem.write.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "klant")
public class Klant {
    @Id
    private long id;
    private String naam;
}
