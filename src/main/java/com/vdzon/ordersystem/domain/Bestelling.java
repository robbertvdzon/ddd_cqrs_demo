package com.vdzon.ordersystem.domain;

import com.vdzon.ordersystem.domain.validation.ValidBestelling;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@ValidBestelling
public class Bestelling {
    @Id
    private long id;
    private ZonedDateTime bestelDatum = ZonedDateTime.now();
    private long klantId;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Bestelregel> bestelRegels = new ArrayList<>();

    public Bestelling(long bestelId) {
        this.id = bestelId;
    }

    public void addRegel(String productNaam, int aantal, double stuksprijs) {
        bestelRegels.add(new Bestelregel(productNaam, aantal, stuksprijs));
    }
}
