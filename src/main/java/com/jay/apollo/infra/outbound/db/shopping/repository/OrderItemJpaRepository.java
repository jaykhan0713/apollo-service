package com.jay.apollo.infra.outbound.db.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.apollo.infra.outbound.db.shopping.entity.OrderItemJpaEntity;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemJpaEntity, OrderItemJpaEntity.OrderItemId> {}
