package com.jay.apollo.infra.outbound.db.shopping.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.apollo.infra.outbound.db.shopping.entity.OrderJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderJpaRepository extends JpaRepository<OrderJpaEntity, UUID> {

    @Query("""
        SELECT o FROM OrderJpaEntity o
                JOIN FETCH o.orderItems oi
                        JOIN FETCH oi.product
                                WHERE o.userId = :userId
        """)
    List<OrderJpaEntity> findByUserId(@Param("userId") UUID userId);

}
