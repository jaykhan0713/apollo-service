package com.jay.apollo.infra.outbound.db.shopping.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.apollo.infra.outbound.db.shopping.entity.OrderJpaEntity;

public interface OrderJpaRepository extends JpaRepository<OrderJpaEntity, UUID> {}
