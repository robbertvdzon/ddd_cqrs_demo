package com.vdzon.ordersystem.read.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bestelling")
public class Bestelling {
    @Id
    private long id;
    private ZonedDateTime bestelDatum = ZonedDateTime.now();
    private long klantId;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "bestelling_id")
    private List<Bestelregel> bestelRegels = new ArrayList<>();
    private double totaalBedrag;

    public Bestelling(long bestelId) {
        this.id = bestelId;
    }

    public void addRegel(String productNaam, int aantal, double stuksprijs) {
        bestelRegels.add(new Bestelregel(productNaam, aantal, stuksprijs));
    }
}
