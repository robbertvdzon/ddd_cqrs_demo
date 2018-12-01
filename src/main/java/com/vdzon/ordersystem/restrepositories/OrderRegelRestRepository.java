package com.vdzon.ordersystem.restrepositories;

import com.vdzon.ordersystem.domain.Klant;
import com.vdzon.ordersystem.domain.OrderRegel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "orderregels", path = "orderregels")
public interface OrderRegelRestRepository extends PagingAndSortingRepository<OrderRegel, Long> {
    List<OrderRegel> findByProductId(@Param("productId") long productId);
}
