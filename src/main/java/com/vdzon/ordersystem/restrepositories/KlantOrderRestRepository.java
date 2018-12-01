package com.vdzon.ordersystem.restrepositories;

import com.vdzon.ordersystem.domain.KlantOrder;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface KlantOrderRestRepository extends PagingAndSortingRepository<KlantOrder, Long> {
}
