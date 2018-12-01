package com.vdzon.ordersystem.restrepositories;

import com.vdzon.ordersystem.domain.Klant;
import com.vdzon.ordersystem.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "producten", path = "producten")
public interface ProductRestRepository extends PagingAndSortingRepository<Product, Long> {
}
