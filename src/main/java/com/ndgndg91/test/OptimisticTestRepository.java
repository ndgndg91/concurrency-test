package com.ndgndg91.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OptimisticTestRepository extends JpaRepository<OptimisticTest, Long> {
}
