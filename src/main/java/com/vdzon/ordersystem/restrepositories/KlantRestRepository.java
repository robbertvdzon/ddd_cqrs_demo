package com.vdzon.ordersystem.restrepositories;

import com.vdzon.ordersystem.domain.Klant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "klanten", path = "klanten")
public interface KlantRestRepository extends PagingAndSortingRepository<Klant, Long> {
}
