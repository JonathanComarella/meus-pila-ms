package com.jcomarella.meuspilams.repository;

import com.jcomarella.meuspilams.model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, UUID> {
}
