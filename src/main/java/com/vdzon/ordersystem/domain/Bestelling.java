package com.vdzon.ordersystem.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Data
@Entity
public class Bestelling {
    @Id
    private long id;
    private ZonedDateTime bestelDatum = ZonedDateTime.now();
    private long klantId;
}
