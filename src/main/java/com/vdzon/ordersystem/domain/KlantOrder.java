package com.vdzon.ordersystem.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Data
@Entity
public class KlantOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private ZonedDateTime orderDate = ZonedDateTime.now();
    private long klantId;
}
